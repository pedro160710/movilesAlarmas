package vo;

/**
 * Created by Pedro on 24/05/2016.
 */
public class AlarmasVo {
    private String titulo;
    private int hora;
    private int minuto;
    private String tipoHorario;

    public AlarmasVo(){

    }
    public AlarmasVo(String titulo, int hora,  int minuto, String tipoHorario) {
        this.hora = hora;
        this.titulo = titulo;
        this.minuto = minuto;
        this.tipoHorario = tipoHorario;
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
}
