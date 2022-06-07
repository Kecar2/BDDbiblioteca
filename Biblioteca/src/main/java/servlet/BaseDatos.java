package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {
	private Connection conexion;

	public BaseDatos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/biblioteca";
			this.conexion = DriverManager.getConnection(myUrl, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Libro> listar() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM LIBROS");
			while (rs.next()) {
				Libro l = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				libros.add(l);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return libros;
	}

	public boolean compruebaUsuario(String login, String password) {
		boolean check = false;
		try {
			Statement s = this.conexion.createStatement();
			String sql = "Select count(*) From Usuarios where " + "usuario = '" + login + "' and password = '"
					+ password + "'";
			System.out.println(sql);
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			if (rs.getInt(1) > 0)
				check = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return check;
	}

	public void insertaLibro(Libro l) {
		try {
			String sql = "insert into libros ( titulo,autor," + "editorial, fecha, categoria, novedad) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement s = this.conexion.prepareStatement(sql);
			// s.setInt(1,l.getId());
			s.setString(1, l.getTitulo());
			s.setString(2, l.getAutor());
			s.setString(3, l.getEditorial());
			s.setString(4, l.getFecha());
			s.setString(5, l.getCategoria());
			s.setInt(6, l.getNovedad());
			s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borraLibro(int id) {

		try {
			String sql = "delete from libros where id=" + id;
			Statement s = this.conexion.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Libro obtenerLibro(int id) {
		Libro l = null;
		try {
			String sql = "select * from libros where id=" + id;
			Statement s = this.conexion.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			l = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getInt(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public void actualizaLibro(Libro l) {
		try {
			String sql = "update libros set titulo=?, autor=?," + "editorial=?, fecha=?, categoria=?,novedad=?"
					+ "where id=?";
			PreparedStatement s = this.conexion.prepareStatement(sql);
			s.setString(1, l.getTitulo());
			s.setString(2, l.getAutor());
			s.setString(3, l.getEditorial());
			s.setString(4, l.getFecha());
			s.setString(5, l.getCategoria());
			s.setInt(6, l.getNovedad());
			s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
