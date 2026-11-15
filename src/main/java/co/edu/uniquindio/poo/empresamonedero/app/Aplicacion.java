package co.edu.uniquindio.poo.empresamonedero.app;

import co.edu.uniquindio.poo.empresamonedero.model.*;
import co.edu.uniquindio.poo.empresamonedero.ViewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


public class Aplicacion extends Application {

    private Stage primaryStage;
    public static EmpresaMonedero empresaMonedero = new EmpresaMonedero("Monedero virtual", "525832");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Panaderia el trigal");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Menu.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            MenuViewController menuViewController= loader.getController();
            menuViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void openDeposito() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Deposito.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            DepositoViewController depositoViewController= loader.getController();
            depositoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openRetiro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Retiro.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            RetiroViewController retiroViewController= loader.getController();
            retiroViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openTransferencia() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Transferencia.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            TransferenciaViewController transferenciaViewController= loader.getController();
            transferenciaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openSaldo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/SaldoTotal.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            SaldoTotalViewController saldoTotalViewController= loader.getController();
            saldoTotalViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openRango() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Rango.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            RangoViewController rangoTotalViewController= loader.getController();
            rangoTotalViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openHistorial() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Transacciones.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            TransaccionesViewController TransaccionesViewController= loader.getController();
            TransaccionesViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openPuntos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Puntos.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PuntosViewController puntosViewController= loader.getController();
            puntosViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void openBeneficios() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/Beneficios.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            BeneficiosViewController beneficiosViewController= loader.getController();
            beneficiosViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrearMultimonedero() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/CrearMultimonedero.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            CrearMultimonederoViewController crearMultimonederoViewController= loader.getController();
            crearMultimonederoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openProgramada() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/empresamonedero/TransaccionProgramada.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            TransaccionProgramadaViewController transaccionProgramadaViewController= loader.getController();
            transaccionProgramadaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData(){
        Cliente cliente1 = new Cliente(null,null,null,empresaMonedero,0,"12345","whatsapp","32352345","pedro10@gmail.com","1094234","Pedro elias");
        Cliente cliente2 = new Cliente(null,null,null,empresaMonedero,0,"12346","whatsapp","32352347","sara84@gmail.com","1094235","Sara gomez");
        Cliente cliente3 = new Cliente(null,null,null,empresaMonedero,0,"12347","whatsapp","32352348","sophia3450@gmail.com","1094236","sophia londoño");
        Monedero monedero1= new Monedero("23456",5000,cliente1);
        Monedero monedero2= new Monedero("23457",9000,cliente2);
        Monedero monedero3= new Monedero("23458",8000,cliente3);
        DetalleMonedero detalleMonedero1 = new DetalleMonedero("casa","23415",1000,monedero1);
        DetalleMonedero detalleMonedero2 = new DetalleMonedero("ahorros","23416",400,monedero2);
        DetalleMonedero detalleMonedero3 = new DetalleMonedero("estudios","23417",5000,monedero3);
        Retiro retiro1 = new Retiro("3426",cliente1,detalleMonedero1,Estado.EJECUTADA,empresaMonedero,100,0, LocalDate.now());
        Retiro retiro2 = new Retiro("3427",cliente2,detalleMonedero2,Estado.EJECUTADA,empresaMonedero,100,0, LocalDate.now());
        Retiro retiro3 = new Retiro("3428",cliente1,detalleMonedero1,Estado.EJECUTADA,empresaMonedero,100,0, LocalDate.now());
        Transferencia transferencia1 = new Transferencia("12950",cliente3,detalleMonedero3,Estado.EJECUTADA,300,0,LocalDate.now());
        Transferencia transferencia2 = new Transferencia("12951",cliente3,detalleMonedero3,Estado.EJECUTADA,300,0,LocalDate.now());
        Transferencia transferencia3 = new Transferencia("12952",cliente3,detalleMonedero3,Estado.EJECUTADA,300,0,LocalDate.now());
        Deposito deposito1= new Deposito("89542",cliente1,detalleMonedero1,Estado.EJECUTADA,500,0,LocalDate.now());
        Deposito deposito2= new Deposito("89543",cliente2,detalleMonedero2,Estado.EJECUTADA,500,0,LocalDate.now());
        Deposito deposito3= new Deposito("89544",cliente2,detalleMonedero2,Estado.EJECUTADA,500,0,LocalDate.now());

        empresaMonedero.crearCliente(cliente1);
        empresaMonedero.crearCliente(cliente2);
        empresaMonedero.crearCliente(cliente3);
        empresaMonedero.crearMonedero(monedero1);
        empresaMonedero.crearMonedero(monedero2);
        empresaMonedero.crearMonedero(monedero3);
        empresaMonedero.detalle(detalleMonedero1);
        empresaMonedero.detalle(detalleMonedero2);
        empresaMonedero.detalle(detalleMonedero3);
        empresaMonedero.crearRetiro(retiro1);
        empresaMonedero.crearRetiro(retiro2);
        empresaMonedero.crearRetiro(retiro3);
        empresaMonedero.crearDeposito(deposito1);
        empresaMonedero.crearDeposito(deposito2);
        empresaMonedero.crearDeposito(deposito3);
        empresaMonedero.crearTransferencia(transferencia1);
        empresaMonedero.crearTransferencia(transferencia2);
        empresaMonedero.crearTransferencia(transferencia3);


    }


    public static void main(String[] args) {
        launch();
    }


}

