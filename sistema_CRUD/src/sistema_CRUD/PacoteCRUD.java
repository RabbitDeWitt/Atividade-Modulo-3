package sistema_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Pacote;

public class PacoteCRUD {
	public static void cadastrar(Pacote pacote) {
		String sql = "INSERT INTO Pacote(nome, valorPacote)" + "VALUES(?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pacote.getNome());
			pstm.setFloat(2, pacote.getValor());
			
			
			pstm.execute();
			System.out.println("Pacote cadastrado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Pacote> listarPacote(){
		String sql = "SELECT * FROM Pacote";
		List<Pacote> pacotes = new ArrayList<Pacote>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet resultado = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			resultado = pstm.executeQuery();
			
			while (resultado.next()) {
				
				int id = resultado.getInt("idPacote");
				String nome = resultado.getString("nome");
				float valor = resultado.getFloat("valorPacote");
				
				pacotes.add(new Pacote(id ,nome, valor));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pacotes;
	}
	
	public static void atualizar(Pacote pacote) {
		String sql = "UPDATE Pacote SET nome = ?, valorPacote = ?" + "WHERE idPacote = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pacote.getNome());
			pstm.setFloat(2, pacote.getValor());
			pstm.setInt(3, pacote.getId());
			
			pstm.execute();
			
			System.out.println("Registro alterado com sucesso!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void removerPorId(int id) {
		String sql = "DELETE FROM Pacote WHERE idPacote = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
