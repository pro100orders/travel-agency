package com.pro100user.travelagencybackend.entity;

import com.pro100user.travelagencybackend.entity.enums.Rating;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rooms")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Hotel.class)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "count_people", nullable = false)
    private int countPeople;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "count", nullable = false)
    private String count;


    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, targetEntity = Order.class)
    private List<Order> orders = new ArrayList<>();
}
