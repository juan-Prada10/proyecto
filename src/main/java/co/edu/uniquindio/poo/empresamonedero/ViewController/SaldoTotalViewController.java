package co.edu.uniquindio.poo.empresamonedero.ViewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.SaldoTotalController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class SaldoTotalViewController {

    private Aplicaccion aplicaccion;
    private SaldoTotalController saldoTotalController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        saldoTotalController = new SaldoTotalController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField txtCodigoMonedero;

    @FXML
    void consultarEvent(ActionEvent event) {
        calcularAction();
    }

    private void calcularAction() {
        String codigo = txtCodigoMonedero.getText();
        double saldo=0;
        if (saldoTotalController.saldoTotal(codigo).isEmpty()){
            mostrarMensaje("Informacion","No hay un monedero con este codigo", Alert.AlertType.WARNING);
        }else {saldo= saldoTotalController.saldoTotal(codigo).get();
            mostrarMensaje("Informacion"," Su saldo es de "+ saldo, Alert.AlertType.WARNING);}
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
        assert btnConsultar != null : "fx:id=\"btnConsultar\" was not injected: check your FXML file 'SaldoTotal.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'SaldoTotal.fxml'.";

    }
}

