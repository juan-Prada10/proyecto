package co.edu.uniquindio.poo.empresamonedero.ViewController;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicacion;
import co.edu.uniquindio.poo.empresamonedero.controller.TransaccionesController;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TransaccionesViewController {

    private Aplicacion aplicacion;
    private TransaccionesController transaccionesController;

    public void setApp(Aplicacion aplicacion){
        this.aplicacion=aplicacion;
        transaccionesController= new TransaccionesController(aplicacion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHistorial;

    @FXML
    private TextField txtDocumento;

    @FXML
    void historialEvent(ActionEvent event) {
        historialAction();
    }

    private void historialAction() {
        String documento = txtDocumento.getText();
        String text = "";
        List<Transaccion> historial= transaccionesController.historialTransacciones(documento);
        if(historial.isEmpty()){
            mostrarMensaje("Informacion", "no se han realizado transacciones aun", Alert.AlertType.WARNING);
        }else{for(Transaccion t : historial){
            text += t.toString()+"\n";
        }
            mostrarMensaje("Informacion",  text, Alert.AlertType.WARNING);
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
        assert btnHistorial != null : "fx:id=\"btnHistorial\" was not injected: check your FXML file 'Transacciones.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'Transacciones.fxml'.";

    }
}

