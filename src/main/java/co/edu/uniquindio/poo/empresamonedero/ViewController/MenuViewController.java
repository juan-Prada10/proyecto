package co.edu.uniquindio.poo.empresamonedero.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.MenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class MenuViewController {
    Aplicaccion aplicaccion;
    MenuController menuController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConsultarPuntos;

    @FXML
    private Button btnConsultarRango;

    @FXML
    private Button btnConsultarHistorialTransacciones;

    @FXML
    private Button btnTransaccionProgramada;

    @FXML
    private Button btnMonedero;

    @FXML
    private Button btnCanjearBeneficios;

    @FXML
    private Button btnConsultarSaldo;

    @FXML
    private Button btnRetiro;

    @FXML
    private Button btnDeposito;

    @FXML
    private Button btnTransferencia;

    @FXML
    void depositoEvent(ActionEvent event) {
        aplicaccion.openDeposito();

    }

    @FXML
    void retiroEvent(ActionEvent event) {
        aplicaccion.openDeposito();

    }

    @FXML
    void transferenciaEvent(ActionEvent event) {
        aplicaccion.openTransferencia();

    }

    @FXML
    void consultarSaldoEvent(ActionEvent event) {
        aplicaccion.openSaldo();

    }

    @FXML
    void consultarTransaccionesEvent(ActionEvent event) {
        aplicaccion.openHistorial();

    }

    @FXML
    void consultarPuntosEvent(ActionEvent event) {
        aplicaccion.openPuntos();
    }

    @FXML
    void consultarRangoEvent(ActionEvent event) {
        aplicaccion.openRango();
    }

    @FXML
    void canjearBeneficiosEvent(ActionEvent event) {
        aplicaccion.canjearBeneficios();

    }

    @FXML
    void MonederoEvent(ActionEvent event) {

    }

    @FXML
    void transaccionProgramadaEvent(ActionEvent event) {

    }



    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion = aplicaccion;
        menuController=new MenuController(aplicaccion.empresaMonedero);
    }

    @FXML
    void initialize() {
        assert btnConsultarPuntos != null : "fx:id=\"btnConsultarPuntos\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnConsultarRango != null : "fx:id=\"btnConsultarRango\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnConsultarHistorialTransacciones != null : "fx:id=\"btnConsultarHistorialTransacciones\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnCanjearBeneficios != null : "fx:id=\"btnCanjearBeneficios\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnConsultarSaldo != null : "fx:id=\"btnConsultarSaldo\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnRetiro != null : "fx:id=\"btnRetiro\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnDeposito != null : "fx:id=\"btnDeposito\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnTransferencia != null : "fx:id=\"btnTransferencia\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}


