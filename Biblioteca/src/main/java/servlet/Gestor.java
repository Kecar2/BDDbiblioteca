package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gestor
 */
@WebServlet("/Gestor")
public class Gestor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int pepe;
    public Gestor() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    	throws Exception {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		BaseDatos bd = new BaseDatos();
		//if (login.equals("pepe") && password.equals("pepe")) { 
		if (bd.compruebaUsuario(login, password)) {	
			//------------------------------------------//			
			ArrayList<Libro> libros = bd.listar();
			//-------------------------------------------/
			request.setAttribute("lista", libros);
			request.getRequestDispatcher("bienvenida.jsp")
			                    .forward(request, response);
    	}else 
			response.sendRedirect("index.html");			
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	/*protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("<h1>Se ha recibido un PUT</h1>");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("<h1>Se ha recibido un DELETE</h1>");
	}*/
		

}
