package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.Cliente;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;

import java.util.Optional;

public class BeneficiosController {

    private EmpresaMonedero empresaMonedero;

    public BeneficiosController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public boolean beneficio(Transaccion transaccion, Cliente cliente, int puntos){
        return empresaMonedero.crearDescuento(transaccion,cliente,puntos);
    }

    public Optional<Transaccion> buscarTransaccion(String codigo){
        return empresaMonedero.buscarTransaccion(codigo);
    }

    public Optional<Cliente> buscarCliente(String documento){
        return empresaMonedero.buscarCliente(documento);
    }
}
