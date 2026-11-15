package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.Cliente;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;

import java.util.Optional;

public class RangoController {

    private EmpresaMonedero empresaMonedero;

    public RangoController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public String rango(Cliente cliente){
        return String.valueOf(empresaMonedero.obtenerRangoCliente(cliente));
    }

    public Optional<Cliente> cliente(String documento){
        return empresaMonedero.buscarCliente(documento);
    }
}
