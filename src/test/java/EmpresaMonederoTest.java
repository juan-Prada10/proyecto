/**
 * Clase para probar la aplicacion empresa
 * noviembre/2026
 */
import static org.junit.jupiter.api.Assertions.*;
import co.edu.uniquindio.poo.empresamonedero.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
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
        Retiro retiro = new Retiro("TX-02", cliente,detalleMonedero,Estado.EJECUTADA, empresaMonedero, 20000.5,200,LocalDate.now());
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

    //test para verificar que el saldo refleja los depósitos y retiros
    @Test
    public void consultarSaldoReflejaDepositosYRetiros() {
        Cliente cliente = crearCliente("100", 500, 0);
        DetalleMonedero detalle = detalleDe(cliente);

        assertTrue(empresaMonedero.deposito(transaccionDeposito("dep-1", cliente, detalle, 200,
                LocalDate.of(2026, 1, 1))));
        assertTrue(empresaMonedero.retiro(new Retiro("ret-1", cliente, detalle, Estado.EJECUTADA,
                empresaMonedero, 50, 0, LocalDate.of(2026, 1, 2))));

        assertEquals(650, empresaMonedero.consultarSaldo(detalle.getCodigo()).orElseThrow());
    }
    // test para verificar que cada transacción acredita los puntos correspondientes
    @Test
    public void cadaTransaccionAcreditaLosPuntosCorrespondientes() {
        Cliente cliente = crearCliente("100", 1000, 0);
        DetalleMonedero origen = detalleDe(cliente);
        Cliente destinatario = crearCliente("200", 100, 0);
        DetalleMonedero destino = detalleDe(destinatario);

        assertTrue(empresaMonedero.deposito(transaccionDeposito("dep-2", cliente, origen, 250,
                LocalDate.of(2026, 1, 1))));
        assertTrue(empresaMonedero.retiro(new Retiro("ret-2", cliente, origen, Estado.EJECUTADA,
                empresaMonedero, 200, 0, LocalDate.of(2026, 1, 2))));
        assertTrue(empresaMonedero.transferencia(new Transferencia("trans-1", cliente, origen,
                        Estado.EJECUTADA, 300, 0, LocalDate.of(2026, 1, 3)),
                destino.getCodigo()));

        assertEquals(15, cliente.getPuntos());
        assertEquals(750, origen.getSaldo());
        assertEquals(400, destino.getSaldo());
    }
    // test para verificar que canjear puntos reduce la comisión de la transferencia
    @Test
    public void canjearPuntosReduceLaComisionDeLaTransferencia() {
        Cliente cliente = crearCliente("100", 1000, 100);
        DetalleMonedero origen = detalleDe(cliente);
        Transferencia transferencia = new Transferencia("trans-descuento", cliente, origen,
                Estado.EJECUTADA, 100, 10, LocalDate.of(2026, 1, 1));

        assertTrue(empresaMonedero.crearDescuento(transferencia, cliente, 100));

        assertEquals(9, transferencia.getComision(), 0.001);
        assertEquals(3, cliente.getPuntos());
    }

    //test que verifica que las transacciones programadas recurrentes se ejecutan y quedan en el historial

    @Test
    public void transaccionesProgramadasRecurrentesSeEjecutanYQuedanEnElHistorial() {
        Cliente cliente = crearCliente("100", 0, 0);
        DetalleMonedero detalle = detalleDe(cliente);
        Deposito deposito = transaccionDeposito("dep-programado", cliente, detalle, 100,
                LocalDate.of(2026, 1, 1));
        TransaccionProgramada programada = new TransaccionProgramada("programada-1", deposito,
                Estado.PENDIENTE, 100, LocalDate.of(2026, 1, 1), 1);
        assertTrue(empresaMonedero.programarTransaccion(programada));

        empresaMonedero.procesarTransaccionesProgramadas(LocalDate.of(2026, 1, 3));

        assertEquals(300, detalle.getSaldo());
        assertEquals(3, cliente.getPuntos());
        assertEquals(3, empresaMonedero.consultarHistorialTransacciones("100").size());
        assertEquals(LocalDate.of(2026, 1, 4), programada.getFecha());
        assertEquals(Estado.PENDIENTE, programada.getEstado());

        empresaMonedero.procesarTransaccionesProgramadas(LocalDate.of(2026, 1, 4));
        assertEquals(400, detalle.getSaldo());
        assertEquals(Estado.PENDIENTE, programada.getEstado());
    }

    //test que verifica que el historial muestra las transacciones del cliente en orden cronológico inverso

    @Test
    public void historialMuestraLasTransaccionesDelClienteEnOrdenCronologicoInverso() {
        Cliente cliente = crearCliente("100", 0, 0);
        DetalleMonedero detalle = detalleDe(cliente);
        Cliente otroCliente = crearCliente("200", 0, 0);

        Deposito primero = transaccionDeposito("dep-hist-1", cliente, detalle, 100,
                LocalDate.of(2026, 1, 1));
        Deposito segundo = transaccionDeposito("dep-hist-2", cliente, detalle, 200,
                LocalDate.of(2026, 1, 3));
        Deposito deOtroCliente = transaccionDeposito("dep-hist-3", otroCliente,
                detalleDe(otroCliente), 300, LocalDate.of(2026, 1, 2));
        assertTrue(empresaMonedero.deposito(primero));
        assertTrue(empresaMonedero.deposito(segundo));
        assertTrue(empresaMonedero.deposito(deOtroCliente));

        List<Transaccion> historial = empresaMonedero.consultarHistorialTransacciones("100");

        assertEquals(2, historial.size());
        assertEquals(List.of(segundo, primero), historial);
    }

    private Cliente crearCliente(String documento, double saldoInicial, int puntos) {
        Cliente cliente = new Cliente(null, Rango.BRONCE, null, empresaMonedero, puntos,
                "clave", "", "3000000000", documento + "@correo.com", documento,
                "Cliente " + documento);
        Monedero monedero = new Monedero("monedero-" + documento, saldoInicial,
                empresaMonedero, cliente);
        monedero.agregarDetalleMonedero(new DetalleMonedero("Principal",
                "detalle-" + documento, saldoInicial, monedero));
        cliente.setMonedero(monedero);
        assertTrue(empresaMonedero.crearMonedero(monedero));
        assertTrue(empresaMonedero.crearCliente(cliente));
        return cliente;
    }

    private DetalleMonedero detalleDe(Cliente cliente) {
        return cliente.getMonedero().getListaDetalleMonedero().get(0);
    }

    private Deposito transaccionDeposito(String codigo, Cliente cliente,
                                         DetalleMonedero detalle, double monto, LocalDate fecha) {
        return new Deposito(codigo, cliente, detalle, Estado.EJECUTADA,
                monto, 0, fecha);
    }
    //verificar que salga error al añadir cualquier transaccion con el mismo codigo
    @Test
    void verificarCodigoDuplicado() {
        Transferencia transferenciaOriginal = new Transferencia("TX-01", cliente, detalleMonedero, Estado.EJECUTADA, 50600.5, 600, LocalDate.now());
        assertTrue(empresaMonedero.crearTransferencia(transferenciaOriginal), "Debe registrar la primera transacción");

        Transferencia transferenciaDuplicada = new Transferencia("TX-01", cliente, detalleMonedero, Estado.EJECUTADA, 10000.0, 100, LocalDate.now());
        Retiro retiroDuplicado = new Retiro("TX-01",  cliente,detalleMonedero,Estado.EJECUTADA, empresaMonedero, 20000.5,200,LocalDate.now());
        Deposito depositoDuplicado = new Deposito("TX-01", cliente, detalleMonedero, Estado.EJECUTADA, 600.8, 400, LocalDate.now());

        assertFalse(empresaMonedero.crearTransferencia(transferenciaDuplicada), "No debe permitir otra Transferencia con el mismo código");
        assertFalse(empresaMonedero.crearRetiro(retiroDuplicado), "No debe permitir un Retiro con el mismo código");
        assertFalse(empresaMonedero.crearDeposito(depositoDuplicado), "No debe permitir un Depósito con el mismo código");

        Optional<Transaccion> guardada = empresaMonedero.buscarTransaccion("TX-01");
        assertTrue(guardada.isPresent());
        assertInstanceOf(Transferencia.class, guardada.get(), "Debe mantenerse la Transferencia original");
    }
}