package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Prioridade;

public class JdbcPrioridadeDao {

	private Connection connection;

	public JdbcPrioridadeDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	// ADICIONA PERFIL
		public void adiciona(Prioridade prioridade){
			String sql2 = "insert into prioridade (id, prioridade) " +
						"values (?,?)";
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql2);
				stmt.setInt(1, prioridade.getId());
				stmt.setString(2, prioridade.getPrioridade());

				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}}
		
		
		
		// ALTERA USU¡RIO
		public void altera(Prioridade prioridade) {
			String sql = "update prioridade set prioridade = ? where id = ?";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, prioridade.getPrioridade());
				stmt.setInt(2, prioridade.getId());				
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		
			
			// LISTA PERFIL
			public List<Prioridade> lista(){
			
				try {
					List<Prioridade> prioridade = new ArrayList<Prioridade>();
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from prioridade");
					ResultSet rs = stmt.executeQuery();
					// tamanho para pegar o tamanho da lista e fazer a pagianÁ„o
				int	tamanho = 0;
					while (rs.next()) {
						// adiciona a user na lista
						prioridade.add(populaConsulta(rs));
						tamanho = tamanho + 1;
					}
					
		System.out.println(tamanho + " tamanho da lista");

					rs.close();
					stmt.close();

					return prioridade;
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				// CONTINUA L¡ EM BAIXO COM POPULAUSER
			}
			
			
			
			//BUSCA POR ID
			public Prioridade buscaPorId(Long id) {

				if (id == null) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				try {
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from prioridade where id = ?");
					stmt.setLong(1, id);

					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {
						return populaConsulta(rs);
					}

					rs.close();
					stmt.close();

					return null;
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				// CONTINUAR L¡ EM BAIXO
			}
			
			
			

			
			// REMOVE USUARIO
			public void remove(Prioridade prioridade) {

				if (prioridade.getId() == 0) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				String sql = "delete from prioridade where id = ?";
				PreparedStatement stmt;
				try {
					stmt = connection.prepareStatement(sql);
					stmt.setLong(1, prioridade.getId());
					stmt.execute();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		// Final para listar user ou buscar por id
			
			private Prioridade populaConsulta(ResultSet rs) throws SQLException {
				Prioridade prioridade = new Prioridade();

				// popula o objeto tarefa
				prioridade.setId(rs.getInt("id"));
				prioridade.setPrioridade(rs.getString("prioridade"));

			// Retorna o objeto no while
				return prioridade;			}
			
			
			
			
		}

