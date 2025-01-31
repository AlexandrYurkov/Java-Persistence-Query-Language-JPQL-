package ru.otus.YurkovAleksandr.service;

import ru.otus.YurkovAleksandr.entity.Phone;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class PhoneService {
    private final EntityManager entityManager;

    public PhoneService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Phone phone) {
        entityManager.getTransaction().begin();
        entityManager.persist(phone);
        entityManager.getTransaction().commit();
    }

    public void update(Phone phone) {
        entityManager.getTransaction().begin();
        entityManager.merge(phone);
        entityManager.getTransaction().commit();
    }

    public void delete(UUID id) {
        entityManager.getTransaction().begin();
        Phone phone = entityManager.find(Phone.class, id);
        if (phone != null) {
            entityManager.remove(phone);
        }
        entityManager.getTransaction().commit();
    }

    public Phone findById(UUID id) {
        return entityManager.find(Phone.class, id);
    }

    public List<Phone> findAll() {
        return entityManager.createQuery("SELECT p FROM Phone p", Phone.class).getResultList();
    }

    public List<Phone> findByClientId(UUID clientId) {
        return entityManager.createQuery(
                        "SELECT p FROM Phone p WHERE p.client.id = :clientId", Phone.class)
                .setParameter("clientId", clientId)
                .getResultList();
    }
}
