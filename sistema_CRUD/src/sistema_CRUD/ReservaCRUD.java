package sistema_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import factory.ConnectionFactory;
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
}
