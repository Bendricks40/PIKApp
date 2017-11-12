package com.bendricks.model;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


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

 private ArrayList<String> byContacts() {
  ArrayList<String> allContacts = new ArrayList<String>();

      for (Person person : mContactList) {
String nextPerson =person.getFirstName() + "  " + person.getLastName() + "  Location met:  " + person.getLocationMet() + "  Date met:  " + person.getTimeMet();
System.out.printf("%s %n",nextPerson);
allContacts.add(nextPerson);
  }
     System.out.printf("%n");
return allContacts;

  }

 public ArrayList<String> publicByContacts() {
   return byContacts();
 }





}