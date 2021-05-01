package org.theusaf.BattlefieldChess.util;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.HashMap;

/**
 * Represents a cache for fonts.
 */
public class FontCache {

  private static final int FONT_SIZE = 64;

  private final PApplet SKETCH;
  private final HashMap<String, PFont> FONT_HASH_MAP;

  /**
   * Constructs a font cache.
   *
   * @param sketch The PApplet sketch to generate fonts with
   */
  public FontCache(PApplet sketch) {
    SKETCH = sketch;
    FONT_HASH_MAP = new HashMap<>();
  }

  /**
   * Gets a font by name. If the font doesn't exist in the cache, it generates and caches a new font by that name.
   * Fonts are set to size 64.
   *
   * @param key The name of the font
   * @return The cached font
   */
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
