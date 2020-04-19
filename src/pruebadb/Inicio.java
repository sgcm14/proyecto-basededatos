package pruebadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Inicio {

	public static void main(String[] args) {
		
		//config base de datos
		final String URLBD ="jdbc:mysql://localhost:3306/academico";
		final String USER = "root";
		final String CLAVE = "root";
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URLBD,USER,CLAVE);
			
			//insert
			String sqlInsert = "INSERT into profesor(nombre,dni) VALUES('Sammy','44221133')";
			
			//update
			String sqlUpdate = "UPDATE profesor set nombre = ? where id = ?";
			
			/*PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			
			ps.setString(1, "Samm");
			ps.setInt(2, 5);
			
			ps.executeUpdate();*/
			
			
			//listar
			String sqlListar = "SELECT * from profesor";
			
			PreparedStatement ps = conn.prepareStatement(sqlListar);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("LISTA DE PROFES");
			System.out.println("================");
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				
				System.out.println(id+" "+nombre+" "+dni);
				
			}
			
			
			ps.close();
			
			System.out.println("Prueba correcta");
			
			
		} catch (Exception e) {
			System.out.println("ERRROR DE BD");
			e.printStackTrace();
		}
		
		
		

	}

}
