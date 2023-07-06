package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Board {
    private int id;
    private String title;
    private String contents;
    private String writer;
    private String date;
}
