package sistema_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Contato;

public class ContatoCRUD {
		
		public static void cadastrar(Contato contato) {
			String sql = "INSERT INTO contato(nome, email, mensagem) VALUES(?,?,?)";
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setString(3, contato.getMensagem());
				
				pstm.execute();
				System.out.println("Mensagem cadastrada com sucesso!!!");
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
		
		public static void listarContato(){
			String sql = "SELECT * FROM Contato";
			List<Contato> contatos = new ArrayList<>();
			
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet resultado = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				resultado = pstm.executeQuery();
				
				while (resultado.next()) {
					
					int id = resultado.getInt("idContato");
					String nome = resultado.getString("nome");
					String email = resultado.getString("email");
					String msg = resultado.getString("mensagem");
					
					contatos.add(new Contato(id ,nome, email, msg));
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
			for(Contato contato : contatos) {
				contato.mostrar();
			}
		}

		public static Contato consultarContato(int id) {
			String sql = "select * from contato WHERE idContato = ?";
		
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet resultado = null;
			Contato contato = new Contato();
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, id);
				resultado = pstm.executeQuery();
				
				if(resultado.next()) {
					contato.setId(resultado.getInt("idContato"));
					contato.setNome(resultado.getString("nome"));
					contato.setEmail(resultado.getString("email"));
					contato.setMensagem(resultado.getString("mensagem"));					
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
			return contato;
		}

		public static void atualizar(Contato contato) {
			String sql = "UPDATE contato SET nome = ?, email = ?, mensagem = ? WHERE idContato = ?";
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setString(3, contato.getMensagem());
				pstm.setInt(4, contato.getId());
				
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
			String sql = "DELETE FROM contato WHERE IdContato = ?";
			
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
