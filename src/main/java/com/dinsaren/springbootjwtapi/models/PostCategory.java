package com.dinsaren.springbootjwtapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "post_categories")
@DynamicUpdate
@Data
public class PostCategory extends BaseEntity {
    private static final long serialVersionUID = 4489397646584896516L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String imageUrl;
    private String status;
}