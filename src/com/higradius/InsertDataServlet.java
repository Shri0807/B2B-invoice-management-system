package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDataServlet
 */
@WebServlet("/InsertDataServlet")
public class InsertDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDataServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement st = conn.prepareStatement("insert into mytable values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			st.setNull(1, Types.NULL);
			st.setNull(2, Types.NULL);
			st.setString(3, request.getParameter("customerno"));
			st.setString(4, request.getParameter("customername"));
			st.setNull(5, Types.NULL);
			st.setNull(6, Types.NULL);
			st.setNull(7, Types.NULL);
			st.setNull(8, Types.NULL);
			st.setNull(9, Types.NULL);
			st.setNull(10, Types.NULL);
			st.setDate(11, Date.valueOf(request.getParameter("duedate")));
			st.setNull(12, Types.NULL);
			st.setNull(13, Types.NULL);
			st.setNull(14, Types.NULL);
			st.setDouble(15, Double.valueOf(request.getParameter("invoiceamount")));
			st.setNull(16, Types.NULL);
			st.setNull(17, Types.NULL);
			st.setDouble(18, Double.valueOf(request.getParameter("invoiceno")));
			st.setNull(19, Types.NULL);
			st.setNull(20, Types.NULL);
			st.setNull(21, Types.NULL);
			st.setNull(22, Types.NULL);
			st.setString(23, request.getParameter("notes"));
			st.executeUpdate();
			
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/H2HBABBA2886/");
		
	}

}
