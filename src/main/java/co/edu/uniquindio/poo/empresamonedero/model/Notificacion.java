package co.edu.uniquindio.poo.empresamonedero.model;


public interface Notificacion {
    void enviarNotificacion();

    default void enviarNotificacion(String destinatario, String mensaje) {
        enviarNotificacion();
    }
}

