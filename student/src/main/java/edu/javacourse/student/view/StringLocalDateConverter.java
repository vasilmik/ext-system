package edu.javacourse.student.view;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringLocalDateConverter extends StdConverter<String,LocalDate> {
    @Override
    public LocalDate convert(String s) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(LocalDateStringConverter.DATE_FORMAT));
    }
}
