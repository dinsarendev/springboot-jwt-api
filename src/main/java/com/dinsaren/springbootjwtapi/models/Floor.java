package com.dinsaren.springbootjwtapi.models;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "floor", schema = "hotel")
public class Floor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "hotel_id")
  private Integer hotelId;

  @Column(name = "number_no")
  private String numberNo;

  @Column(name = "decription") // Keep as-is if DB column is spelled this way
  private String decription;

  @Column(name = "status", length = 3)
  private String status;
  @Transient
  private List<Room> rooms;
}
