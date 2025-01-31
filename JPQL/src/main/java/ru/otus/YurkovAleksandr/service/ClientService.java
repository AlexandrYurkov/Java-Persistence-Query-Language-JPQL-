package ru.otus.YurkovAleksandr.service;

import ru.otus.YurkovAleksandr.entity.Client;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

/*
    Создание сервисного слоя для работы с базой данных
    Для управления объектами создадим сервисный слой с JPA EntityManager.

    	•	persist() — сохраняет объект в БД.
	    •	merge() — обновляет объект.
	    •	remove() — удаляет объект.
	    •	find() — ищет объект по id.
        •   findAll() - возращает все элементы из таблици Client
*/


public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    private final EntityManager entityManager;

    public ClientService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Client client) {
        logger.info("Сохранение клиента: {}", client.getName());
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        logger.info("Клиент сохранён: {}", client.getId());
    }

    public void update(Client client) {
        logger.info("Обновление клиента: {}", client.getId());
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        logger.info("Клиент обновлён: {}", client.getId());
    }

    public void delete(UUID id) {
        logger.info("Удаление клиента: {}", id);
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
            logger.info("Клиент удалён: {}", id);
        } else {
            logger.warn("Клиент не найден: {}", id);
        }
        entityManager.getTransaction().commit();
    }

    public Client findById(UUID id) {
        logger.info("Поиск клиента по ID: {}", id);
        return entityManager.find(Client.class, id);
    }

    public List<Client> findAll() {
        logger.info("Получение списка всех клиентов");
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}