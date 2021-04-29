package org.theusaf.BattlefieldChess;

import org.theusaf.BattlefieldChess.util.AudioCache;
import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents the main application sketch.
 */
public class ApplicationSketch extends PApplet {

  private AudioCache audioCache;

  public ApplicationSketch() {
    // Constructor for setting up your instance variables
  }

  @Override
  public void settings() {
    // Code to set up settings, such as size, title, etc.
    size(800, 800, P3D);
  }

  @Override
  public void setup() {
    // Code to set up your program, load images, etc.
    surface.setTitle("Battlefield Chess");
    audioCache = new AudioCache(this);
  }

  @Override
  public void draw(){
    // Code to render objects
  }

  @Override
  public void keyPressed() {

  }

  @Override
  public void mousePressed() {

  }

  @Override
  public void mouseWheel(MouseEvent e) {

  }

  public AudioCache getAudioCache() {
    return audioCache;
  }
}
