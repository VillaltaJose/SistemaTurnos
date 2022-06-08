package model.menu;

public class MenuItem {

    private final String mensaje;
    private final IMenuCall accion;

    public MenuItem(
            String mensaje,
            IMenuCall accion
    ) {
        this.mensaje = mensaje;
        this.accion = accion;
    }

    public void ejecutar() {
        this.accion.ejecutar();
    }

    public String getMensaje() {
        return this.mensaje;
    }

}
