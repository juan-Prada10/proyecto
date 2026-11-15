package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;

public class PuntosController {

    private EmpresaMonedero empresaMonedero;

    public PuntosController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public int puntos(String documento){
        return empresaMonedero.puntos(documento);
    }
}
