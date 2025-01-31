package ru.otus.YurkovAleksandr.service;

import ru.otus.YurkovAleksandr.entity.Address;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class AddressService {
    private final EntityManager entityManager;

    public AddressService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }

    public void update(Address address) {
        entityManager.getTransaction().begin();
        entityManager.merge(address);
        entityManager.getTransaction().commit();
    }

    public void delete(UUID id) {
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, id);
        if (address != null) {
            entityManager.remove(address);
        }
        entityManager.getTransaction().commit();
    }

    public Address findById(UUID id) {
        return entityManager.find(Address.class, id);
    }

    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}
