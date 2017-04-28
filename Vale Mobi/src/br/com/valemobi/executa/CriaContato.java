package br.com.valemobi.executa;

import br.com.valemobi.bean.Cliente;
import br.com.valemobi.dao.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class CriaContato {

	public static void main(String[] args) {
		
		// Criação dos Clientes
		 Cliente c1 = new Cliente();
		 c1.setIdCustomer(299);
		 c1.setCpfCnpj("43036076916");
		 c1.setActive(true);
		 c1.setNmCustomer("Guilherme");
		 c1.setVlTotal(2500);
		 
		 Cliente c2 = new Cliente();
		 c2.setIdCustomer(1540);
		 c2.setCpfCnpj("42173634869");
		 c2.setActive(true);
		 c2.setNmCustomer("Erick");
		 c2.setVlTotal(400);
		 
		 
		 Cliente c3 = new Cliente();
		 c3.setIdCustomer(2000);
		 c3.setCpfCnpj("41460555822");
		 c3.setActive(true);
		 c3.setNmCustomer("Matheus");
		 c3.setVlTotal(2500);
		 
		 Cliente c4 = new Cliente();
		 c4.setIdCustomer(2300);
		 c4.setCpfCnpj("16006462254");
		 c4.setActive(true);
		 c4.setNmCustomer("Lucas");
		 c4.setVlTotal(3000);
		 
		 Cliente c5 = new Cliente();
		 c5.setIdCustomer(2002);
		 c5.setCpfCnpj("12006462254");
		 c5.setActive(true);
		 c5.setNmCustomer("Bruno");
		 c5.setVlTotal(2200);
		 
		 Cliente c6 = new Cliente();
		 c6.setIdCustomer(2006);
		 c6.setCpfCnpj("12003462254");
		 c6.setActive(true);
		 c6.setNmCustomer("Ze");
		 c6.setVlTotal(2400);
		 
		 	 // Adicionando os cliente no banco
		 ClienteDAO dao = new ClienteDAO();
		 dao.adiciona(c1);
		 dao.adiciona(c2);
		 dao.adiciona(c3);
		 dao.adiciona(c4);
		 dao.adiciona(c5);
		 dao.adiciona(c6);
		 
		 // Realizando as chamadas
		System.out.println("|________________________________________________________________________________________________");
		 try {
			double media = dao.getMediaSaldo(500, 1500, 2700);
			System.out.println("                                         Sua média é: " + media);
			System.out.println("|________________________________________________________________________________________________");
			System.out.println("|_________________________________________DADOS UTILIZADOS_______________________________________");
			System.out.println("|");
			List<Cliente> clientes = dao.listaClientes(500, 1500, 2700);
			for(Cliente c : clientes) {
				System.out.println("" +
						"|id: " + c.getIdCustomer() +
						":: Nome  " + c.getNmCustomer() +
						":: CPF/CNPJ  " + c.getCpfCnpj() +
						":: " + (c.isActive() ? "Ativo" : "Inativo") +
						":: Valor Total  " + c.getVlTotal());
				System.out.println(
						"|________________________________________________________________________________________________");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
