package DAO;

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

    public DAOException(Throwable cause) {
        super(cause);
    }
    
}
