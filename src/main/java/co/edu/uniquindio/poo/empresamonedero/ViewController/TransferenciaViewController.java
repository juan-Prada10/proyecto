package co.edu.uniquindio.poo.empresamonedero.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicacion;
import co.edu.uniquindio.poo.empresamonedero.controller.TransferenciaController;
import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Estado;
import co.edu.uniquindio.poo.empresamonedero.model.Transferencia;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class TransferenciaViewController {

    private Aplicacion aplicacion;
    private TransferenciaController transferenciaController;

    public void setApp(Aplicacion aplicacion){
        this.aplicacion=aplicacion;
        transferenciaController= new TransferenciaController(aplicacion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtCodigoMonedero;

    @FXML
    private Button btnTransferencia;

    @FXML
    private TextField txtCodigoTransferencia;

    @FXML
    void transferenciaEvent(ActionEvent event) {
        transferenciaAction();
    }

    private void transferenciaAction() {
        String codigo = txtCodigoMonedero.getText();
        double monto= Double.parseDouble(txtMonto.getText());
        String codigoTransferencia = txtCodigoTransferencia.getText();
        DetalleMonedero detaleMonederoEncontrado=transferenciaController.buscarDetalle(codigo).get();
        if (detaleMonederoEncontrado==null) {
            mostrarMensaje("Informacion", "El monedere al cual se desea realizar la transferencia no existe", Alert.AlertType.WARNING);
        }else{
            Transferencia transferencia = new Transferencia(codigoTransferencia, null, detaleMonederoEncontrado, Estado.PENDIENTE, monto, 10000, LocalDate.now());
            if (transferenciaController.crearTrnsferencia(transferencia)){
            mostrarMensaje("Informacion", "La transferencia se realizo de manera exitosa ", Alert.AlertType.WARNING);
            }else {mostrarMensaje("Informacion"," No se puede realizar la transferencia", Alert.AlertType.WARNING);
            }
        }
    }

    public void mostrarMensaje(String titulo, String texto, Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setContentText(texto);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtMonto != null : "fx:id=\"txtMonto\" was not injected: check your FXML file 'Transferencia.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'Transferencia.fxml'.";
        assert btnTransferencia != null : "fx:id=\"btnTransferencia\" was not injected: check your FXML file 'Transferencia.fxml'.";

    }
}

