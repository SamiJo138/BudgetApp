package com.cook;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // hte
        }
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test12" +
                    "user=minty&password=greatsqldb");

            throw new ClassNotFoundException("Connected to database");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            // hte(s
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        httpServletResponse.getWriter().print("Hello from servlet");
    }
}
