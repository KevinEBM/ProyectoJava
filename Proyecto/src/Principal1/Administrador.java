package Principal1;

public class Administrador {
    private String Usuario;
    private String Contraseña;

    public Administrador(String usuario, String contraseña) {
        Usuario = usuario;
        Contraseña = contraseña;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
}
