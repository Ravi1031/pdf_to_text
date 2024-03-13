package com.rv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {

        @Test
        @DisplayName("Test case for creating contact successfully.........")
        public void shouldCreateContact(){
                ContactManager contactManager = new ContactManager();
                contactManager.addContact("Ravi","Prakash","0123456789");
                Assertions.assertEquals(1,contactManager.getAllContact().size());
                Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        }

        @Test
        @DisplayName("Test case for Not creating contact with first name.......")
        public void validateFirstNameEmpty(){
                ContactManager contactManager = new ContactManager();
                Assertions.assertThrows(RuntimeException.class,()->{
                   contactManager.addContact(null,"Prakash","0123456789");
                });
        }

        @Test
        @DisplayName("Test case for not creating contact with the last name....")
        public void validateLastNameEmpty(){
                ContactManager contactManager = new ContactManager();
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi",null,"0123456789"));
        }

        @Test
        @DisplayName("Test case for not creating contact with contact number....")
        public void validateContactNumber(){
                ContactManager contactManager = new ContactManager();
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi","Prakash",null));
        }
}
