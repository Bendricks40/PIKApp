package com.bendricks;

import com.bendricks.model.Person;
import com.bendricks.model.ContactList;

import java.util.*;
import java.util.List;
import java.util.ArrayList;



public class Pik {
  
 public static void main(String[] args) {
   Person person = new Person("Ben", "Hendricks", "Market Street walk","October 10th, 2017");
   ContactList contactList = new ContactList();
   System.out.printf("Adding %s  %n", person);
   contactList.addPerson(person);
   System.out.printf("There are %d people in your contact list %n", contactList.getPersonCount());
  }
}


                              
                              