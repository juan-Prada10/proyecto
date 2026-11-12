package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;

public class Retiro extends Transaccion{

    public Retiro(String codigo, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, double monto, double comision, LocalDate fecha) {
        super(codigo, cliente, detalleMonedero, estado, monto, comision, fecha);
    }

    @Override
    public int calcularPuntos() {
        return (int) (getMonto() / 100) * 2;
    }
}
