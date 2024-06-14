																																																									package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Entity.Account;

public class AccountDao {
	
	String result = "";

	public String insert(Connection con, String id, String upass, String contact, String email, String city, String acholname, String actype, String atm) {
		try {
			String sql = "insert into account values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, upass);
			ps.setString(3, contact);
			ps.setString(4, email);
			ps.setString(5, city);
			ps.setString(6, acholname);
			ps.setString(7, actype);
			ps.setString(8, atm);
			ps.setString(9, contact+"OBS");
			ps.setString(10, "0");

			int i = ps.executeUpdate();
			if (i == 1) {
				result = "inserted";
			} else {
				result = "failed";
			}
		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}

	}
	
	public String checkUser(Connection con, String id, String upass) {
		try {
			String sql = "select * from account";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				if (rs.getString(1).equals(id) && rs.getString(2).equals(upass)) {
					result = "exits";
					break;
				} else {
					result = "not exits";
				}
			}
		} catch (Exception e) {
			result = "not exits";
		} finally {
			return result;
		}
	}
	
	public Account readAccount(Connection con, String id)
	{
		Account ac = new Account();
		try
		{
			String sql = "select * from account where userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ac.setUserid(rs.getString(1));
				ac.setPass(rs.getString(2));
				ac.setContact(rs.getString(3));
				ac.setEmail(rs.getString(4));
				ac.setCity(rs.getString(5));
				ac.setAcholname(rs.getString(6));
				ac.setActype(rs.getString(7));
				ac.setAtm(rs.getString(8));
				ac.setAcno(rs.getString(9));
				ac.setBal(rs.getString(10));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			return ac;
		}
	}
	
	public String deposit(Connection con, String id, String am) {
		try {
			
			
			//read balance 
			String bal = "";
			String sql1 = "select * from account where userid=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, id);
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				
				bal=rs.getString("bal");
				
			}
			
			int balance = Integer.parseInt(bal);
			
			int am1 = Integer.parseInt(am);
			
			int updatedBal = balance+am1;
			
			
			
			
			//update balance
			String sql = "update account set bal=? where userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(updatedBal));
			ps.setString(2, id);
			

			int i = ps.executeUpdate();
			if (i == 1) {
				result = "updated";
			} else {
				result = "failed";
			}
		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}

	}
	
	
	
	
	public String withdraw(Connection con, String id, String am) {
		try {
			
			
			//read balance 
			String bal = "";
			String sql1 = "select * from account where userid=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, id);
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				
				bal=rs.getString("bal");
				
			}
			
			int balance = Integer.parseInt(bal);
			
			int am1 = Integer.parseInt(am);
			
			if(balance > am1)
			{
				int updatedBal = balance-am1;
				//update balance
				String sql = "update account set bal=? where userid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, String.valueOf(updatedBal));
				ps.setString(2, id);
				

				int i = ps.executeUpdate();
				if (i == 1) {
					result = "updated";
				} else {
					result = "failed";
				}
			}
			else
			{
				result="failed";
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}

	}
	
	
	public String mt(Connection con, String id, String am, String acb) {
		try {
			
			
			//read balance 
			String bal = "";
			String sql1 = "select * from account where userid=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, id);
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				
				bal=rs.getString("bal");
				
			}
			
			int balance = Integer.parseInt(bal);
			
			int am1 = Integer.parseInt(am);
			
			if(balance > am1)
			{
				int updatedBal = balance-am1;
				//update balance
				String sql = "update account set bal=? where userid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, String.valueOf(updatedBal));
				ps.setString(2, id);
				

				int i = ps.executeUpdate();
				if (i == 1) {
					result = "updated";
				} else {
					result = "failed";
				}
				
				
				//read balance of b
				String bal1 = "";
				String sql2 = "select * from account where acno=?";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setString(1, acb);
				ResultSet rs1 = ps1.executeQuery();

				while (rs1.next()) {
					
					bal1=rs1.getString("bal");
					
				}
				
				int upbalb= Integer.parseInt(bal1) + am1;
				
				//update balance of b
				String sql3 = "update account set bal=? where acno=?";
				PreparedStatement ps3 = con.prepareStatement(sql3);
				
				ps3.setString(1, String.valueOf(upbalb));
				ps3.setString(2, acb);
				

				int i1 = ps3.executeUpdate();
				
				
				
				
			}
			else
			{
				result="failed";
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}

	}
	
	
}









