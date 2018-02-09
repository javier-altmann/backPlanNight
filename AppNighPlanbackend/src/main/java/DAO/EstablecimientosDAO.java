package DAO;


import java.util.List;
import models.Establecimientos;

/**
 *
 * @Javier Altmann
 */
public interface EstablecimientosDAO extends BaseDAO <Establecimientos>{
    
    public List<Establecimientos> getEstablecimientosDestacados() throws DAOException;
    
}
