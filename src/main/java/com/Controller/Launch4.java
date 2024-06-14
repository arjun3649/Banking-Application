package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.AccountDao;
import com.Dao.Transac_his_dao;
import com.Entity.Account;


@WebServlet("/deposit")
public class Launch4 extends HttpServlet{

	Connection con =ConnectionFactory.getCon();
	
	AccountDao acDao = new AccountDao();
	Transac_his_dao txnDao = new Transac_his_dao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String am = req.getParameter("am");
		
		
		String res= acDao.deposit(con, uid, am);
		txnDao.insertTrans(con, uid, "deposit", am);
		Account account = acDao.readAccount(con, uid);
		HttpSession session = req.getSession();
		if(res.equals("updated"))
		{
			session.setAttribute("check", uid);
			session.setAttribute("ac", account);
			session.setAttribute("msg","Money deposited");
			resp.sendRedirect("account.jsp");
		}
		else
		{
			session.setAttribute("msg","Failed");
			resp.sendRedirect("account.jsp");
		}
	}
}
