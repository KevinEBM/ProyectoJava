package Principal1;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private String cliente;
    private Habitaciones habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int NumeroHabitacion;

    public Reserva() {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.NumeroHabitacion = NumeroHabitacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroHabitacion() {
        return NumeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        NumeroHabitacion = numeroHabitacion;
    }
}
