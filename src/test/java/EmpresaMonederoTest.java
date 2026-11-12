/**
 * Clase para probar la aplicacion empresa
 * noviembre/2026
 */
import static org.junit.jupiter.api.Assertions.*;
import co.edu.uniquindio.poo.empresamonedero.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaMonederoTest{
    private EmpresaMonedero empresaMonedero;

    @BeforeEach
    public void setUp() {
        empresaMonedero = new EmpresaMonedero("Monedero Virtual con sistema de Puntos", "en el local");
    }

    //verificar que las tres transacciones se añadan

}