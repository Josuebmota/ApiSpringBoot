package com.desafio3.desafio03.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PESSOAS")
public class Pessoas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  @NotBlank(message = "{firstName.not.blank}")
  private String firstName;

  @Column(name = "last_name")
  @NotBlank(message = "{lastName.not.blank}")
  private String lastName;

  @Column(nullable = false)
  @NotBlank(message = "{career.not.blank}")
  private String career;
}