package com.joaogsrocha._SpringREST.model.userpoints;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="userpoints", schema = "avarum_core")
@Data
public class UserPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "points")
    private int points;
    @Column(name = "userid")
    private Long userid;
}
