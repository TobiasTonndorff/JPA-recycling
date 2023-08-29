package model;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "truck")
public class Truck {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "truck_id")
    private int truckId;

    @Column(name = "truck brand")
    private String truckBrand;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "registration_number", unique = true, nullable = false)
    private String registrationNumber;


    public Truck(String truckBrand, int capacity, String registrationNumber){
        this.truckBrand = truckBrand;
        this.capacity = capacity;
        this.registrationNumber = registrationNumber;
    }

    @OneToMany(mappedBy = "truck")
    @MapsId
    private List<Driver> drivers;







}
