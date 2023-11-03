package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.UserModel;
import conection.DatabaseConnection;

public class UserDAO extends UserModel {

	public UserDAO(String name, String cpf, String email, int idUser, String senha) {
		super(name,cpf,email, idUser, senha);
		
	}

	public static void create(UserModel usuario) {
		String sql = "INSERT INTO user(nome, cpf_unico, email, senha)" + "VALUES(?,?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;

			try {
				conn = DatabaseConnection.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getCpf());
				pstm.setString(3, usuario.getEmail());
				pstm.setString(4, usuario.getSenha());
				
				pstm.execute();
				
				
	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		
		
	}
	
	public static void remove(int id) {
		String sql = "DELETE FROM user WHERE id_user = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;

			try {
				conn = DatabaseConnection.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);				
		
				
				pstm.execute();
				
				
	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	
	public static void update(UserModel usuario) {
	String sql = "UPDATE user SET nome = ?, cpf_unico = ?, email = ?, senha = ? WHERE id_user = ? ";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
	
				try {
					conn = DatabaseConnection.createConnectionToMysql();
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, usuario.getNome());
					pstm.setString(2, usuario.getCpf());	
					pstm.setString(3, usuario.getEmail());
					pstm.setString(4, usuario.getSenha());
					pstm.setInt(5, usuario.getId());
			
					
					pstm.execute();
					
			
		
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if (pstm != null) {
							pstm.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
	
	public static List<UserModel>getUsers(){
		
		String sql = "SELECT * FROM user";
		
		
		List<UserModel> usuarios = new ArrayList<UserModel>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

			try {
				conn = DatabaseConnection.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					UserModel usuario = new UserModel();
					
					usuario.setId(rset.getInt("id_user"));
					usuario.setNome(rset.getString("nome"));
					usuario.setCpf(rset.getString("cpf_unico"));
					usuario.setEmail(rset.getString("email"));
					
					usuarios.add(usuario);
					
					
					
				}
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
					
					if(rset != null) {
						rset.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return usuarios;
	}
	
	
	
	public static UserModel findById(int userId) {
	    String sql = "SELECT * FROM user WHERE id_user = ?";
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;
	    UserModel usuario = null;

	    try {
	        conn = DatabaseConnection.createConnectionToMysql();
	        pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, userId); 
	        rset = pstm.executeQuery();

	        if (rset.next()) {
	            usuario = new UserModel();
	            usuario.setId(rset.getInt("id_user"));
	            usuario.setNome(rset.getString("nome"));
	            usuario.setCpf(rset.getString("cpf_unico"));
	            usuario.setEmail(rset.getString("email"));
	            usuario.setSenha(rset.getString("senha"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	            if (rset != null) {
	                rset.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return usuario;
	}
	}
	
	
	
	
	
	
	


