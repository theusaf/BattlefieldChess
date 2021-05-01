package org.theusaf.BattlefieldChess.ui;

import processing.core.PApplet;

/**
 * Represents a screen (like a "tab" or "scene").
 */
public class Screen {

  /**
   * The sketch the screen is being rendered to
   */
  protected final PApplet SKETCH;

  /**
   * Constructs a screen.
   *
   * @param sketch The sketch the screen will be rendered to
   */
  public Screen(PApplet sketch) {
    SKETCH = sketch;
  }

  /**
   * Draws the screen.
   */
  public void draw() {}

  /**
   * Updates data for the screen. Used for animation timings and stuff.
   */
  public void update() {}

}
