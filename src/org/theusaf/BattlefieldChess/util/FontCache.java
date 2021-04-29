package org.theusaf.BattlefieldChess.util;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.HashMap;

public class FontCache {

  private static final int FONT_SIZE = 64;

  private final PApplet SKETCH;
  private final HashMap<String, PFont> FONT_HASH_MAP;

  public FontCache(PApplet sketch) {
    SKETCH = sketch;
    FONT_HASH_MAP = new HashMap<>();
  }

  public PFont getFont(String key) {
    PFont font = FONT_HASH_MAP.get(key);
    if (font == null) {
      return generateFont(key);
    }
    return font;
  }

  private PFont generateFont(String key) {
    PFont font = SKETCH.createFont(key, FONT_SIZE);
    FONT_HASH_MAP.put(key, font);
    return font;
  }

}
