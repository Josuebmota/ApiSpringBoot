package com.example.apispringboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private String first_name;

  @Column(name = "last_name")
  @NotBlank(message = "{lastName.not.blank}")
  private String last_name;

  @Column(nullable = false)
  @NotBlank(message = "{career.not.blank}")
  private String career;
}