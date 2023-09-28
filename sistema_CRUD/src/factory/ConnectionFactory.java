package factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
private static final String LOGIN = "root";
private static final String SENHA = "123456";
private static final String URL = "jdbc:mysql://localhost:3306/daviagens";

public static Connection criarConexao() throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
	
	return conexao;
}

public static void main(String[]args) throws Exception{
	Connection con = criarConexao();
	
	if(con != null) {
		System.out.println("O pai ta on!!!");
		con.close();
	}
}
}