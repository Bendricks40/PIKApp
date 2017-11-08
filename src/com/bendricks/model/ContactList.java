package com.bendricks.model;
import java.util.*;
import java.util.List;
import java.util.ArrayList;



public class ContactList {
  
 private List<Person> mContactList;
  
  public ContactList() {
   mContactList = new ArrayList<Person>(); 
  }

  public void addPerson(Person person) {
      mContactList.add(person);
  }
  
  public int getPersonCount () {
   return mContactList.size();
  }
  
  
}