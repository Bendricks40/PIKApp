package com.bendricks.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ContactList {

    private List<Person> mContactList;

    public ContactList() {
        mContactList = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        mContactList.add(person);
    }

    public int getPersonCount() {
        return mContactList.size();
    }

    //this should be an ArrayList of Persons which is passed bac to PIKInterface. Then in the PIKInterface, do the output code to display the persons.
    private ArrayList<String> byContacts() {
        ArrayList<String> allContacts = new ArrayList<String>();
        Integer Counter = 0;

        for (Person person : mContactList) {
            String nextPerson = (Counter + 1) + "). " + person.getFirstName() + " " + person.getLastName() + "  Location met:  " + person.getLocationMet() + "  Date met:  " + person.getTimeMet();
            Counter++;
            System.out.printf("%s %n", nextPerson);
            allContacts.add(nextPerson);
        }
        System.out.printf("%n");
        return allContacts;

    }

    public ArrayList<String> publicByContacts() {
        return byContacts();
    }


    public void exportTo(String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                PrintWriter writer = new PrintWriter(fos);
        ) {
            for (Person person : mContactList) {
                writer.printf("%s|%s|%s|%s%n",
                        person.getFirstName(),
                        person.getLastName(),
                        person.getTimeMet(),
                        person.getLocationMet());

            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void importFrom(String fileName) {
        try (
                FileInputStream fis = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\|");
                addPerson(new Person(args[0], args[1], args[2], args[3]));
            }
        } catch (IOException ioe) {
            System.out.printf("Problems loading %s %n", fileName);
            ioe.printStackTrace();
        }
    }


}