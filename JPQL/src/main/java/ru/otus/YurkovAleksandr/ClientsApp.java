package ru.otus.YurkovAleksandr;

import ru.otus.YurkovAleksandr.entity.*;
import ru.otus.YurkovAleksandr.service.*;
import ru.otus.YurkovAleksandr.util.LiquibaseRunner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientsApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsApp.class);

    private static final String PERSISTENCE_UNIT_NAME = "SingleUnit";

    public static void main(String[] args) {
        LiquibaseRunner.runMigrations();
        persistClient();
    }

    public static Address createAddress(String newAddress) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = enf.createEntityManager();
        Address address = new Address(newAddress);
        AddressService addressService = new AddressService(em);
        addressService.save(address);
        return address;
    }

    public static void createPhone(String newPhone, Client client) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = enf.createEntityManager();
        PhoneService phoneService = new PhoneService(em);
        Phone phone = new Phone(newPhone, client);
        phoneService.save(phone);
        client.getPhones().add(phone);
    }

    public static void persistClient(){
        EntityManagerFactory enf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = enf.createEntityManager();
        Client savedClient = new Client("Name1", createAddress("New Address 22"));
        ClientService clientService = new ClientService(em);
        clientService.save(savedClient);
        createPhone("+09887766555", savedClient);
    }



}
