package org.theusaf.BattlefieldChess.util;

import processing.core.PApplet;
import processing.sound.SoundFile;

import java.util.HashMap;

/**
 * Represents a cache for sounds.
 */
public class AudioCache {

  private final PApplet SKETCH;
  private final HashMap<String, SoundFile> SOUND_HASH_MAP;

  /**
   * Constructs an audio cache.
   *
   * @param sketch The sketch to generate the sound files upon
   */
  public AudioCache(PApplet sketch) {
    SKETCH = sketch;
    SOUND_HASH_MAP = new HashMap<>();
  }

  /**
   * Gets the specified sound from the cache.
   *
   * @param key The path to the sound file.
   * @return The cached sound. If the sound is not in the cache, returns <code>null</code>.
   * The sound will then be asynchronously loaded and cached.
   */
  public SoundFile getAudio(String key) {
    SoundFile sound = SOUND_HASH_MAP.get(key);
    if (sound == null) {
      loadAudioAsynchronously(key);
    }
    return sound;
  }

  /**
   * Removes audio from the cache.
   *
   * @param key The path to the audio file to remove from the cache
   */
  public void removeAudio(String key) {
    SOUND_HASH_MAP.remove(key);
  }

  private void loadAudioAsynchronously(String key) {

    class AudioLoader implements Runnable {

      public void run() {
        SoundFile file = new SoundFile(SKETCH, key, false);
        SOUND_HASH_MAP.put(key, file);
      }

    }

    AudioLoader audioLoader = new AudioLoader();
    Thread audioLoadThread = new Thread(audioLoader);
    audioLoadThread.start();

  }

}
