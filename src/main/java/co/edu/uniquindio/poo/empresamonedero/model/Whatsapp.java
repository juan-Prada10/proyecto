package co.edu.uniquindio.poo.empresamonedero.model;

public class Whatsapp implements Notificacion {
    @Override
    public void enviarNotificacion() {
        System.out.println("[WhatsApp]: Alerta generada.");
    }

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[WhatsApp a " + destinatario + "]: " + mensaje);
    }
}
