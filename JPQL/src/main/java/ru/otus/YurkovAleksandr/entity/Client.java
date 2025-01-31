package ru.otus.YurkovAleksandr.entity;

//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.*;
//
//@Entity
//@Table(name = "client")
//@Data
//@NoArgsConstructor
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private UUID id;
//    @Column(name = "name")
//    private String name;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "client")
//    private Set<Phone> phones = new HashSet<>();
//
//
//    public Client(String name) {
//        this.id = UUID.randomUUID();
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Client{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/*
  	•	@OneToOne — связь с Address, @JoinColumn указывает внешний ключ address_id.
	•	@OneToMany(mappedBy = "client") — связь с Phone, клиент может иметь несколько телефонов.
	•	cascade = CascadeType.ALL — при удалении клиента удаляются и его телефоны.
*/
@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    public Client() {}

    public Client(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public List<Phone> getPhones() { return phones; }
    public void setPhones(List<Phone> phones) { this.phones = phones; }
}