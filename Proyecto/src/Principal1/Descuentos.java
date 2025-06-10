package Principal1;
//aqui me sucede algo en el import
import java.time.LocalDate;

public class Descuentos {
    private int id;
    private String descripcion;
    private double porcentaje;

    public Descuentos(int id, String descripcion, double porcentaje) {
        this.id = id;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
