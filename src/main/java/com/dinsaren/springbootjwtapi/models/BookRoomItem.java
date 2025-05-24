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
@Table(name = "book_room_item", schema = "hotel")
public class BookRoomItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "book_room_id")
  private Integer bookRoomId;

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "price", precision = 12, scale = 4)
  private BigDecimal price;

  @Column(name = "qty", precision = 12, scale = 4)
  private BigDecimal qty;

  @Column(name = "status", length = 3)
  private String status;
}
