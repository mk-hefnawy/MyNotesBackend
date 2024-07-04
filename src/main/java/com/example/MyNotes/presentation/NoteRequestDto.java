package com.example.MyNotes.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteRequestDto {

    private String author;
    private String title;
    private String body;
}
