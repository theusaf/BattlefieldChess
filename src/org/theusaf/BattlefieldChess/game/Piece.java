package org.theusaf.BattlefieldChess.game;

import org.theusaf.BattlefieldChess.util.Copyable;

/**
 * Represents a piece on the board.
 */
public class Piece extends Copyable<Piece> {

  /**
   * The position of the piece
   */
  protected Position position;

  /**
   * The piece's character and stats
   */
  protected Character character;

  /**
   * The board the piece is on
   */
  protected Board board;

  /**
   * The team the piece is on
   */
  protected GameTeam team;

  /**
   * Constructs a piece (no location, default team WHITE)
   *
   * @param board The board the piece should be given a position on later
   */
  public Piece(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  /**
   * Constructs a piece with a location on the board with a custom team.
   *
   * @param board The board the piece is located on
   * @param position The position the piece is located on.
   *                 <br>
   *                 The piece will automatically be added to the position if the position is not null
   * @param team The team the piece is on
   */
  public Piece(Board board, Position position, GameTeam team) {
    this.board = board;
    this.position = position;
    this.team = team;
    if (position != null) {
      position.setPiece(this);
    }
  }

  /**
   * Returns whether the piece is actually on the board.
   *
   * @return Whether the piece has a position on the board
   */
  protected boolean isOnBoard() {
    return position != null;
  }

  /**
   * Returns an integer representing the 'forwards' direction.
   *
   * @return <code>1</code> if the team is WHITE and <code>-1</code> if the team is BLACK.
   */
  protected int frontDirectionMultiplier() {
    return team == GameTeam.WHITE ? 1 : -1;
  }

  /**
   * Returns an integer representing 'n' rows forwards.
   *
   * @param n The number of rows forwards
   * @return A positive integer if WHITE and negative if BLACK
   */
  protected int frontDirectionMultiplier(int n) {
    return team == GameTeam.WHITE ? n : -n;
  }

  /**
   * Gets all plausible positions the piece can move to.
   *
   * @return A list of positions the piece can theoretically move to
   */
  public Position[] getPossiblePositions() {
    return null;
  }

  /**
   * Moves the piece to another position.
   * <br>
   * This also removes the piece from the current position.
   *
   * @param position The new position to move the piece to
   */
  public void moveTo(Position position) {
    this.position.removePiece();
    position.setPiece(this);
  }

  /**
   * Determines whether the piece can actually move to a specified location.
   * <br>
   * <p><strong>Note:</strong></p>
   * <p>This method does not account for putting the King in check.</p>
   * TODO: Add a checkForChecks method and update this documentation.
   *
   * @param position The position to check
   * @return Whether the position given is a possible move
   */
  public boolean canMoveTo(Position position) {
    return true;
  }

  /**
   * Returns the position the piece is on.
   *
   * @return The position the piece is on
   */
  public Position getPosition() {
    return position;
  }

  /**
   * Puts the piece on the given position.
   * <br>
   * <p><b>Note:</b></p>
   * <p>This method will not remove the piece from its old position if it had an old position.</p>
   *
   * @param position The position to put the piece on
   */
  public void setPosition(Position position) {
    this.position = position;
  }

  /**
   * Gets the character for this piece.
   *
   * @return The character for this piece
   */
  public Character getCharacter() {
    return character;
  }

  /**
   * Sets the character for this piece.
   *
   * @param character The character to apply to this piece
   */
  public void setCharacter(Character character) {
    this.character = character;
  }

  /**
   * Gets the team this piece is on.
   *
   * @return The team the piece is on
   */
  public GameTeam getTeam() {
    return team;
  }

  /**
   * Sets the team this piece is on.
   *
   * @param team The team to assign the piece to
   */
  public void setTeam(GameTeam team) {
    this.team = team;
  }

  /**
   * Gets the board the piece is on.
   *
   * @return The board the piece is on
   */
  public Board getBoard() {
    return board;
  }

  /**
   * Sets the board the piece is on.
   *
   * @param board The board the piece is on
   */
  public void setBoard(Board board) {
    this.board = board;
  }

  /**
   * Generates a clone of this piece.
   * <br>
   * The cloned piece will also contain a clone of its character and position.
   *
   * @return The clone of this piece
   */
  protected Piece copySpecific() {
//    Board board = this.board.copy();
    Piece clone = new Piece(board, position, team);
    if (character != null) {
      clone.setCharacter(character.copy());
    }
    if (position != null) {
      Position positionClone = position.copy(true);
      positionClone.setPiece(clone);
      clone.setPosition(positionClone);
    }
    return clone;
  }

  /**
   * Generates a clone of this piece.
   * <br>
   * The cloned piece will not contain a clone of its position, but will contain a clone of its character.
   *
   * @return The clone of this piece
   */
  protected Piece copySpecific(Object... args) {
    // TODO: figure out cloning boards and stuff
//    Board board = this.board.copy();
    Piece clone = new Piece(board, position, team);
    if (character != null) {
      clone.setCharacter(character.copy());
    }
    return clone;
  }

}
