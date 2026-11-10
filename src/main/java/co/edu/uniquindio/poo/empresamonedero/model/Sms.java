package co.edu.uniquindio.poo.empresamonedero.model;

public class Sms implements Notificacion {
    @Override
    public void enviarNotificacion() {
        System.out.println("[SMS]: Alerta generada.");
    }

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[SMS a " + destinatario + "]: " + mensaje);
    }
}
