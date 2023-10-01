package sistema_CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteCRUD {
		
		public static void cadastrar(Cliente cliente) {
			String sql = "INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte)" + "VALUES(?,?,?,?)";
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setDate(2, new Date(cliente.getDataNasc().getTime()));
				pstm.setString(3,cliente.getTelefone());
				pstm.setString(4, cliente.getNumPassaporte());
				
				pstm.execute();
				System.out.println("Cliente cadastrado com sucesso!!!");
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
		
		public static List<Cliente> listarCliente(){
			String sql = "SELECT * FROM Cliente";
			List<Cliente> Clientes = new ArrayList<Cliente>();
			
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet resultado = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				resultado = pstm.executeQuery();
				
				while (resultado.next()) {
					
					int id = resultado.getInt("idCliente");
					String nome = resultado.getString("nome");
					Date dataNasc = resultado.getDate("dataNasc");
					String telefone = resultado.getString("telefone");
					String numPassaporte = resultado.getString("numPassaporte");
					
					Clientes.add(new Cliente(id ,nome, dataNasc, telefone, numPassaporte));
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
			return Clientes;
		}

		public static Cliente consultarCliente(int id) {
			String sql = "select * from cliente WHERE idCliente = ?";
		
			Cliente cliente = new Cliente();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet resultado = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, id);
				resultado = pstm.executeQuery();
				
				resultado.next(); 
					
					cliente.setId(resultado.getInt("idCliente"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setDataNasc(resultado.getDate("dataNasc"));
					cliente.setTelefone(resultado.getString("telefone"));
					cliente.setNumPassaporte(resultado.getString("numPassaporte"));
					
				
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
			return cliente;
		}

		public static void atualizar(Cliente cliente) {
			String sql = "UPDATE cliente SET nome = ?, dataNasc = ?, telefone = ?, numPassaporte = ?" + "WHERE idCliente = ?";
			Connection con = null;
			PreparedStatement pstm = null;
			
			try {
				con = ConnectionFactory.criarConexao();
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				pstm.setDate(2, new Date(cliente.getDataNasc().getTime()));
				pstm.setString(3, cliente.getTelefone());
				pstm.setString(4, cliente.getNumPassaporte());
				pstm.setInt(5, cliente.getId());
				
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
			String sql = "DELETE FROM cliente WHERE IdCliente = ?";
			
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
