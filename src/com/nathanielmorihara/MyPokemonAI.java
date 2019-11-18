/**
 * Copyright (C) 2019 Urban Compass, Inc.
 */
package com.nathanielmorihara;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author nathaniel.morihara
 */
public class MyPokemonAI {

  // TODO I think this works pretty well but....is it too simple? I kinda want the complex behavior that you can't exactly just hack...
  // and by nature that makes it harder. So I don't think I really can get that without ML

  double aggression = 1.0;
  double timidity = 1.0;
  double obedience = 1.0;
  double appetite = 1.0;
  double laziness = 1.0;

  // TODO I don't have these quite doing what I want them to do...
  double fleeThreshold = 20;
  double attackThreshold = 5;
  double eatThreshold = 50;

  public Action decideAction(WorldState worldState) {
    Map<Action, Decision> decisions = new HashMap<Action, Decision>();

    // If timid & enemy near, flee
    decisions.put(Action.FLEE, new Decision(Action.FLEE, timidity * (fleeThreshold / distance(worldState.enemyLocation, worldState.myLocation))));

    // If obedient & trainer near, follow
    decisions.put(Action.FOLLOW, new Decision(Action.FOLLOW, obedience * distance(worldState.trainerLocation, worldState.myLocation)));

    // If aggressive & enemy near, attack
    decisions.put(Action.ATTACK, new Decision(Action.ATTACK, aggression * (attackThreshold / distance(worldState.enemyLocation, worldState.myLocation))));

    // If appetite & food near, eat
    decisions.put(Action.EAT, new Decision(Action.EAT, appetite * (eatThreshold / distance(worldState.foodLocation, worldState.myLocation))));

    // If lazy, relax
    decisions.put(Action.RELAX, new Decision(Action.RELAX, laziness));

    System.out.println(decisions.values());
    Decision decision = Collections.max(decisions.values());

    return decision.action;
  }

  public void reinforce() {
    // TODO Add to the traits that resulted in the past few decisions
  }

  public void mistake() {
    // TODO Subtract from the traits  that resulted in the past few decisions
  }

  private double distance(Location l1, Location l2) {
    return Math.sqrt((l2.x-l1.x)*(l2.x-l1.x) + (l2.y-l1.y)*(l2.y-l1.y));
  }
}
