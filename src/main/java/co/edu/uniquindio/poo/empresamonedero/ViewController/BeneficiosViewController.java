package co.edu.uniquindio.poo.empresamonedero.ViewController;

import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.BeneficiosController;
import co.edu.uniquindio.poo.empresamonedero.model.Cliente;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BeneficiosViewController {

    private Aplicaccion aplicaccion;
    private BeneficiosController beneficiosController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        beneficiosController=new BeneficiosController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPuntos;

    @FXML
    private Button btnCanjear;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDocumento;

    @FXML
    void canjearEvent(ActionEvent event) {
        canjearAction();

    }

    private void canjearAction() {
        int puntos= Integer.parseInt(txtPuntos.getText());
        String documento= txtDocumento.getText();
        String codigo=txtCodigo.getText();
        Optional<Transaccion> transaccionEncontrada= beneficiosController.buscarTransaccion(codigo);
        Optional<Cliente> clienteEncontrado=beneficiosController.buscarCliente(documento);
        if (transaccionEncontrada.isPresent()){
            if (clienteEncontrado.isPresent()){
                beneficiosController.beneficio(transaccionEncontrada.get(),clienteEncontrado.get(),puntos);
                mostrarMensaje("Informacion","Se realizo el beneficio con exito", Alert.AlertType.WARNING);
            }mostrarMensaje("informacion","No hay un cliente con este documento", Alert.AlertType.WARNING);
        }mostrarMensaje("Informacion","No hay transacciones con este codigo", Alert.AlertType.WARNING);
    }

    public void mostrarMensaje(String titulo, String mensjae, Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setContentText(mensjae);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtPuntos != null : "fx:id=\"txtPuntos\" was not injected: check your FXML file 'Beneficios.fxml'.";
        assert btnCanjear != null : "fx:id=\"btnCanjear\" was not injected: check your FXML file 'Beneficios.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'Beneficios.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'Beneficios.fxml'.";

    }
}

