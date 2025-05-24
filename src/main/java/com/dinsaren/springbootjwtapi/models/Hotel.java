package com.dinsaren.springbootjwtapi.models;


import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel", schema = "hotel")
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "name")
  private String name;

  @Column(name = "decription") // Keep as-is if your DB column is actually "decription"
  private String decription;

  @Column(name = "phone", length = 22)
  private String phone;

  @Column(name = "email", length = 22)
  private String email;

  @Column(name = "status", length = 3)
  private String status;
  @Transient
  private List<Floor> floors;
}
