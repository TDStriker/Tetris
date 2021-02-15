# Overview


## Basic Game Rules
The player can manipulate the Current Piece by translating it left, right, and down as well as rotating it about its center of mass.
The Current Piece continuously Falls(moves downward 1 positon after a certain amount of time) until it Lands() on either the Ground(
    the bottom of the Field) or on DeadBlocks() 


## The Board
The board consists of a 10 x 20 block field that starts out completely empty.
Blocks cannot move past the boundaries of the board.
When a bloack hits the bottom of the board it the player loses control of it
If the board is filled up to the top so that no more blocks can be spawned, then the game ends


## The Pieces
There are 7 tetris blocks:
* I-block, 
* J-block, 
* L-block, 
* O-block, 
* S-block, 
* T-block, 
* Z-block
   
Each block is named according to the letter it appears most like. All blocks, with the exception of __I-blocks__ and __O-blocks__, are contained within a 3x3 matrix. 


# Design