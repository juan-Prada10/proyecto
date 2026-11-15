module co.edu.uniquindio.poo.empresamonedero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.uniquindio.poo.empresamonedero to javafx.fxml;
    opens co.edu.uniquindio.poo.empresamonedero.app to javafx.fxml;
    opens co.edu.uniquindio.poo.empresamonedero.ViewController to javafx.fxml;
    opens co.edu.uniquindio.poo.empresamonedero.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.empresamonedero.model to javafx.base;

    exports co.edu.uniquindio.poo.empresamonedero.model;
    exports co.edu.uniquindio.poo.empresamonedero.app;
    exports co.edu.uniquindio.poo.empresamonedero.controller;
    exports co.edu.uniquindio.poo.empresamonedero.ViewController;
}