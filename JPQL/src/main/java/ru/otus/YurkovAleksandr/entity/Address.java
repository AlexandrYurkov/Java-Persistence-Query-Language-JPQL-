package ru.otus.YurkovAleksandr.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/*
    •   @Entity — обозначает, что класс является сущностью JPA.
    •	@Table(name = "address") — привязывает сущность к таблице address.
    •	Поле id автоматически генерируется.
    •	Поле address хранит строку длиной до 60 символов.
*/

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 60, nullable = false)
    private String address;

    public Address(String address) {
        this.address = address;
    }

    public void setAddress(String address) { this.address = address; }
}
