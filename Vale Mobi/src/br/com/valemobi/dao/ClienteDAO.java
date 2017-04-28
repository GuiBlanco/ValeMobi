package br.com.valemobi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.valemobi.bean.Cliente;

public class ClienteDAO {

	public Connection connection;

	public ClienteDAO() {
		
	}

	public void adiciona(Cliente cliente) {
		String sql = "insert into tb_customer_account " + "(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) "
				+ "values (?,?,?,?,?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setLong(1, cliente.getIdCustomer());
			stmt.setString(2, cliente.getCpfCnpj());
			stmt.setString(3, cliente.getNmCustomer());
			stmt.setBoolean(4, cliente.isActive());
			stmt.setLong(5, cliente.getVlTotal());

			// executa
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public double getMediaSaldo(double valorTotal, long idInicial, long idFinal) throws SQLException {

		this.connection = new ConnectionFactory().getConnection();
		double resultado = 0;

		try {
			String sql = "Select avg(vl_total) from tb_customer_account where vl_total>? and id_customer between ? and ?;";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setDouble(1, valorTotal);
			stm.setLong(2, idInicial);
			stm.setLong(3, idFinal);
			stm.execute();

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				resultado = rs.getDouble(1);
			}

			rs.close();
			stm.close();

		} catch (SQLException e) {
			System.out.println("Erro ao fazer a pesquisa:");

		} finally {
			connection.close();
		}
		return resultado;
	}

	public List<Cliente> listaClientes(double valorTotal, long idInicial, long idFinal) throws SQLException {

		this.connection = new ConnectionFactory().getConnection();
		List<Cliente> lista = new ArrayList<>();
		// Realizando a conexão e o select
		try {
			String sql = "select * from tb_customer_account where  vl_total > ? and ( id_customer between ? and ?) order by vl_total desc";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setDouble(1, valorTotal);
			stm.setLong(2, idInicial);
			stm.setLong(3, idFinal);
			stm.execute();

			ResultSet rs = stm.executeQuery();
			// armazenando os valores buscados em variaveis
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCustomer(rs.getLong(1));
				c.setCpfCnpj(rs.getString(2));
				c.setNmCustomer(rs.getString(3));
				c.setActive(rs.getBoolean(4));
				c.setVlTotal(rs.getLong(5));
				lista.add(c);				
			}
			rs.close();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao imprimir");
		} finally {
			connection.close();
		}
		return lista;
	}
}
