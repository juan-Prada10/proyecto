package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;

public class Deposito extends Transaccion{


    public Deposito(String codigo, AnalizadorTransaccion ownedByAnalizadorTransaccion, TransaccionProgramada transaccionProgramada, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, EmpresaMonedero ownedByEmpresaMonedero, double monto, double comicion, LocalDate fecha) {
        super(codigo, ownedByAnalizadorTransaccion, transaccionProgramada, cliente, detalleMonedero, estado, ownedByEmpresaMonedero, monto, comicion, fecha);
    }
}
