package org.theusaf.BattlefieldChess;

import processing.core.PApplet;

public class ApplicationSketch extends PApplet {

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
  }

  @Override
  public void draw(){
    // Code to render objects
  }
}