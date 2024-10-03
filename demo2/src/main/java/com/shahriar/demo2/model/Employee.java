package com.shahriar.demo2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//CascadeType.ALL: Any operation (e.g., persist, merge, remove) on the Employee entity will also affect the associated Address entity.
                                                                //FetchType.EAGER: When an Employee is loaded, the Address will be fetched immediately, rather than lazily.
    @JoinColumn(name = "address_id", referencedColumnName = "id") // Specifies the foreign key column (address_id) in the Employee table that references the id column of the Address table.
    private Address address;

}
