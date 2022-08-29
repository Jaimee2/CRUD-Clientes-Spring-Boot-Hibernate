package com.PracticandoHibernate.PracticandoHibernate.Dao;

import com.PracticandoHibernate.PracticandoHibernate.Modelos.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Alias de @Component
@Transactional
public class ClienteDaoImp implements ClienteDao{

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void addClient(Cliente cliente) {
        entityManager.persist(cliente); //Se debe de delegar la tarea de asignar el id a la BBDD (Más eficiente)
        //entityManager.merge(cliente); //Funciona de los dos modos.
    }

    @Override
    public List<Cliente> listarClientes() {
        //Consulta en lenguaje HQL
        String query = "from Cliente"; //Recordar que no es el nombre de la tabla, ES EL NOMBRE DE LA CLASE!!!!
        //Ejecutamos la query y traemos una lista
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void updateClienteID(int id, Cliente cliente) {

        //Busqueda del cliente
        Cliente cli = entityManager.find(Cliente.class, id);

        //Actualizo el objeto
        cli.setNombre(cliente.getNombre());
        cli.setApellidos(cliente.getApellidos());
        cli.setDireccion(cliente.getDireccion());

        //Añadidmos de nuevo el objeto
        entityManager.merge(cli);
    }

    @Override
    public boolean deleteCliente(int id) {
        //Busqueda del cliente
        Cliente cli = entityManager.find(Cliente.class, id);
        if(cli != null){
            entityManager.remove(cli);
            return true;
        }else{
            return false;
        }
    }


}
