package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditInvoiceServlet
 */
@WebServlet("/EditInvoiceServlet")
public class EditInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInvoiceServlet() {
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
			PreparedStatement st  = conn.prepareStatement("UPDATE mytable SET total_open_amount = ?, notes=? WHERE invoice_id=?;");
			st.setDouble(1, Double.valueOf(request.getParameter("invoiceamountedit")));
			st.setString(2, request.getParameter("notesedit"));
			st.setDouble(3, 23.0);
			
			st.executeUpdate();
			st.close();
			conn.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/H2HBABBA2886/");
	}

}
