package org.theusaf.BattlefieldChess.util;

/**
 * Represents a cloneable object.
 * This class is meant to be extended with <code>CopyType</code> set to the class that is extending this.
 *
 * @param <CopyType> The type of object to return when copying it.
 */
public class Copyable<CopyType> {

  private boolean cloned;

  /**
   * Constructs a copyable object.
   */
  public Copyable() {
    cloned = false;
  }

  /**
   * Returns whether this object is a clone.
   *
   * @return whether this object is a clone
   */
  public boolean isClone() {
    return cloned;
  }

  /**
   * Copies the object.
   * Returns <code>null</code> by default.
   * To customize this, please Override {@link #copySpecific()}
   *
   * @return The copied object
   */
  @SuppressWarnings("rawtypes")
  public final CopyType copy() {
    CopyType clone = copySpecific();
    if (clone instanceof Copyable) {
      ((Copyable) clone).setCloned();
    }
    return clone;
  }

  private void setCloned() {
    this.cloned = true;
  }

  /**
   * Actually generates the cloned object.
   * By default, returns <code>null</code>.
   * Override this method to return a different object.
   *
   * @return The clone of the object.
   */
  protected CopyType copySpecific() {
    return null;
  }

}
