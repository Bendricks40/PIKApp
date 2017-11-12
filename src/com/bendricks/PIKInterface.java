package com.bendricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.bendricks.model.ContactList;
import com.bendricks.model.Person;


public class PIKInterface {
    private ContactList mContactList;
    private BufferedReader mReader;
    private Map<String, String> mMenu;

    public PIKInterface(ContactList contactList) {
        mContactList = contactList;
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new HashMap<String, String>();
        mMenu.put("add", "Add a new person to the contact list");
        mMenu.put("view", "View your contact List");
        mMenu.put("quit", "Saves your contact list and exits the program");
    }

    private String promptAction() throws IOException {
        System.out.printf("There are %d people available in your contact list.  Your options are: %n",
                mContactList.getPersonCount());
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n",
                    option.getKey(),
                    option.getValue());
        }
        System.out.print("What do you want to do:  ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run() {
        String choice = "";
        do {
            try {
                choice = promptAction();
                switch (choice) {
                    case "add":
                       System.out.printf("%nYou chose ADD. Enter info below: %n%n");
                       Person person = promptNewPerson();
                       mContactList.addPerson(person);
                        break;
                    case "view":
                        System.out.printf("%nYou chose VIEW. Here are all your contacts and when/where you met them: %n%n");
                        mContactList.publicByContacts();
                        break;
                    case "quit":
                        System.out.printf("%nThanks for using PIK!!%n%n");
                        break;
                    default:
                        System.out.printf("%nUnknown choice:  '%s'. Try again.  %n%n%n",
                                choice);
                }
            } catch (IOException ioe) {
                System.out.println("%nProblem with input%n%n");
                ioe.printStackTrace();
            }
        } while (!choice.equals("quit"));
    }

    private Person promptNewPerson() throws IOException {
        System.out.print("Enter first name:  ");
        String firstname = mReader.readLine();
        System.out.print("Enter last name:  ");
        String lastname = mReader.readLine();
        System.out.print("Enter the TIME you met this person:  ");
        String time = mReader.readLine();
        System.out.print("Enter the location you met this person:  ");
        String location = mReader.readLine();
        return new Person(firstname, lastname, location, time);
    }

    private void showAvailableContacts() throws IOException {
        System.out.println("Available contacts:");
        List<String> allPersons = new ArrayList<>(mContactList.publicByContacts());
        for (String name : allPersons) {
            System.out.printf("This is a test...");
        }
    }



}
