package org.theusaf.BattlefieldChess;

import org.theusaf.BattlefieldChess.ui.Screen;
import org.theusaf.BattlefieldChess.util.AudioCache;
import processing.core.PApplet;

/**
 * Represents the main application sketch.
 */
public class WindowSketch extends PApplet {

  protected AudioCache audioCache;
  protected Screen currentScreen;

  public WindowSketch() {
    // Constructor for setting up your instance variables
  }

  @Override
  public void setup() {
    // Code to set up your program, load images, etc.
    audioCache = new AudioCache(this);
  }

  public AudioCache getAudioCache() {
    return audioCache;
  }
}
