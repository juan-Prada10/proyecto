package co.edu.uniquindio.poo.empresamonedero.ViewController;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicacion;
import co.edu.uniquindio.poo.empresamonedero.controller.TransaccionProgramadaController;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;
import co.edu.uniquindio.poo.empresamonedero.model.TransaccionProgramada;
import javafx.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TransaccionProgramadaViewController {

    private Aplicacion aplicaccion;
    private TransaccionProgramadaController transaccionProgramadaController;

    public void setApp(Aplicacion aplicaccion){
        this.aplicaccion=aplicaccion;
        transaccionProgramadaController= new TransaccionProgramadaController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtRecurrencia;

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtFecha;

    @FXML
    void crearEvent(ActionEvent event) {
        crearAction();

    }

    private void crearAction() {
        double monto = Double.parseDouble(txtMonto.getText());
        String codigo= txtCodigo.getText();
        int recurrencia = Integer.parseInt(txtRecurrencia.getText());
        LocalDate fecha = LocalDate.parse(txtFecha.getText());
        Transaccion tipo = transaccionProgramadaController.buscarTransaccion(codigo).get();
        TransaccionProgramada transaccion = new TransaccionProgramada(codigo,tipo,tipo.getEstado(),monto,fecha,recurrencia);
        if(transaccionProgramadaController.programada(transaccion)){
            mostrarMensaje("Informacion","Se programo la transaccion con exito", Alert.AlertType.WARNING);
        }else{
            mostrarMensaje("Informacion","No se pudo programar la transaccion", Alert.AlertType.WARNING);
        }
    }

    public void mostrarMensaje(String titulo, String mensaje, Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtMonto != null : "fx:id=\"txtMonto\" was not injected: check your FXML file 'TransaccionProgramada.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'TransaccionProgramada.fxml'.";
        assert txtRecurrencia != null : "fx:id=\"txtRecurrencia\" was not injected: check your FXML file 'TransaccionProgramada.fxml'.";
        assert btnCrear != null : "fx:id=\"btnCrear\" was not injected: check your FXML file 'TransaccionProgramada.fxml'.";
        assert txtFecha != null : "fx:id=\"txtFecha\" was not injected: check your FXML file 'TransaccionProgramada.fxml'.";

    }
}

