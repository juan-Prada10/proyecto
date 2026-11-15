package co.edu.uniquindio.poo.empresamonedero.ViewController;


import co.edu.uniquindio.poo.empresamonedero.app.Aplicaccion;
import co.edu.uniquindio.poo.empresamonedero.controller.CrearMultimonederoController;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CrearMultimonederoViewController {

    private Aplicaccion aplicaccion;
    private CrearMultimonederoController crearMultimonederoController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        crearMultimonederoController = new CrearMultimonederoController(aplicaccion.empresaMonedero);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSaldoInicial;

    @FXML
    private TextField txtMultiMonederoCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtCodigoMonedero;

    @FXML
    private TextField txtDocumento;

    @FXML
    void crearEvent(ActionEvent event) {
        crearAction();

    }

    private void crearAction() {
        String documento=txtDocumento.getText();
        String nombre=txtNombre.getText();
        String codigoMonedero = txtCodigoMonedero.getText();
        String multimonederoCodigo = txtMultiMonederoCodigo.getText();
        double saldoInicial = Double.parseDouble(txtSaldoInicial.getText());
        if(crearMultimonederoController.crear(documento,codigoMonedero,multimonederoCodigo,nombre,saldoInicial)){
            mostrarMensaje("Informacion", "Se creo el multimonedero con exito", Alert.AlertType.WARNING);
        }else{mostrarMensaje("Informacion","No se pudo crear el multimonedero", Alert.AlertType.WARNING);}
    }

    public void mostrarMensaje(String titulo,String mensaje,Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setContentText(null);
        alerta.showAndWait();

    }

    @FXML
    void initialize() {
        assert txtSaldoInicial != null : "fx:id=\"txtSaldoInicial\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";
        assert txtMultiMonederoCodigo != null : "fx:id=\"txtMultiMonederoCodigo\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";
        assert btnCrear != null : "fx:id=\"btnCrear\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'CrearMultimonedero.fxml'.";

    }
}

