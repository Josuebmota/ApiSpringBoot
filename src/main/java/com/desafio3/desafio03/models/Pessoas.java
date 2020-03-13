package com.desafio3.desafio03.models;

import javax.persistence.*;

@Entity
@Table(name = "PESSOAS")
public class Pessoas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(nullable = false)
  private String career;
}