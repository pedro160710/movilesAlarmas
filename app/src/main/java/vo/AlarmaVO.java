package vo;

/**
 * Created by Christian on 24/5/2016.
 */
public class AlarmaVO {
    private String titulo;
    private int hora;
    private int minuto;
    private String tipoHorario;
    private String estado;

    public AlarmaVO() {
    }

    public AlarmaVO(String tipoHorario, int minuto, int hora, String titulo, String estado) {
        this.tipoHorario = tipoHorario;
        this.minuto = minuto;
        this.hora = hora;
        this.titulo = titulo;
        this.estado=estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(String tipoHorario) {
        this.tipoHorario = tipoHorario;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
