package com.higradius;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import java.sql.* ;
import java.text.*;
import java.util.*;

/**
 * Servlet implementation class FetchData
 */
@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchData() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/h2hbabba2886";
	static final String USER = "root"; 
	static final String PASS = "OmSaiRam#1234";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = null;
		Statement stat = null;
		List<POJO_class> demolist = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stat = conn.createStatement();
			String sql;
			sql = "select name_customer, cust_number, invoice_id, total_open_amount, due_in_date, predicted_clear_date, notes from mytable limit 15";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				POJO_class demo = new POJO_class();
				demo.setName_customer(rs.getString("name_customer"));
				demo.setCust_number(rs.getString("cust_number"));
				demo.setInvoice_id(rs.getDouble("invoice_id"));
				demo.setTotal_open_amount(rs.getDouble("total_open_amount"));
				demo.setDue_in_date(rs.getDate("due_in_date"));
				demo.setPredicted_clear_date(rs.getDate("predicted_clear_date"));
				demo.setnotes(rs.getString("notes"));
				demolist.add(demo);
			}
			Gson gson = new Gson();
			String jsonstring = gson.toJson(demolist);
			response.setContentType("/application/json");
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().write(jsonstring);
			} catch(IOException e) {
				e.printStackTrace();
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException se2) {
				}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
