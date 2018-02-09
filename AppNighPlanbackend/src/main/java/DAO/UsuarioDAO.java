package DAO;

import models.CreateUserDTO;

/**
 *
 * @Javier Altmann
 */
public interface UsuarioDAO extends BaseDAO<CreateUserDTO> {
    public CreateUserDTO autenticacionUsuario(CreateUserDTO user) throws DAOException;
}


