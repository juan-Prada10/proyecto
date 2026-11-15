package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Transaccion;

import java.util.List;

public class TransaccionesController {

    private EmpresaMonedero empresaMonedero;

    public TransaccionesController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public List<Transaccion> historialTransacciones(String documento){
        return empresaMonedero.consultarHistorialTransacciones(documento);
    }
}
