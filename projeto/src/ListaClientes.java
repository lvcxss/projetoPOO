import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaClientes implements Serializable {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public ListaClientes() {}

    public ListaClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void imprimir(){
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    @Override
    public String toString() {
        return "ListaClientes{" + "clientes=" + clientes + '}';
    }
}
