# Battlefield Chess
Inspired by Chess and Fire Emblem Heroes

### The board
The board is exactly the same as a regular chess board.

### Piece movement
Pieces move as you expect on the board.

### Piece capture/battle
When a piece attacks another piece, the defending piece's position is only captured if it is completely defeated (HP < 0) by the attacking piece.

If the defending piece survives the attack, it remains in the same location, and the attacking piece moves as close as possible to the defender along its path of attack.

Examples:
1. Bishop vs Pawn 
    1. A bishop on `B2` attacks a pawn on `G7`. 
    2. The bishop fails to defeat the pawn. 
    3. The bishop then moves to `F6`.
2. Knight vs Queen
    1. A knight on `D4` attacks a queen on `E6`. 
    2. The knight fails to defeat the queen. 
    3. The knight and queen stay on their respective squares.
    
### Types of weapons
- Staff
    - Magical weapon
    - Effective against cavalry
- Healing Staff
    - If a unit has this weapon, they will not have the 'Heal' skill.
    - Does not deal damage
- Bow
    - Physical weapon
    - Effective against flying enemies
- Spear
    - Physical weapon
    - Advantage over swords
- Axe
    - Physical weapon
    - Advantage over spears
- Sword
    - Physical weapon
    - Advantage over axes
- Throwing Knives
    - Lowers target's defense during combat by a percent
    - More effective against targets using bows
- Hand
    - Only used by Beasts
    - Physical attack
- Magic Beam
    - Only used by Demons
    - Magic attack

### Types of pieces
- Cavalry
    - Advantage against:
        - Infantry
        - Heavy Infantry
- Flying
    - Advantage against:
        - Beasts
        - Infantry
- Infantry
    - Advantage against:
        - Demons
        - Heavy Infantry
- Heavy Infantry
    - Advantage against:
        - Demons
        - Flying
- Beast
    - Must use Hand weapon
    - Advantage against:
        - Cavalry
        - Heavy Infantry
- Demons
    - Must use Magic Beam weapon
    - Advantage against:
        - Beasts
        - Cavalry

### Elemental Type
- None
    - Does not beat and is not beaten by any other type
- Water
    - Beats Fire
- Fire
    - Beats Ground
- Ground
    - Beats Water
    
### Special Skills
- Heal
    - Can restore HP of friendly troops as its move.
    - Only compatible with Staff users.
- Cheer
    - Enables the target to have two moves the next turn (if that piece is used).
    - The target cannot have the Cheer skill.
    
### Pre-battle
- Effects from the last turn are decremented/removed.
- All passive skills that enhance friendly pieces and weaken enemy pieces are activated.

### Battle
1. Bonus stats are calculated (passive skills, type advantages).
2. Unless defender has a skill to counterattack first, attacker engages first.
3. Attacker deals damage `(ATK - (DEF/M. DEF))`
    - `DEF` is used against physical attacks.
    - `M. DEF` is used against magical attacks.
4. If the defender is still alive, it can counterattack if the original position of the attacker is in the defender's attack path.
    - This is subject to change.
    - In this way, the opponent's piece can be defeated when it's not one's turn.
    
### Bonus Stats
TODO

### Check
The King is in check only if it is under the threat of an attack that can defeat it.

The King can also move into danger, as long as the danger is not lethal.

### Checkmate
Checkmate occurs when the King is in check, and:
- The King cannot move to a nonlethal position
- The attacker cannot be taken out by a defending piece
- The path of attack cannot be blocked by a defending piece

### Stalemate
- The King is not in check, but there are no valid moves to do.
- The same position is played 3 times in a row by both sides.

### Castling
The King can castle if:
- The King and the Rook have not moved from their starting positions.
- The spaces between the Rook and the King must be empty  
- It is not under threat of attack (even if nonlethal).
- All the squares in the path of castling are not under attack.

### En Passant
Rules to do En Passant are the same as normal chess.

The pawns battle, and regardless if the defending pawn is defeated, if the attacking pawn survives (which it should always survive...), it moves to the position behind the defending pawn.

## Why?
Clearly, this project exists just to make that scene from Code Geass possible.