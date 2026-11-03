package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;

public class Transferencia extends Transaccion {



    public Transferencia(String codigo, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, EmpresaMonedero ownedByEmpresaMonedero, double monto, double comicion, LocalDate fecha) {
        super(codigo, cliente, detalleMonedero, estado, ownedByEmpresaMonedero, monto, comicion, fecha);

    }


}
