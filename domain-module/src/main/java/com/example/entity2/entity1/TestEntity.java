package com.example.entity2.entity1;

import com.example.TestEntityDto;
import com.example.converter.TestConverter;

import javax.persistence.*;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = TestConverter.class)
    @Column(name = "test")
    private TestEntityDto test;
}
