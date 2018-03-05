package models;

import java.util.List;

/**
 *
 * @Javier Altmann
 */
public class GruposDelUsuarioDTO {
    private List<UsersInGroup> grupos;

    public List<UsersInGroup> getDatosDeLosUsuariosDeLosGrupos() {
        return grupos;
    }

    public void setGrupos(List<UsersInGroup> grupos) {
        this.grupos= grupos;
    }
}
