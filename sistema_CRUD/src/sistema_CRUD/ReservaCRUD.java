package sistema_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import factory.ConnectionFactory;
import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;

public class ReservaCRUD {
	public static void cadastrar(Reserva reserva) {
		String sql = "INSERT INTO Reserva(idCliente, idDestino, idPacote, dataPartida, dataRetorno, valorTotal)" + "VALUES(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setInt(3, reserva.getPacote().getId());
			pstm.setDate(4, new Date(reserva.getDataPartida().getTime()));
			pstm.setDate(5, new Date(reserva.getDataRetorno().getTime()));
			pstm.setFloat(6, reserva.getValorTotal());
			
			
			pstm.execute();
			System.out.println("Reserva cadastrada com sucesso!!!");
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
	
	public static void listarReserva(){
		String sql = "SELECT * FROM Reserva";
		List<Reserva> Reservas = new ArrayList<Reserva>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet resultado = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			resultado = pstm.executeQuery();
			
			while (resultado.next()) {
				
				int id = resultado.getInt("idReserva");
				int idCliente = resultado.getInt("idCliente");
				int idDestino = resultado.getInt("idDestino");
				int idPacote = resultado.getInt("idPacote");
				
				Cliente cliente = ClienteCRUD.consultarCliente(idCliente);
				Destino destino = DestinoCRUD.consultarDestino(idDestino);
				Pacote pacote = PacoteCRUD.consultarPacote(idPacote);
				
				Date dataPartida = resultado.getDate("dataPartida");
				Date dataRetorno = resultado.getDate("dataRetorno");
				float valorTotal = resultado.getFloat("valorTotal");
				
				Reservas.add(new Reserva(id ,dataPartida, dataRetorno, cliente, destino, pacote, valorTotal));
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
		for (Reserva reserva : Reservas) {
			reserva.mostrar();
		}
	}
	
	public static Reserva consultarReserva(int id) {
		String sql = "select * from reserva WHERE idReserva = ?";

		Reserva reserva = new Reserva();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet resultado = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			resultado = pstm.executeQuery();
			
			if(resultado.next()) {
				int idCliente = resultado.getInt("idCliente");
				int idDestino = resultado.getInt("idDestino");
				int idPacote = resultado.getInt("idPacote");
				
				Cliente cliente = ClienteCRUD.consultarCliente(idCliente);
				Destino destino = DestinoCRUD.consultarDestino(idDestino);
				Pacote pacote = PacoteCRUD.consultarPacote(idPacote);
				
				reserva.setId(resultado.getInt("idReserva"));
				reserva.setCliente(cliente);
				reserva.setDestino(destino);
				reserva.setPacote(pacote);
				reserva.setDataPartida(resultado.getDate("dataPartida"));
				reserva.setDataRetorno(resultado.getDate("dataRetorno"));
				reserva.setValorTotal(resultado.getFloat("valorTotal"));				
			}
			
				
			
		} catch (Exception e) {
			System.out.println("Reserva nao encontrada.");
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
		
		return reserva;
	}
	
	public static void atualizar(Reserva reserva) {
		String sql = "UPDATE reserva SET idCliente = ?, idDestino = ?, idPacote = ?, dataPartida = ?, dataRetorno = ?, valorTotal = ? " + "WHERE idReserva = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setInt(3, reserva.getPacote().getId());
			pstm.setDate(4, new Date(reserva.getDataPartida().getTime()));
			pstm.setDate(5, new Date(reserva.getDataRetorno().getTime()));
			pstm.setFloat(6, reserva.getValorTotal());
			pstm.setInt(7, reserva.getId());
			
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
		String sql = "DELETE FROM reserva WHERE idReserva = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.criarConexao();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			System.out.println("Reserva removida com sucesso!!!");
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
