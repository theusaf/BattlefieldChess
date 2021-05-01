package org.theusaf.BattlefieldChess.util;

public class Copyable<CopyType> {

  private boolean cloned;

  public Copyable() {
    cloned = false;
  }

  public boolean isCloned() {
    return cloned;
  }

  public final CopyType copy() {
    cloned = true;
    return copySpecific();
  }

  protected CopyType copySpecific() {
    return null;
  }

}
