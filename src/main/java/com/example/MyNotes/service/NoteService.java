package com.example.MyNotes.service;

import com.example.MyNotes.data.NoteEntity;
import com.example.MyNotes.data.NoteRepository;
import com.example.MyNotes.service.exceptions.NullAuthorException;
import com.example.MyNotes.service.exceptions.NullBodyException;
import com.example.MyNotes.service.exceptions.NullTitleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note) throws NullTitleException, NullBodyException, NullAuthorException {

        // Business Logic
        if (note.getAuthor() == null || note.getAuthor().isEmpty()) throw new NullAuthorException();
        if (note.getTitle() == null || note.getTitle().isEmpty()) throw new NullTitleException();
        if (note.getBody() == null || note.getBody().isEmpty()) throw new NullBodyException();

        // Call Repository
        NoteEntity noteEntity = new NoteEntity();
        // Mapping
        noteEntity.setAuthor(note.getAuthor());
        noteEntity.setBody(note.getBody());
        noteEntity.setTitle(note.getTitle());

        noteRepository.save(noteEntity);
    }
}
