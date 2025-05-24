package com.dinsaren.springbootjwtapi.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room", schema = "hotel")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "floor_id")
  private Integer floorId;

  @Column(name = "number_no")
  private String numberNo;

  @Column(name = "decription") // Keep if DB column is actually named this way
  private String decription;

  @Column(name = "price", precision = 12, scale = 4)
  private BigDecimal price;

  @Column(name = "status", length = 3)
  private String status;
}
