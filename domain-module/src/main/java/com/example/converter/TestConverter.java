package com.example.converter;

import com.example.TestEntityDto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TestConverter implements AttributeConverter<TestEntityDto, String> {
    @Override
    public String convertToDatabaseColumn(TestEntityDto attribute) {
        return "test";
    }

    @Override
    public TestEntityDto convertToEntityAttribute(String dbData) {
        return new TestEntityDto();
    }
}
