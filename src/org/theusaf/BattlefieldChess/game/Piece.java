package org.theusaf.BattlefieldChess.game;

public class Piece {

  protected Position position;
  protected Character character;
  protected final Board BOARD;
  protected GameTeam team;

  public Piece(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public Piece(Board board, Position position, GameTeam team) {
    BOARD = board;
    this.position = position;
    this.team = team;
  }

  protected boolean isOnBoard() {
    return position != null;
  }

  protected int frontDirectionMultiplier() {
    return team == GameTeam.WHITE ? 1 : -1;
  }

  public Position[] getPossiblePositions() {
    return null;
  }

  public void moveTo(Position position) {
    position.setPiece(this);
  }

  public boolean canMoveTo(Position position) {
    return true;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public GameTeam getTeam() {
    return team;
  }

  public void setTeam(GameTeam team) {
    this.team = team;
  }

  public Piece copy() {
    Piece clone = new Piece(BOARD, position, team);
    if (character != null) {
      clone.setCharacter(character.copy());
    }
    if (position != null) {
      Position positionClone = position.copy();
      positionClone.setPiece(clone);
      clone.setPosition(positionClone);
    }
    return clone;
  }

}
