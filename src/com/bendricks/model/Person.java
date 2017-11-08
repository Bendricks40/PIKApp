package com.bendricks.model;

import java.util.*;
import java.util.List;
import java.util.ArrayList;


public class Person {
 
  private String mFirstName;
  private String mLastName;
  private String mTimeMet;
  private String mLocationMet;
  
  public Person (String FirstName, String LastName, String TimeMet, String LocationMet) {
      mFirstName = FirstName;
      mLastName = LastName;
      mTimeMet = TimeMet;
      mLocationMet = LocationMet;
  }
  
  @Override
  public String toString() {
   return String.format("Person: %s %s, and you met them at %s on %s", mFirstName, mLastName, mTimeMet, mLocationMet); 
  }
  
  public String getFirstName() {
    return mFirstName;
  }
  
   public String getLastName() {
    return mLastName;
  }
  
   public String getTimeMet() {
    return mTimeMet;
  }
  
   public String getLocationMet() {
    return mLocationMet;
  }
  
  
  
}