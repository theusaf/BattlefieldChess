package org.theusaf.BattlefieldChess.util;

import processing.core.PApplet;
import processing.sound.SoundFile;

import java.util.HashMap;

public class AudioCache {

  private final PApplet SKETCH;
  private final HashMap<String, SoundFile> SOUND_HASH_MAP;

  public AudioCache(PApplet sketch) {
    SKETCH = sketch;
    SOUND_HASH_MAP = new HashMap<>();
  }

  public SoundFile getAudio(String key) {
    SoundFile sound = SOUND_HASH_MAP.get(key);
    if (sound == null) {
      loadAudioAsynchronously(key);
    }
    return sound;
  }

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
