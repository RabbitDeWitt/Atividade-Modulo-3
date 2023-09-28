package sistema_CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Destino;


public class DestinoCRUD {
	public static void cadastrar(Destino destino) {
		String sql = "INSERT INTO destino(nome, valor, estado, pais)" + "VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setFloat(2, destino.getValor());
			pstm.setString(3,destino.getEstado());
			pstm.setString(4, destino.getPais());
			
			pstm.execute();
			System.out.println("Destino cadastrado com sucesso!!!");
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
	
	public static List<Destino> listarDestino(){
		String sql = "SELECT * FROM destino";
		List<Destino> destinos = new ArrayList<Destino>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet resultado = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			resultado = pstm.executeQuery();
			
			while (resultado.next()) {
				
				int id = resultado.getInt("iddestino");
				String nome = resultado.getString("nome");
				String estado = resultado.getString("estado");
				String pais = resultado.getString("pais");
				float valor = resultado.getFloat("valor");
				
				destinos.add(new Destino(id ,nome, estado, pais, valor));
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
		return destinos;
	}
	
	public static void atualizar(Destino destino) {
		String sql = "UPDATE destino SET nome = ?, estado = ?, pais = ?, valor = ?" + "WHERE idDestino = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getPais());
			pstm.setFloat(4, destino.getValor());
			pstm.setInt(5, destino.getIdDestino());
			
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
		String sql = "DELETE FROM destino WHERE idDestino = ?";
		
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
