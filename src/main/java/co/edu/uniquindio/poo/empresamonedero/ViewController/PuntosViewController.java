package co.edu.uniquindio.poo.empresamonedero.ViewController;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.PuntosController;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PuntosViewController {

    private Aplicaccion aplicaccion;
    private PuntosController puntosController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        puntosController= new PuntosController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField txtDocumento;

    @FXML
    void consultarEvent(ActionEvent event) {
        consultarAction();

    }

    private void consultarAction() {
        String documento = txtDocumento.getText();
        int puntos=0;
        try {
            puntos=puntosController.puntos(documento);
            mostrarMensaje("Informacion","Sus puntos son "+ puntos, Alert.AlertType.WARNING);
        }catch (IllegalArgumentException e){
            mostrarMensaje("Informacion", e.getMessage(), Alert.AlertType.WARNING);
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
        assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'Puntos.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'Puntos.fxml'.";

    }
}

