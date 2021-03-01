package mx.unam.aragon.fes;

public class Direccion {
    private String calle;
    private String numero;
    private String colonia;
    private String delegacion;
    private String estado;
    private String cp;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String colonia, String delegacion, String estado, String cp) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.estado = estado;
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\n' +
                ", numero='" + numero + '\n' +
                ", colonia='" + colonia + '\n' +
                ", delegacion='" + delegacion + '\n' +
                ", estado='" + estado + '\n' +
                ", cp='" + cp + '\n' +
                '}';
    }

    public boolean DireccionNoVacio(){
        return this.calle != null && this.cp != null && this.colonia != null && this.numero != null && this.delegacion != null && this.estado != null;
    }
}
