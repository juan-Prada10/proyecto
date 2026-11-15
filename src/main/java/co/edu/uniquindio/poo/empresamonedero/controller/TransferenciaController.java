package co.edu.uniquindio.poo.empresamonedero.controller;

import co.edu.uniquindio.poo.empresamonedero.model.DetalleMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.EmpresaMonedero;
import co.edu.uniquindio.poo.empresamonedero.model.Transferencia;

import java.util.Optional;

public class TransferenciaController {

    private EmpresaMonedero empresaMonedero;

    public TransferenciaController(EmpresaMonedero empresaMonedero){
        this.empresaMonedero=empresaMonedero;
    }

    public Boolean crearTrnsferencia(Transferencia transferencia){
        return empresaMonedero.crearTransferencia(transferencia);
    }

    public Optional<DetalleMonedero> buscarDetalle(String codigo){
        return empresaMonedero.buscarDetalleMonedero(codigo);
    }
}
