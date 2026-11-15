package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Retiro;

import java.util.Optional;

public class RetiroController {

    private EmpresaMonedero empresaMonedero;

    public RetiroController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public boolean crearRetiro(Retiro retiro){
        return empresaMonedero.retiro(retiro);
    }

    public Optional<DetalleMonedero> buscarDetalle(String codigo){
        return empresaMonedero.buscarDetalleMonedero(codigo);
    }
}
