package co.edu.uniquindio.poo.empresamonedero.ViewController;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicacion;
import co.edu.uniquindio.poo.empresamonedero.controller.RangoController;
import co.edu.uniquindio.poo.empresamonedero.model.Cliente;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RangoViewController {

    private Aplicacion aplicacion;
    private RangoController rangoController;

    public void setApp(Aplicacion aplicacion){
        this.aplicacion=aplicacion;
        rangoController = new RangoController(aplicacion.empresaMonedero);
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
        String documento= txtDocumento.getText();
        String rango="";
        try {Cliente cliente = rangoController.cliente(documento).get();
            rango =rangoController.rango(cliente);
            mostrarMensaje("Informacion","Su rango es" + rango, Alert.AlertType.WARNING);}
        catch (IllegalArgumentException e){
            mostrarMensaje("Informacion",e.getMessage(),Alert.AlertType.WARNING);
        }
    }

    public void mostrarMensaje(String titulo,String mensaje,Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'Rango.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'Rango.fxml'.";

    }
}

