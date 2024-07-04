package com.example.MyNotes.data;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addNote(NoteEntity noteEntity){
        //sessionFactory.getCurrentSession().persist();
    }
}
