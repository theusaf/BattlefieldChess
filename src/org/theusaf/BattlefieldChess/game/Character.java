package org.theusaf.BattlefieldChess.game;

/**
 * Represents a character. A character is an object that contains the various stats of the pieces.
 */
public class Character {

  private int healthPoints, defensePoints, magicDefensePoints, attackPoints, speedPoints;
  private final String NAME;

  /**
   * Constructs a character with default values.
   * TODO: Add default values to this documentation
   *
   * @param name The name of the character
   */
  public Character(String name) {
    // TODO: Replace with default values
    this(name, 0, 0, 0, 0, 0);
  }

  /**
   * Constructs a character with custom stats.
   * TODO: Add an explanation of what the stats do.
   *
   * @param name The character's name
   * @param hp   The character's health
   * @param def  The character's physical defense
   * @param mDef The character's magical defense
   * @param atk  The character's attack stat
   * @param spd  The character's speed stat
   */
  public Character(String name, int hp, int def, int mDef, int atk, int spd) {
    NAME = name;
    healthPoints = hp;
    defensePoints = def;
    magicDefensePoints = mDef;
    attackPoints = atk;
    speedPoints = spd;
  }

  /**
   * Creates a clone of this character.
   *
   * @return A clone of this character
   */
  public Character copy() {
    return new Character(NAME, healthPoints, defensePoints, magicDefensePoints, attackPoints, speedPoints);
  }

  /**
   * Gets this character's name
   *
   * @return this character's name
   */
  public String getName() {
    return NAME;
  }

  /**
   * Gets this character's health.
   *
   * @return this character's health
   */
  public int getHealthPoints() {
    return healthPoints;
  }

  /**
   * Sets this character's health.
   *
   * @param healthPoints the value to set the health to
   */
  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  /**
   * Gets this character's physical defense stat.
   *
   * @return this character's physical defense stat
   */
  public int getDefensePoints() {
    return defensePoints;
  }

  /**
   * Sets this character's physical defense stat.
   *
   * @param defensePoints The value to set the defense stat to
   */
  public void setDefensePoints(int defensePoints) {
    this.defensePoints = defensePoints;
  }

  /**
   * Gets this character's magical defense stat.
   *
   * @return this character's magical defense stat
   */
  public int getMagicDefensePoints() {
    return magicDefensePoints;
  }

  /**
   * Sets this character's magic defense stat.
   *
   * @param magicDefensePoints The value to set the defense stat to
   */
  public void setMagicDefensePoints(int magicDefensePoints) {
    this.magicDefensePoints = magicDefensePoints;
  }

  /**
   * Gets this character's attack stat.
   *
   * @return This character's attack stat
   */
  public int getAttackPoints() {
    return attackPoints;
  }

  /**
   * Sets this character's attack stat.
   *
   * @param attackPoints The value to set the attack stat to
   */
  public void setAttackPoints(int attackPoints) {
    this.attackPoints = attackPoints;
  }

  /**
   * Gets this character's speed stat.
   *
   * @return This character's speed stat
   */
  public int getSpeedPoints() {
    return speedPoints;
  }

  /**
   * Sets this character's speed stat.
   *
   * @param speedPoints The value to set the speed stat to
   */
  public void setSpeedPoints(int speedPoints) {
    this.speedPoints = speedPoints;
  }

}
