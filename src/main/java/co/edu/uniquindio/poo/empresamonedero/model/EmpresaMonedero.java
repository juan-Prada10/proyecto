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

    public Optional<Monedero> buscarMonedero(String codigo){
        return listaMonederos.stream().filter(monedero -> monedero.getCodigo().equals(codigo)).findFirst();
    }


    //CRUD monedero
    public boolean crearMonedero(Monedero monedero){
        Optional<Monedero> monederoEncontrado = buscarMonedero(monedero.getCodigo());
        if(monederoEncontrado.isPresent()){
            return false;
        }else {listaMonederos.add(monedero);
        return true;}
    }

    public boolean eliminarMonedero(String codigo){
        Optional<Monedero> monederoEncontrado= buscarMonedero(codigo);
        if (monederoEncontrado.isPresent()){
            listaMonederos.remove(monederoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarMonedero(String codigo, Monedero monederoNuevo){
        Optional<Monedero> monederoEncontrado = buscarMonedero(codigo);
        if (monederoEncontrado.isPresent()){
            monederoEncontrado.get().setCodigo(monederoNuevo.getCodigo());
            monederoEncontrado.get().setMonto(monederoNuevo.getMonto());
            return true;
        }return false;
    }


    //CRUD transacciones
    public Optional<Transaccion> buscarTransaccion(String codigo){
        return listaTransacciones.stream().filter(transaccion -> transaccion.getCodigo().equals(codigo)).findFirst();
    }

    public boolean crearTransferencia(Transferencia transferencia){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(transferencia.getCodigo());
        if (!transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Transferencia){
                listaTransacciones.add(transaccionEncontrada.get());
                return true;
            }return false;
        }return false;

    }

    public boolean eliminarTransaccion(String codigo){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(codigo);
        if (transaccionEncontrada.isPresent()){
            listaTransacciones.remove(transaccionEncontrada.get());
            return true;
        }return false;
    }

    public boolean actualizarTransferencia(String codigo, Transferencia transferenciaNueva){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(codigo);
        if (transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Transferencia){
                transaccionEncontrada.get().setCliente(transferenciaNueva.getCliente());
                transaccionEncontrada.get().setCodigo(transferenciaNueva.getCodigo());
                transaccionEncontrada.get().setFecha(transferenciaNueva.getFecha());
                transaccionEncontrada.get().setEstado(transferenciaNueva.getEstado());
                transaccionEncontrada.get().setDetalleMonedero(transferenciaNueva.getDetalleMonedero());
                transaccionEncontrada.get().setComicion(transferenciaNueva.getComicion());
                transaccionEncontrada.get().setMonto(transferenciaNueva.getMonto());
                return true;
            }return false;
        }return false;
    }

    public boolean crearRetiro(Retiro retiro){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(retiro.getCodigo());
        if (!transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Retiro){
                listaTransacciones.add(transaccionEncontrada.get());
                return true;
            }return false;
        }return false;

    }

    public boolean actualizarRetiro(String codigo, Retiro retiroNuevo){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(codigo);
        if (transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Retiro){
                transaccionEncontrada.get().setCliente(retiroNuevo.getCliente());
                transaccionEncontrada.get().setCodigo(retiroNuevo.getCodigo());
                transaccionEncontrada.get().setFecha(retiroNuevo.getFecha());
                transaccionEncontrada.get().setEstado(retiroNuevo.getEstado());
                transaccionEncontrada.get().setDetalleMonedero(retiroNuevo.getDetalleMonedero());
                transaccionEncontrada.get().setComicion(retiroNuevo.getComicion());
                transaccionEncontrada.get().setMonto(retiroNuevo.getMonto());
                return true;
            }return false;
        }return false;
    }

    public boolean crearDeposito(Deposito deposito){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(deposito.getCodigo());
        if (!transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Deposito){
                listaTransacciones.add(transaccionEncontrada.get());
                return true;
            }return false;
        }return false;

    }

    public boolean actualizarDeposito(String codigo, Deposito depositoNuevo){
        Optional<Transaccion> transaccionEncontrada = buscarTransaccion(codigo);
        if (transaccionEncontrada.isPresent()){
            if (transaccionEncontrada.get() instanceof Deposito){
                transaccionEncontrada.get().setCliente(depositoNuevo.getCliente());
                transaccionEncontrada.get().setCodigo(depositoNuevo.getCodigo());
                transaccionEncontrada.get().setFecha(depositoNuevo.getFecha());
                transaccionEncontrada.get().setEstado(depositoNuevo.getEstado());
                transaccionEncontrada.get().setDetalleMonedero(depositoNuevo.getDetalleMonedero());
                transaccionEncontrada.get().setComicion(depositoNuevo.getComicion());
                transaccionEncontrada.get().setMonto(depositoNuevo.getMonto());
                return true;
            }return false;
        }return false;
    }

    //1. Los clientes pueden agregar dinero a su cuenta

    public boolean deposito(Deposito deposito){
        if(crearDeposito(deposito)){
            deposito.getDetalleMonedero().setSaldo(deposito.getDetalleMonedero().getSaldo() + deposito.getMonto());
            return true;
        }return false;
    }

    //2. Los clientes pueden retirar dinerode sus cuentas

    public boolean retiro(Retiro retiro){
        if (retiro.getMonto()<=retiro.getDetalleMonedero().getSaldo()){
            if (crearRetiro(retiro)){
                retiro.getDetalleMonedero().setSaldo(retiro.getDetalleMonedero().getSaldo()-retiro.getMonto());
                return true;
            }return false;
        }return false;
    }

    //3. Realizar una transferencia a otra usuario

    public boolean transferencia(Transferencia transferencia, String codigoMonedero){
        if(transferencia.getDetalleMonedero().getSaldo()> transferencia.getMonto()){
            if (crearTransferencia(transferencia)){
                transferencia.getDetalleMonedero().setSaldo(transferencia.getDetalleMonedero().getSaldo()-transferencia.getMonto());
                Optional<DetalleMonedero> monederoDestino =listaMonederos.stream().
                        flatMap(monedero -> monedero.getListaDetalleMonedero().stream().
                                filter(d->d.getCodigo().equals(codigoMonedero))).findFirst();
                monederoDestino.get().setSaldo(monederoDestino.get().getSaldo()+ transferencia.getMonto());
                return true;
            }return false;
        }return false;
    }








}

