package Principal1;

public class Cliente {
    private String nombre;
    private String correo;
    private String telefono;
    private int ID;

    public Cliente() {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getID() {
        return ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
