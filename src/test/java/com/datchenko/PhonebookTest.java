package com.datchenko;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhonebookTest {
    @Test
    public void searchPerson() throws Exception {
        assertNotNull(new Phonebook().searchPerson("Петров Дмитрий Борисович"));
    }
}