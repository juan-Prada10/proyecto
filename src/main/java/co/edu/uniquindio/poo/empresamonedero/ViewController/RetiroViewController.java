package co.edu.uniquindio.poo.empresamonedero.ViewController;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.RetiroController;
import co.edu.uniquindio.poo.empresamonedero.model.Deposito;
import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Estado;
import co.edu.uniquindio.poo.empresamonedero.model.Retiro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class RetiroViewController {

    private Aplicaccion aplicaccion;
    private RetiroController retiroController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        retiroController= new RetiroController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMonto;

    @FXML
    private Button btnRetiro;

    @FXML
    private TextField txtCodigoRetiro;

    @FXML
    private TextField txtCodigoMonedero;

    @FXML
    void retiroEvent(ActionEvent event) {
        retiroAction();
    }



    public void retiroAction() {

        String codigo= txtCodigoMonedero.getText();
        double monto= Double.parseDouble(txtMonto.getText());
        String codigoRetiro = txtCodigoRetiro.getText();
        DetalleMonedero detalleEncontrado = retiroController.buscarDetalle(codigo).get();
        if (detalleEncontrado==null) {
            mostrarMensaje("Informacion", "El monedero no existe", Alert.AlertType.WARNING);
        }else{

            Retiro retiro = new Retiro(codigoRetiro,null,detalleEncontrado, Estado.EJECUTADA,aplicaccion.empresaMonedero,monto,0, LocalDate.now());
            if(retiroController.crearRetiro(retiro)){
                mostrarMensaje("Informacion", "El retiro se realizo con exito", Alert.AlertType.WARNING);
            }else{mostrarMensaje("Informacion","No se pudo realizar el retiro", Alert.AlertType.WARNING);}}

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
        assert txtMonto != null : "fx:id=\"txtMonto\" was not injected: check your FXML file 'Retiro.fxml'.";
        assert btnRetiro != null : "fx:id=\"btnRetiro\" was not injected: check your FXML file 'Retiro.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'Retiro.fxml'.";

    }
}

