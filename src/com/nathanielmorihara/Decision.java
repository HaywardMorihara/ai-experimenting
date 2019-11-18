/**
 * Copyright (C) 2019 Urban Compass, Inc.
 */
package com.nathanielmorihara;

/**
 * @author nathaniel.morihara
 */
class Decision implements Comparable<Decision> {
  Action action;
  Double value;

  public Decision(Action action, Double value) {
    this.action = action;
    this.value = value;
  }

  public int compareTo(Decision decision) {
    if (decision.value > this.value) {
      return -1;
    }
    if (decision.value == this.value) {
      return 0;
    }
    if (decision.value < this.value) {
      return 1;
    }
    return 0;
  }

  public String toString() {
    return "[" + action + ", " + value + "]";
  }
}
