package ru.otus.YurkovAleksandr.entity;

//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Cascade;
//
//import java.util.UUID;
//
//@Entity
//@Table(name = "phone")
//@Data
//@NoArgsConstructor
//public class Phone {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private UUID id;
//    @Column(name = "number", nullable = false)
//    private String number;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    public Phone(String number) {
//        this.id = UUID.randomUUID();
//        this.number = number;
//    }
//
//    @Override
//    public String toString() {
//        return "Phone{" +
//                "id=" + id +
//                ", number='" + number + '\'' +
//                '}';
//    }
//}

import jakarta.persistence.*;

import java.util.UUID;
/*
 	•	@ManyToOne — связь с Client, каждый телефон относится к одному клиенту.
	•	@JoinColumn(name = "client_id") — внешний ключ client_id.
*/
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 30, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    public Phone() {}

    public Phone(String number, Client client) {
        this.number = number;
        this.client = client;
    }

    public UUID getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}