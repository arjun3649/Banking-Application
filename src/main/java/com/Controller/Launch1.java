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


@WebServlet("/signup")
public class Launch1 extends HttpServlet{

	Connection con =ConnectionFactory.getCon();
	
	AccountDao acDao = new AccountDao();
	Transac_his_dao tDao = new Transac_his_dao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String upass = req.getParameter("upass");
		String uphone = req.getParameter("uphone");
		String uemail = req.getParameter("uemail");
		String city = req.getParameter("city");
		String acholname = req.getParameter("acholname");
		String actype = req.getParameter("actype");
		String atm = req.getParameter("atm");
		
		tDao.create_table(con, uid);
		String res = acDao.insert(con, uid, upass, uphone, uemail, city, acholname, actype, atm);
		
		HttpSession session = req.getSession();
		if(res.equals("inserted"))
		{
			session.setAttribute("msg","Account created");
			resp.sendRedirect("login.jsp");
		}
		else
		{
			session.setAttribute("msg","Account Creation Failed");
			resp.sendRedirect("signup.jsp");
		}
	}
}
