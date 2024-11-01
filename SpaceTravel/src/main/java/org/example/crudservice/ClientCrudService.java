package org.example.crudservice;

import org.example.dao.ClientDao;
import org.example.entity.Client;

public class ClientCrudService {
    private ClientDao clientDao = new ClientDao();

    public void saveClient(Client client) {
        clientDao.save(client);
    }
    public void updateClient(Client client) {
        clientDao.update(client);
    }
    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }
    public void findAllClients() {
         clientDao.findAll();
    }

}
