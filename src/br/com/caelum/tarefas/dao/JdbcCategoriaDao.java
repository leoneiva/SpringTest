package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Categoria;

public class JdbcCategoriaDao {

	private Connection connection;

	public JdbcCategoriaDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	// ADICIONA PERFIL
		public void adiciona(Categoria categoria){
			String sql2 = "insert into categoria (id, categoria) " +
						"values (?,?)";
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql2);
				stmt.setInt(1, categoria.getId());
				stmt.setString(2, categoria.getCategoria());

				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}}
		
		
		
		// ALTERA USU¡RIO
		public void altera(Categoria categoria) {
			String sql = "update categoria set categoria = ? where id = ?";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, categoria.getCategoria());
				stmt.setInt(2, categoria.getId());				
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		
			
			// LISTA PERFIL
			public List<Categoria> lista(){
			
				try {
					List<Categoria> categoria = new ArrayList<Categoria>();
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from categoria");
					ResultSet rs = stmt.executeQuery();
					// tamanho para pegar o tamanho da lista e fazer a pagianÁ„o
				int	tamanho = 0;
					while (rs.next()) {
						// adiciona a user na lista
						categoria.add(populaConsulta(rs));
						tamanho = tamanho + 1;
					}
					
		System.out.println(tamanho + " tamanho da lista");

					rs.close();
					stmt.close();

					return categoria;
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				// CONTINUA L¡ EM BAIXO COM POPULAUSER
			}
			
			
			
			//BUSCA POR ID
			public Categoria buscaPorId(Long id) {

				if (id == null) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				try {
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from categoria where id = ?");
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
			public void remove(Categoria categoria) {

				if (categoria.getId() == 0) {
					throw new IllegalStateException("Id n√£o deve ser nula.");
				}

				String sql = "delete from categoria where id = ?";
				PreparedStatement stmt;
				try {
					stmt = connection.prepareStatement(sql);
					stmt.setLong(1, categoria.getId());
					stmt.execute();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		// Final para listar user ou buscar por id
			
			private Categoria populaConsulta(ResultSet rs) throws SQLException {
				Categoria categoria = new Categoria();

				// popula o objeto tarefa
				categoria.setId(rs.getInt("id"));
				categoria.setCategoria(rs.getString("categoria"));

			// Retorna o objeto no while
				return categoria;			}
			
			
			
			
		}

