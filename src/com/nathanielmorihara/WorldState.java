/**
 * Copyright (C) 2019 Urban Compass, Inc.
 */
package com.nathanielmorihara;

/**
 * @author nathaniel.morihara
 */
public class WorldState {
  Location myLocation;
  Location trainerLocation;
  Location enemyLocation;
  Location foodLocation;

  public WorldState(Location myLocation, Location trainerLocation, Location enemyLocation, Location foodLocation) {
    this.myLocation = myLocation;
    this.trainerLocation = trainerLocation;
    this.enemyLocation = enemyLocation;
    this.foodLocation = foodLocation;
  }
}
