package org.example;

import org.example.crudservice.ClientCrudService;
import org.example.crudservice.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        ClientCrudService crudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        // Create a new client
        Client client = new Client();
        client.setName("Ivan");
        crudService.saveClient(client); // Save the client
        System.out.println("Saved Client: " + client); // Print the newly saved client

        // Retrieve and display the client by ID (use the correct ID)
        Client retrievedClient = crudService.findClientById(7l);
        System.out.println("Retrieved Client: " + retrievedClient);
        System.out.println("---------------------------------------------------------");

        // Display all clients
        crudService.findAllClients();
        System.out.println("---------------------------------------------------------");

        // Update the client's name
        client.setName("Mykola");
        crudService.updateClient(client); // Make sure to update the client

        // Retrieve and display the updated client
        Client updatedClient = crudService.findClientById(client.getId());
        System.out.println("Updated Client: " + updatedClient);

        Client client2 = new Client();
        client2.setName("Roman");
        crudService.saveClient(client2);

        // Delete the client
        crudService.deleteClient(client2);

        System.out.println("-----------------------------------------------------------------");
        Planet planet = new Planet();
        planet.setId("URA");
        planet.setName("Uranus");
        planetCrudService.save(planet);
        System.out.println("Saved Planet: " + planet);
        System.out.println("-----------------------------------------------------------------");
        System.out.println(planetCrudService.getPlanetById("MARS"));
        System.out.println("-----------------------------------------------------------------");
        planetCrudService.getAllPlanets();
        planet.setId("JUP");
        planet.setName("Jupiter");
        planetCrudService.update(planet);
        System.out.println("Updated Planet: " + planet);

        planetCrudService.delete(planet);

        HibernateUtil.getInstance().closeSession();



    }

}
