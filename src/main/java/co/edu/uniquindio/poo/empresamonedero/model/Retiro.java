package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;

public class Retiro extends Transaccion{

    public Retiro(String codigo, AnalizadorTransaccion ownedByAnalizadorTransaccion, TransaccionProgramada transaccionProgramada, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, EmpresaMonedero ownedByEmpresaMonedero, double monto, double comicion, LocalDate fecha) {
        super(codigo, ownedByAnalizadorTransaccion, transaccionProgramada, cliente, detalleMonedero, estado, ownedByEmpresaMonedero, monto, comicion, fecha);
    }
}
