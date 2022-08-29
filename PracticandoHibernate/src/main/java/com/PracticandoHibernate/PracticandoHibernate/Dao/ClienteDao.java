package com.PracticandoHibernate.PracticandoHibernate.Dao;

import com.PracticandoHibernate.PracticandoHibernate.Modelos.Cliente;

import java.util.List;

public interface ClienteDao {

    void addClient(Cliente cliente);

    List<Cliente> listarClientes();

    void updateClienteID(int id, Cliente cliente);

    boolean deleteCliente(int id);
}
