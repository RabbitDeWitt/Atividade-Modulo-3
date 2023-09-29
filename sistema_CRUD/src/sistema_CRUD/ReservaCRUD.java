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
	
	public static List<Reserva> listarReserva(){
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
		return Reservas;
	}
}
