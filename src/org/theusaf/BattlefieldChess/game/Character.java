package org.theusaf.BattlefieldChess.game;

public class Character {

  private int healthPoints, defensePoints, magicDefensePoints, attackPoints, speedPoints;
  private final String NAME;

  public Character(String name) {
    // TODO: Replace with default values
    this(name, 0, 0, 0, 0, 0);
  }

  public Character(String name, int hp, int def, int mDef, int atk, int spd) {
    NAME = name;
    healthPoints = hp;
    defensePoints = def;
    magicDefensePoints = mDef;
    attackPoints = atk;
    speedPoints = spd;
  }

  public Character copy() {
    return new Character(NAME, healthPoints, defensePoints, magicDefensePoints, attackPoints, speedPoints);
  }

  public String getName() {
    return NAME;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public int getDefensePoints() {
    return defensePoints;
  }

  public void setDefensePoints(int defensePoints) {
    this.defensePoints = defensePoints;
  }

  public int getMagicDefensePoints() {
    return magicDefensePoints;
  }

  public void setMagicDefensePoints(int magicDefensePoints) {
    this.magicDefensePoints = magicDefensePoints;
  }

  public int getAttackPoints() {
    return attackPoints;
  }

  public void setAttackPoints(int attackPoints) {
    this.attackPoints = attackPoints;
  }

  public int getSpeedPoints() {
    return speedPoints;
  }

  public void setSpeedPoints(int speedPoints) {
    this.speedPoints = speedPoints;
  }

}
