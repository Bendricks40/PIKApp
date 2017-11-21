package com.bendricks;

import com.bendricks.model.Person;
import com.bendricks.model.ContactList;

import java.util.*;
import java.util.List;
import java.util.ArrayList;



public class Pik {
  
 public static void main(String[] args) {
   ContactList contactList = new ContactList();
   contactList.importFrom("savedcontacts.txt");
   PIKInterface pikInterface = new PIKInterface(contactList);
   System.out.printf("There are %d people in your contact list %n", contactList.getPersonCount());
   pikInterface.run();
System.out.println("Saving Contacts...");
contactList.exportTo("savedcontacts.txt");

  }
}


                              
                              