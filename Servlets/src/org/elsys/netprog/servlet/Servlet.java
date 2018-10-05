package org.elsys.netprog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getOutputStream().println("<html><body><font size=30>" +
				"<form method='POST'>" +
					"<input type='text' name='key' placeholder='Key' />" +
					"<input type='text' name='value' placeholder='Value' /> " +
					"<input type='submit' />" +
				"</form>" +	
				"</font></body></html>");
	}
	List<String> keyList = new ArrayList();
	List<String> valueList = new ArrayList();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		keyList.add(key);
		valueList.add(value);
		
		response.getOutputStream().println("<html><body><font size=30> " + key
				+ " " + value + "<br></font>");
		for(int i = 0; i < keyList.size(); i++) {
			response.getOutputStream().println("<font size=30> " + keyList.get(i)
					+ " " + valueList.get(i) + "<br></font></body></html>");
		}
	}

}
