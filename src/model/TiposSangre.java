package model;

public class TiposSangre {
    private String grupo;
    private String factor;

    public TiposSangre() {
    }

    public TiposSangre(String grupo, String factor) {
        this.grupo = grupo;
        this.factor = factor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }
}
