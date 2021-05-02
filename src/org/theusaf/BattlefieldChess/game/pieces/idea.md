Maybe instead of having to override canMoveTo and stuff try the following:

Multiple functions for various tasks in `Piece`
- `getAttackablePositions`
    - gets the positions that can be attacked
- `getMoveablePositions`
    - gets the positions that can be moved to (empty)
- `getSpecialActivePositions`
    - gets the positions that can be targeted by the active skill(s)
- `getSpecialPassivePositions`
    - gets the positions that are targeted by the passive skills
- `getTheoreticalPositions`
    - all movable squares (assuming board empty)

Then, using a class like `PawnMovementFilter` which returns the positions required.

For the special stuff, that could be a later thing.