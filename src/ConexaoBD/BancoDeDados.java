package ConexaoBD;

import java.sql.*;


public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/agenda?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "159753";
		System.out.println("erro  uhuuu\t=D");

		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
			System.out.println("Conectou  uhuuu\t=D");

		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage() );
		}
	}
	
	public boolean estaConectado() {
		if(this.connection != null)
			return true;
		else
			return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoDeDados dbb = new BancoDeDados(); 
		dbb.conectar();
	}

}
