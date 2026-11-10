package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalizadorTransaccion {
    private List<Transaccion> listaTransacciones;

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public AnalizadorTransaccion(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public List<Transaccion> buscarTransaccionesAtipicas() {
        if (listaTransacciones == null || listaTransacciones.isEmpty()) {
            return Collections.emptyList();
        }

        double promedio = listaTransacciones.stream()
                .mapToDouble(Transaccion::getMonto)
                .average()
                .orElse(0.0);

        double varianza = listaTransacciones.stream()
                .mapToDouble(t -> Math.pow(t.getMonto() - promedio, 2))
                .average()
                .orElse(0.0);

        double desviacionEstandar = Math.sqrt(varianza);

        double umbral = promedio + (2 * desviacionEstandar);

        return listaTransacciones.stream()
                .filter(t -> t.getMonto() > umbral)
                .collect(Collectors.toList());
    }


}
