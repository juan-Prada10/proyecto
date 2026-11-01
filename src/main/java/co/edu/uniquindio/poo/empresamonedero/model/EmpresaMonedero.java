package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;
import java.util.Optional;

public class EmpresaMonedero {

    private String nombre;
    private String direccion;

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Monedero> listaMonederos = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();


    public EmpresaMonedero(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public void setListaMonederos(ArrayList<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    //CRUD CLIENTE
    public Optional<Cliente> buscarCliente(String documento) {
        return listaClientes.stream().filter(cliente -> cliente.getDocumento().equals(documento)).findFirst();
    }

    public boolean crearCliente(Cliente cliente) {
        Optional<Cliente> CrearCliente = buscarCliente(cliente.getDocumento());
        if (CrearCliente.isPresent()) {
            return false;
        } else {
            listaClientes.add(cliente);
            return true;
        }
    }

    public boolean eliminarCliente(String documento) {
        Optional<Cliente> ClienteEncontrado = buscarCliente(documento);
        if (ClienteEncontrado.isPresent()) {
            listaClientes.remove(ClienteEncontrado.get());
            return true;
        }
        return false;
    }

    public boolean actualizarCliente(String documento, Cliente clienteActualizado) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documento);
        if (clienteEncontrado.isPresent()) {
           clienteEncontrado.get().setDocumento (clienteActualizado.getDocumento());
           clienteEncontrado.get().setDocumento(clienteActualizado.getDocumento());
           clienteEncontrado.get().setNombreCompleto(clienteActualizado.getNombreCompleto());
           clienteEncontrado.get().setCorreo(clienteActualizado.getCorreo());
           clienteEncontrado.get().setTelefono(clienteActualizado.getTelefono());
           clienteEncontrado.get().setSms(clienteActualizado.getSms());
           clienteEncontrado.get().setContraseña(clienteActualizado.getContraseña());
           clienteEncontrado.get().setPuntos(clienteActualizado.getPuntos());
            return true;
        }
        return false;
    }

}

