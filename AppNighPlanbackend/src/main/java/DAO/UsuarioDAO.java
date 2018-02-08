package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CreateUserDTO;
import models.Usuario;

/**
 *
 * @Javier Altmann
 */
public abstract class UsuarioDAO implements BaseDAO<CreateUserDTO> {

    final String GETALL = "SELECT * FROM usuarios";
    private Connection conn;
    final String AUTENTICACION = "SELECT  usuarios.id_usuario, usuarios.nombre,usuarios.apellido, usuarios.mail, usuarios.imagen_perfil, roles.id_rol\n"
            + "FROM usuarios \n"
            + "INNER JOIN roles_usuarios \n"
            + "ON usuarios.id_usuario = roles_usuarios.id_usuario\n"
            + "INNER JOIN roles \n"
            + "ON roles.id_rol = roles_usuarios.id_rol\n"
            + "WHERE roles.id_rol = 2 AND usuarios.mail = ? AND usuarios.password = ? ";

    final String CREAR_USUARIO = "INSERT INTO usuarios ("
            + " nombre,"
            + " apellido,"
            + " mail,"
            + " password,"
            + " imagen_perfil ) VALUES ("
            + " ?, ?, ?, ?, ?)";

    final String CREAR_ROL_USUARIO = "INSERT INTO usuarios ("
            + " id_rol,"
            + " id_usuario) VALUES ("
            + " 2, ?)";

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> user = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();

            while (rs.next()) {
                user.add(parseObject(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en la conexion a la base de datos", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en la conexion a la base de datos", ex);
                }

                if (stat != null) {
                    try {
                        stat.close();
                    } catch (SQLException ex) {

                    }
                }
            }

        }
        return user;
    }

    public Usuario autenticacionUsuario(Usuario user) throws DAOException, SQLException {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = conn.prepareStatement(AUTENTICACION);
            stat.setString(1, user.getMail());
            stat.setString(2, user.getPassword());
            rs = stat.executeQuery();

            while (rs.next()) {

                parseUserLoginObject(rs, user);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en la query", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en la conexion a la base de datos", ex);
                }

                if (stat != null) {
                    try {
                        stat.close();
                    } catch (SQLException ex) {

                    }
                }
            }
            user.setPassword(null);
        }
        return user;
    }

    private Usuario parseObject(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String mail = rs.getString("mail");
        String password = rs.getString("password");
        String imagen_perfil = rs.getString("imagen_perfil");
        Usuario user = new Usuario(nombre, apellido, mail, password, imagen_perfil);
        return user;

    }

    private Usuario parseUserLoginObject(ResultSet rs, Usuario user) throws SQLException {
        user.setId_usuario(rs.getInt("id_usuario"));
        user.setNombre(rs.getString("nombre"));
        user.setApellido(rs.getString("apellido"));
        user.setMail(rs.getString("mail"));
        user.setImagen_perfil(rs.getString("imagen_perfil"));

        return user;
    }

    @Override
    public void crear(CreateUserDTO user) throws DAOException {
        PreparedStatement ps = null;
        try {
            ps  = conn.prepareStatement(CREAR_USUARIO);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getMail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getImagen_perfil());
            
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            
            conn.rollback();
            
        }finally{
             
                if (ps != null) {
                    try {
                        ps.close();
                    } catch(SQLException ex) {

                    }
                }
            }
        }
        
    
    }


