package db;

import models.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientesDB {

    private Map<Integer, Cliente> clientesDBMap = new HashMap<>();

    public void addNovoCliente(Cliente cliente) {
        int id = clientesDBMap.size() + 1;
        cliente.setId(id); // Atribuindo id do cliente automaticamente conforme o tamanho da lista.
        clientesDBMap.put(cliente.getId(),cliente);
    }

    public Cliente getClientePorID(int id) {
        return clientesDBMap.get(id);
    }

    public Map<Integer, Cliente> getClientesDBMap() {
        return clientesDBMap;
    }

    // Método para retornar lista de clientes:
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Map.Entry<Integer, Cliente> cliente : clientesDBMap.entrySet()) {
            clientes.add(cliente.getValue());
        }
        return clientes;
    }


}
