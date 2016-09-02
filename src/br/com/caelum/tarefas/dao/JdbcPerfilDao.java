package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Perfil;

public class JdbcPerfilDao {

	private Connection connection;

	public JdbcPerfilDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	// ADICIONA PERFIL
		public void adiciona(Perfil perfil){
			String sql2 = "insert into perfil (id, perfil) " +
						"values (?,?)";
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql2);
				stmt.setInt(1, perfil.getId());
				stmt.setString(2, perfil.getPerfil());

				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}}
		
		
		
		// ALTERA USU¡RIO
		public void altera(Perfil perfil) {
			String sql = "update perfil set perfil = ? where id = ?";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, perfil.getPerfil());
				stmt.setInt(2, perfil.getId());				
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		
			
			// LISTA PERFIL
			public List<Perfil> lista(){
			
				try {
					List<Perfil> perfil = new ArrayList<Perfil>();
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from perfil");
					ResultSet rs = stmt.executeQuery();
					// tamanho para pegar o tamanho da lista e fazer a pagianÁ„o
				int	tamanho = 0;
					while (rs.next()) {
						// adiciona a user na lista
						perfil.add(populaConsulta(rs));
						tamanho = tamanho + 1;
					}
					
		System.out.println(tamanho + " tamanho da lista");

					rs.close();
					stmt.close();

					return perfil;
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				// CONTINUA L¡ EM BAIXO COM POPULAUSER
			}
			
			
			
			//BUSCA POR ID
			public Perfil buscaPorId(Long id) {

				if (id == null) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				try {
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from perfil where id = ?");
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
			public void remove(Perfil perfil) {

				if (perfil.getId() == 0) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				String sql = "delete from perfil where id = ?";
				PreparedStatement stmt;
				try {
					stmt = connection.prepareStatement(sql);
					stmt.setLong(1, perfil.getId());
					stmt.execute();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		// Final para listar user ou buscar por id
			
			private Perfil populaConsulta(ResultSet rs) throws SQLException {
				Perfil perfil = new Perfil();

				// popula o objeto tarefa
				perfil.setId(rs.getInt("id"));
				perfil.setPerfil(rs.getString("perfil"));

			// Retorna o objeto no while
				return perfil;			}
			
			
			
			
		}

