# Overview


# Terminology
* __Current Piece__ - The piece that the player is in direct control of.
* __Falling/Gravity__ - Gamerule that causes the Current Piece to be translated 1 position downward after a certain amount of time.
* __Block__ - An object that takes up a 1x1 space on the board. Can be a part of the Current Piece or a "dead block".
* __Dead Blocks__ - Semi-static Blocks on the Field that the player cannot move.
* __Ground__ - The bottom of the Field
* __Landing__ - Event that occurs when Gravity would cause the Current Piece to intersect with another object (Ground, DeadBlocks).
* __Spawn__ - The creation of a new Current Piece
* __Game Over__ - Event that ends the game
* __Height Limit__ - Height threshold on the Field
* __Cleared__ - Refering to a row on the Field, when all of the Dead Blocks in it are eliminated
 
# Basic Game Rules
The player can manipulate the Current Piece by translating it left, right, and down as well as rotating it about its center of mass.

The Current Piece continuously Falls until it Lands on either the Ground or on Dead Blocks.

Once the Current Piece Lands, it turns into Dead Blocks. A new Current Piece then Spawns.

Once a row is completely filled with Dead Blocks, it is Cleared and all of the Dead Blocks ontop of it are translated down.

A Game Over is triggered whenever the Dead Blocks reach the Height Limit.


# The Board
The __Board__ consists of a 10 x 20 block matrix that starts out empty.

The __Board__ stores the position of any blocks that the player is not in posession of

Blocks cannot move past the boundaries of the __Board__. When the Current Piece hits the ground the player loses control of it.

If the __Board__ is filled up to the top so that no more blocks can be spawned, then the game ends.

# The Pieces
There are 7 tetris blocks:
* I-block, 
* J-block, 
* L-block, 
* O-block, 
* S-block, 
* T-block, 
* Z-block
   
Each block is named according to the letter it appears most like. All blocks, with the exception of __I-blocks__ and __O-blocks__, are contained within a 3x3 matrix. The __O-blocks__ use a 2x2 matrix, while the __I-blocks__ use a 1x4 matrix.
# Design