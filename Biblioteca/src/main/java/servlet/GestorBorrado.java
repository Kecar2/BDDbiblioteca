package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GestorBorrado")
public class GestorBorrado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestorBorrado() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BaseDatos bd=new BaseDatos();
		bd.borraLibro(id);
		//----------------------------------------------
		ArrayList<Libro> libros = bd.listar();//select
		request.setAttribute("lista", libros);
		request.getRequestDispatcher("bienvenida.jsp")
		       .forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
