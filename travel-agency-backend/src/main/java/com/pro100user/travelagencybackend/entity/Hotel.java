package com.pro100user.travelagencybackend.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "hotel_images",
            joinColumns = @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    )
    @Column(name = "image", nullable = false)
    private List<String> images = new ArrayList<>();

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "description", nullable = false)
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, targetEntity = Room.class)
    private List<Room> rooms = new ArrayList<>();
}
