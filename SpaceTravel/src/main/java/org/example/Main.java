package org.example;

import org.example.crudservice.ClientCrudService;
import org.example.crudservice.PlanetCrudService;

public class Main {
    public static void main(String[] args) {
       ClientCrudService crudService = new ClientCrudService();
       PlanetCrudService planetCrudService = new PlanetCrudService();
       planetCrudService.getAllPlanets();


    }
}