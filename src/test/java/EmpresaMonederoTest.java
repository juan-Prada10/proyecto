/**
 * Clase para probar la aplicacion empresa
 * noviembre/2026
 */
import static org.junit.jupiter.api.Assertions.*;
import co.edu.uniquindio.poo.empresamonedero.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

public class EmpresaMonederoTest{
    private EmpresaMonedero empresaMonedero;
    private Cliente cliente;
    private DetalleMonedero detalleMonedero;

    @BeforeEach
    public void setUp() {
        empresaMonedero = new EmpresaMonedero("Monedero Virtual con sistema de Puntos", "en el local");

    }

    //verificar que las tres transacciones se añadan
    @Test
    void verificarCreacionTransacciones() {
        Transferencia transferencia = new Transferencia("TX-01", cliente,detalleMonedero,Estado.EJECUTADA,50600.5,600,LocalDate.now());
        Retiro retiro = new Retiro("TX-02", cliente,detalleMonedero,Estado.EJECUTADA,20000.5,200,LocalDate.now());
        Deposito deposito = new Deposito("TX-03", cliente,detalleMonedero,Estado.EJECUTADA,600.8,400,LocalDate.now());

        assertTrue(empresaMonedero.crearTransferencia(transferencia), "Debe crear la transferencia");
        assertTrue(empresaMonedero.crearRetiro(retiro), "Debe crear el retiro");
        assertTrue(empresaMonedero.crearDeposito(deposito), "Debe crear el depósito");

        Optional<Transaccion> tx1 = empresaMonedero.buscarTransaccion("TX-01");
        Optional<Transaccion> tx2 = empresaMonedero.buscarTransaccion("TX-02");
        Optional<Transaccion> tx3 = empresaMonedero.buscarTransaccion("TX-03");
        assertTrue(tx1.isPresent());
        assertInstanceOf(Transferencia.class, tx1.get(), "TX-01 debe ser instancia de Transferencia");
        assertTrue(tx2.isPresent());
        assertInstanceOf(Retiro.class, tx2.get(), "TX-02 debe ser instancia de Retiro");
        assertTrue(tx3.isPresent());
        assertInstanceOf(Deposito.class, tx3.get(), "TX-03 debe ser instancia de Deposito");
    }
}