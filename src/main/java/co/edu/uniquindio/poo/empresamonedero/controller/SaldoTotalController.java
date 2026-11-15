package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;

import java.util.Optional;

public class SaldoTotalController {

    private EmpresaMonedero empresaMonedero;

    public SaldoTotalController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public Optional<Double> saldoTotal(String codigo){
        return empresaMonedero.consultarSaldo(codigo);
    }
}
