package com.PracticandoHibernate.PracticandoHibernate.Controllers;

import com.PracticandoHibernate.PracticandoHibernate.Dao.ClienteDao;
import com.PracticandoHibernate.PracticandoHibernate.Modelos.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//CRUD DE LA CLASE CLIENTE
@RestController
public class ControladorClientes {

    @Autowired
    ClienteDao clienteDao;

    //CREATE
    @RequestMapping(value = "/crearCliente")
    public Cliente crearCliente(@RequestParam(value = "nombre") String nombre,
                                @RequestParam(value = "apellido") String apellido,
                                @RequestParam(value = "direccion") String direccion){

        System.out.println("Entro en funcion crarClientes");
        Cliente clienteNuevo = new Cliente(nombre,apellido,direccion);

        clienteDao.addClient(clienteNuevo);

        return clienteNuevo;
    }

    //READ
    @RequestMapping(value = "/ListarClientes")
    public List<Cliente> listaClientes(){
        return clienteDao.listarClientes();
    }

    //UPDATE
    @RequestMapping(value = "/updateClienteID")
    public Cliente updateCliente(@RequestParam(value = "id") String id,
                                 @RequestParam(value = "nombre") String nombre,
                                 @RequestParam(value = "apellido") String apellido,
                                 @RequestParam(value = "direccion") String direccion){

        System.out.println("Entro actualizar por id");
        Cliente clienteUPDATE = new Cliente(nombre,apellido,direccion);
        clienteDao.updateClienteID(Integer.parseInt(id),clienteUPDATE);

        return clienteUPDATE;
    }

    //DELETE
    @RequestMapping(value = "/deleteClienteID")
    public String deleteCliente(@RequestParam(value = "id") String id){

        System.out.println("Entro DELETE por id");

        if(clienteDao.deleteCliente(Integer.parseInt(id))){
            return "Cliente Eliminado";
        }else {
            return "No exite cliente con ese ID";
        }
    }
}
