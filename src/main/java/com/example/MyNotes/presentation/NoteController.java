package com.example.MyNotes.presentation;

import com.example.MyNotes.service.Note;
import com.example.MyNotes.service.NoteService;
import com.example.MyNotes.service.exceptions.NullAuthorException;
import com.example.MyNotes.service.exceptions.NullBodyException;
import com.example.MyNotes.service.exceptions.NullTitleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public String addNote(@RequestBody NoteRequestDto noteDto){ // Dto: Data Transfer Object
        // Add it in the database

        // mapping
        Note note = new Note(noteDto.getAuthor(), noteDto.getTitle(), noteDto.getBody());
        try {
            // Normal Flow
            noteService.addNote(note);
            return "Note added successfully";
        }
        // Exceptional Flows
        catch (NullTitleException e) {
            return "Note Title cannot be null";
        } catch (NullBodyException e) {
            return "Note Body cannot be null";
        } catch (NullAuthorException e) {
            return "Note Author cannot be null";
        }
    }
}
