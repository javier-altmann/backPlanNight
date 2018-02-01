package api;

import DAO.DAOException;
import DAO.MysqlDaoManager;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApiService {
String response;
PreparedStatement usuario;
private MysqlDaoManager connection;  

public ApiService() throws SQLException {
        this.connection = new MysqlDaoManager();
    }

final String QUERYUSUARIO = "INSERT INTO usuarios (nombre,apellido,mail,password,imagen_perfil) VALUES(?,?,?,?,?)";

    

  public void CrearUsuario(CreateUserDTO user) throws SQLException, DAOException{
  try{
        usuario = connection.getConn().prepareStatement(QUERYUSUARIO);
  
        usuario.setString(1, user.getNombre());
        usuario.setString(2, user.getApellido());
        usuario.setString(3, user.getMail());
        usuario.setString(4, user.getPassword());
        usuario.setString(5, user.getImagen_perfil());
 
  
        usuario.executeUpdate();
  }catch(SQLException ex){
      throw new DAOException ("Fallo al insertar datos");
  }finally{
      if(usuario != null){
          usuario.close();
    }
 }
  
   }  
    }
