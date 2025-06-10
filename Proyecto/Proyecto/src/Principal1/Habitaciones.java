package Principal1;

public class Habitaciones {
    private int numero;
    private String Tipo;
    private double ValorpopNoche;
    private boolean Disponible;

    public Habitaciones(int numero, String tipo, double valorpopNoche, boolean Disponible) {
        this.numero = numero;
        this.Tipo = tipo;
        this.ValorpopNoche = valorpopNoche;
        this.Disponible = Disponible;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setValorpopNoche(double valorpopNoche) {
        ValorpopNoche = valorpopNoche;
    }

    public void setDisponoble(boolean Disponoble) {
        this.Disponible = Disponoble;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return Tipo;
    }

    public double getValorpopNoche() {
        return ValorpopNoche;
    }

    public boolean isDisponoble() {
        return Disponible;
    }
}
