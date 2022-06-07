package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GestorInsertar")
public class GestorInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestorInsertar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editorial = request.getParameter("editorial");
		String fecha = request.getParameter("fecha");
		String categoria = request.getParameter("categoria");
		int novedad = Integer.parseInt(request.getParameter("novedad"));
		Libro l=new Libro(id, titulo, autor, editorial,
				fecha, categoria, novedad);
		BaseDatos bd=new BaseDatos();
		bd.insertaLibro(l);
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
