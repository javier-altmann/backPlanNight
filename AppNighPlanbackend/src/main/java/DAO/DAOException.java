package DAO;

import java.sql.SQLException;

/**
 *
 * @Javier Altmann
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }

    public DAOException(String message, SQLException ex) {
        super(message, ex);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

}
