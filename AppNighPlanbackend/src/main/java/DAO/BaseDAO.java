package DAO;

import java.util.List;

/**
 *
 * @Javier Altmann
 */
public interface BaseDAO<T> {

    String crear(T t) throws DAOException;

    void actualizar(T t) throws DAOException;

    void eliminar(T t) throws DAOException;

    List<T> obtenerTodos() throws DAOException;

    T obtener(int id) throws DAOException;

}
