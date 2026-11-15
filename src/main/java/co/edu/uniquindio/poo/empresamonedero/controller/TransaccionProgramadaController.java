package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;
import co.edu.uniquindio.poo.empresamonedero.model.TransaccionProgramada;

import java.util.Optional;

public class TransaccionProgramadaController {

    private EmpresaMonedero empresaMonedero;

    public TransaccionProgramadaController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public boolean programada(TransaccionProgramada transaccionProgramada){
        return empresaMonedero.programarTransaccion(transaccionProgramada);
    }

    public Optional<Transaccion> buscarTransaccion(String codigo){
        return empresaMonedero.buscarTransaccion(codigo);
    }
}
