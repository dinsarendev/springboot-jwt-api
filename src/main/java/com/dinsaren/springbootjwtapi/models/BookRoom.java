package com.dinsaren.springbootjwtapi.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_room", schema = "hotel")
public class BookRoom {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "hotel_id")
  private Integer hotelId;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "date")
  private LocalDateTime date;

  @Column(name = "checkin_date")
  private LocalDateTime checkinDate;

  @Column(name = "checkout_date")
  private LocalDateTime checkoutDate;

  @Column(name = "total_price", precision = 12, scale = 4)
  private BigDecimal totalPrice;

  @Column(name = "status", length = 3)
  private String status;
}
