package com.example.MyNotes.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {

    private String author;
    private String title;
    private String body;
}
