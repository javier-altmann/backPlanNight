package DAO;

import java.util.List;
import models.Establecimientos;
import models.UsuariosDelGrupo;
import models.UsersInGroup;

/**
 *
 * @JavierAltmann
 */
public interface GruposDAO extends BaseDAO {

    public List<UsersInGroup> getGruposDelUsuario(int id_grupo) throws DAOException;
    
    public List<UsuariosDelGrupo> getUsuariosDelGrupos(int id_usuario) throws DAOException;

}
