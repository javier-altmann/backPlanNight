package api;

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
final String QUERYUSUARIO = "INSERT INTO usuarios (nombre,apellido,mail,password,imagen_perfil) VALUES(?,?,?,?,?)";

  public String CrearUsuario(CreateUserDTO user) throws SQLException{
  try{
  usuario = connection.getConn().prepareStatement(QUERYUSUARIO);
  
  usuario.setString(1, user.getNombre());
  usuario.setString(2, user.getApellido());
  usuario.setString(3, user.getMail());
  usuario.setString(4, user.getPassword());
  usuario.setString(5, user.getImagen_perfil());
 
  
  usuario.executeUpdate();
  connection.getConn().commit();
  }catch(Exception ex){
      connection.getConn().rollback();
  }finally{
      if(usuario != null){
          usuario.close();
    }
 }
  return response;
   }  
    }
