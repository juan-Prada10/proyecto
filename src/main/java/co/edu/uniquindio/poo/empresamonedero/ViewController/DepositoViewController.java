package co.edu.uniquindio.poo.empresamonedero.ViewController;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicacion;
import co.edu.uniquindio.poo.empresamonedero.controller.DepositoController;
import co.edu.uniquindio.poo.empresamonedero.model.Deposito;
import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class DepositoViewController {

    private Aplicacion aplicacion;
    private DepositoController depositoController;

    public void setApp(Aplicacion aplicacion){
        this.aplicacion=aplicacion;
        depositoController = new DepositoController(aplicacion.empresaMonedero);
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
    private TextField txtDeposito;

    @FXML
    private Button btnCrearDeposito;

    @FXML
    void crearDepositoEvent(ActionEvent event) {
        crearDepositoAction();

    }

    public void crearDepositoAction() {

        String codigo= txtCodigoMonedero.getText();
        double monto= Double.parseDouble(txtMonto.getText());
        String codigoDeposito = txtDeposito.getText();
        DetalleMonedero detalleEncontrado = depositoController.buscarDetalleMonedero(codigo).get();
        if (detalleEncontrado==null) {
            mostrarMensaje("Informacion", "El monedero no existe", Alert.AlertType.WARNING);
        }else{

        Deposito deposito = new Deposito(codigoDeposito,null,detalleEncontrado, Estado.EJECUTADA,monto,0,LocalDate.now());
        if(depositoController.crearDeposito(deposito)){
            mostrarMensaje("Informacion", "El deposito se realizo con exito", Alert.AlertType.WARNING);
        }else{mostrarMensaje("Informacion","No se pudo realizar el deposito", Alert.AlertType.WARNING);}}

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
        assert txtMonto != null : "fx:id=\"txtMonto\" was not injected: check your FXML file 'Deposito.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'Deposito.fxml'.";
        assert btnCrearDeposito != null : "fx:id=\"btnCrearDeposito\" was not injected: check your FXML file 'Deposito.fxml'.";

    }
}

