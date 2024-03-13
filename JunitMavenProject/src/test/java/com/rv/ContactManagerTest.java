package com.rv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {

        private ContactManager contactManager;
        @BeforeEach
        void setUp(){
                System.out.println("Inside before each");
                contactManager = new ContactManager();
        }

        @Test
        @DisplayName("Test case for creating contact successfully.........")
        public void shouldCreateContact(){
                contactManager.addContact("Ravi","Prakash","0123456789");
                Assertions.assertEquals(1,contactManager.getAllContact().size());
                Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        }

        @Test
        @DisplayName("Test case for Not creating contact with first name.......")
        public void validateFirstNameEmpty(){
                Assertions.assertThrows(RuntimeException.class,()->{
                   contactManager.addContact(null,"Prakash","0123456789");
                });
        }

        @Test
        @DisplayName("Test case for not creating contact with the last name....")
        public void validateLastNameEmpty(){
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi",null,"0123456789"));
        }

        @Test
        @DisplayName("Test case for not creating contact with contact number....")
        public void validateContactNumber(){
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi","Prakash",null));
        }

        @Test
        @DisplayName("Test case for contact size not equals to 10..")
        public void validateContactNumberSize(){
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi","Prakash","01234567891"));
        }

        @Test
        @DisplayName("Test case for contact not starting with zero..")
        public void validateContactNotStartingWithZero(){
                Assertions.assertThrows(RuntimeException.class,
                        ()->contactManager.addContact("Ravi","Prakash","1234567890"));
        }

        @Test
        @DisplayName("Test for existing contact..->")
        public void validateContactAlreadyExist(){
                contactManager.addContact("Ravi","Prakash","0123456789");
                Assertions.assertThrows(RuntimeException.class,
                        ()-> contactManager.addContact("Ravi","Prakash","0123456789"),
                        "Contact already exist");
        }
}
