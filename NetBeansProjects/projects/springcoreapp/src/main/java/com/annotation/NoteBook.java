/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bas200181
 */
public class NoteBook {
    private ClassMate classMate;

    public NoteBook() {
    }
    
@Autowired
    public NoteBook(ClassMate classMate) {
        this.classMate = classMate;
    }
    
    
    public void getNoteBook()
    {
        classMate.view();
    }
    
}
