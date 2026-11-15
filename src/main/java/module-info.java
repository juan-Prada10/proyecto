module co.edu.uniquindio.poo.empresamonedero {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.empresamonedero to javafx.fxml;
    
    exports co.edu.uniquindio.poo.empresamonedero.model;
    exports co.edu.uniquindio.poo.empresamonedero.app;
    exports co.edu.uniquindio.poo.empresamonedero;
    opens co.edu.uniquindio.poo.empresamonedero.app to javafx.fxml;
}