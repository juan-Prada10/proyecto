package co.edu.uniquindio.poo.empresamonedero.model;

public class Email implements Notificacion {
    @Override
    public void enviarNotificacion() {
        System.out.println("[Email]: Alerta generada.");
    }

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[Email a " + destinatario + "]: " + mensaje);
    }
}
