package com.nathanielmorihara;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    MyPokemonAI myPokemonAI = new MyPokemonAI();

    List<WorldState> worldStateList = new ArrayList<WorldState>();
    worldStateList.add(new WorldState(
        new Location(0, 0),
        new Location(10, 0),
        new Location(10, 0),
        new Location(1, 0)
    ));
    worldStateList.add(new WorldState(
        new Location(0, 0),
        new Location(5, 0),
        new Location(2, 0),
        new Location(10, 0)
    ));
    worldStateList.add(new WorldState(
        new Location(0, 0),
        new Location(0.1, 0),
        new Location(0.1, 0),
        new Location(100, 0)
    ));
    worldStateList.add(new WorldState(
        new Location(0, 0),
        new Location(50, 0),
        new Location(1, 0),
        new Location(10, 0)
    ));
    worldStateList.add(new WorldState(
        new Location(0, 0), // My
        new Location(1, 0), // Trainer
        new Location(100, 0), // Enemy
        new Location(200, 0)  // Food
    ));

    for (WorldState worldState : worldStateList) {
      Action action = myPokemonAI.decideAction(worldState);
      System.out.println(action);
    }
  }
}
