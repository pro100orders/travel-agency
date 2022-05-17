package com.pro100user.travelagencybackend.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "hotels")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hotel_images", joinColumns = @JoinColumn(name = "hotel_id", referencedColumnName = "id"))
    @Column(name = "image", nullable = false)
    private Set<String> images = new HashSet<>();

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "description", nullable = false)
    private String description;


    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, targetEntity = Room.class)
    private Set<Room> rooms = new HashSet<>();
}
