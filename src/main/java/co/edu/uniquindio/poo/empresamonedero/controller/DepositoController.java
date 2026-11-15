package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.Deposito;
import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;

import java.util.Optional;

public class DepositoController {

    private EmpresaMonedero empresaMonedero;

    public DepositoController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public boolean crearDeposito(Deposito deposito){
        return empresaMonedero.deposito(deposito);
    }

    public Optional<DetalleMonedero> buscarDetalleMonedero(String codigo){
        return empresaMonedero.buscarDetalleMonedero(codigo);
    }
}
