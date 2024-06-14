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
import com.Entity.Account;


@WebServlet("/login")
public class Launch2 extends HttpServlet{

	Connection con =ConnectionFactory.getCon();
	
	AccountDao acDao = new AccountDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String upass = req.getParameter("upass");
		
		String res = acDao.checkUser(con, uid, upass);
		Account account = acDao.readAccount(con, uid);
		HttpSession session = req.getSession();
		req.getSession().removeAttribute("msg");
		if(res.equals("exits"))
		{
			session.setAttribute("check", uid);
			session.setAttribute("ac", account);
			resp.sendRedirect("account.jsp");
		}
		else
		{
			session.setAttribute("msg","Invalid Userid or password");
			resp.sendRedirect("login.jsp");
		}
	}
}
