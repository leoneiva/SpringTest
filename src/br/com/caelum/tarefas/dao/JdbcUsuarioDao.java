package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.modelo.Usuario;

public class JdbcUsuarioDao {

	private Connection connection;

	public JdbcUsuarioDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// VERIFICA USU�RIO
	public boolean existeUsuario(Usuario usuario) {
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}}
		
	
	// ADICIONA USU�RIO
		public void adiciona(Usuario usuario){
			String sql2 = "insert into usuarios (id, login, senha) " +
						"values (?,?,?)";
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql2);
				stmt.setInt(1, usuario.getId());
				stmt.setString(2, usuario.getLogin());
				stmt.setString(3, usuario.getSenha());
				//stmt.setDate(2, new Date(tarefa.getDataFinalizacao().getTimeInMillis())); 
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}}
			
			// LISTA USUARIOS
			public List<Usuario> lista(){
			
				try {
					List<Usuario> usuarios = new ArrayList<Usuario>();
					PreparedStatement stmt = this.connection
							.prepareStatement("select * from usuarios");
					ResultSet rs = stmt.executeQuery();
					// tamanho para pegar o tamanho da lista e fazer a pagian��o
				int	tamanho = 0;
					while (rs.next()) {
						// adiciona a user na lista
						usuarios.add(populaUser(rs));
						tamanho = tamanho + 1;
					}
					
		System.out.println(tamanho + " tamanho da lista");

					rs.close();
					stmt.close();

					return usuarios;
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
		// continuar a listagem, mas em um novo m�todo
			
			private Usuario populaUser(ResultSet rs) throws SQLException {
				Usuario usuario = new Usuario();

				// popula o objeto tarefa
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setPerfil(rs.getInt("perfil"));
				usuario.setSenha(rs.getString("senha"));

			// Retorna o objeto no while
				return usuario;
			}
			
			
			public void remove(Usuario usuario) {

				if (usuario.getId() == 0) {
					throw new IllegalStateException("Id não deve ser nula.");
				}

				String sql = "delete from usuarios where id = ?";
				PreparedStatement stmt;
				try {
					stmt = connection.prepareStatement(sql);
					stmt.setLong(1, usuario.getId());
					stmt.execute();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		}

