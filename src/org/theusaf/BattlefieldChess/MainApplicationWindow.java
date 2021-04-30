package org.theusaf.BattlefieldChess;

import org.theusaf.BattlefieldChess.ui.screens.MainMenuScreen;

public class MainApplicationWindow extends WindowSketch {

  @Override
  public void settings() {
    // Code to set up settings, such as size, title, etc.
    size(800, 800, P3D);
  }

  @Override
  public void setup() {
    super.setup();
    // Code to set up your program, load images, etc.
    surface.setTitle("Battlefield Chess");
    currentScreen = new MainMenuScreen(this);
  }

}
