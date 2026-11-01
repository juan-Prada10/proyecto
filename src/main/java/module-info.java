module co.edu.uniquindio.poo.empresamonedero {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.empresamonedero to javafx.fxml;
    exports co.edu.uniquindio.poo.empresamonedero;
}