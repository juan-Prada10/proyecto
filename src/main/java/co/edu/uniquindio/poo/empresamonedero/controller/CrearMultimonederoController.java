package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;

public class CrearMultimonederoController {

    private EmpresaMonedero empresaMonedero;

    public CrearMultimonederoController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public boolean crear(String documento, String codigoMonedero, String codigoDetalle,String nombre, double saldo){
        return empresaMonedero.crearMultipleMonedero(documento,codigoMonedero,codigoDetalle,nombre,saldo);
    }
}
