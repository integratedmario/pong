# Breakout Plan
### NAME Mario Alvarez


#### Examples

You need to put blank lines to write some text

in separate paragraphs.


Emphasis, aka italics, with *asterisks* or _underscores_.

Strong emphasis, aka bold, with **asterisks** or __underscores__.

Combined emphasis with **asterisks and _underscores_**.


You can also make lists:
* Bullets are made with asterisks
1. You can order things with numbers.


You can put links in like this: [Duke CompSci](https://www.cs.duke.edu)


## Interesting Breakout Variants

 * A variation of Breakout that is mixed with aspects of Space Invaders would be interesting. In essence, the blocks present on screen would move down at a constant rate (perhaps defined by a difficulty setting) and after reaching any block reaches a certain boundary, the game will end in loss for the player. This would likely be implemented leveraging the Y-positions of Rectangle objects, but I'm not sure of the specifics of that yet.
 

 * Another idea inspired by Jet Ball is a variation in which there are much fewer blocks, but they are all moving at constant speeds (albeit not the same between blocks) and the goal is to destroy all blocks without letting the ball reach the top side *either*, so the player would have to predict the blocks' positions.
 
## Paddle Ideas

 * As in classic Breakout, I will have the ball be repelled differently based on where it hits; not by partition of the paddle, but by some formula that detects the exact location the ball intersected the paddle and changes the ball's velocity vector components accordingly and intuitively for the user.
 

 * The paddle will be powered by mouse drag, with optional left and right arrow functionality, as I feel the latter make for clunkier movement.


 * If the mouse is clicked when the ball intersects the paddle, the ball will be repelled at minimum speed.


## Block Ideas

 * __Angel__ (white/gold) blocks that give the paddle an extra life upon destruction.


 * __Virus/Devil__ blocks (purple/black) that symmetrically shrink the paddle upon hits.


 * __Warping__ blocks that teleport to another in-bounds location when hit; must have more than 1 life.
 

 * Blocks with different levels of resistance (I plan on having a unique Block class with a myHealth instance variable).


## Power-up Ideas

 * A symmetric paddle elongator.


 * One that grants the ability to shoot multiple no-stakes (can not remove paddle's lives) balls up in angular directions from the paddle.


 * A power beam that shoots straight upward instantaneously and penetrates all blocks in its path.


## Cheat Key Ideas

 * Instantly grants 99 lives.


 * Sets ball X-component of velocity to 0 and leaves it moving strictly vertically at a slow rate.


 * Doubles the ball radius.


 * The ball will temporarily bounce off the bottom with no repercussions.


## Level Descriptions

This is the most tentative section as I am still not sure of how to implement the blocks
nor of the rules regarding level design. I plan on having a stage 1000x1000 pixels for reference.
Numbers 0 indicate empty space. 1-4 are different healths of blocks. 9 is the paddle, tentatively sized.


### Level 1

This will be the side-moving block level, so there will only be 1 block on a given
horizontal line, at most. They will be moving.

0001000

0002000

0002000

0003000

0002000

0002000

0001000

0000000

0000000

0000000

0000000

0009000

The board will be big enough to support more blocks. The general idea is horizontally
scrolling blocks, and for the ones at the top and bottom of the stacks to be weaker
to make the game a bit easier.

### Level 2

The Space Invaders version, where blocks slowly move down rather than left to right.

0010020

0020002

0301021

0304301

4203022

0202011

0200010

0010001

0000000

0000000

-GAMEOVER-

0000000

0000000

0009000

### Idea 3

The standard Breakout implementation, with the Rectangles of different types
set up in a likely meaningful shape. May be a TIE fighter or heart or something
goofy. Perfect level to implement the Virus and Warping block classes.


## Class Ideas

 * Paddle class - an extension of the Rectangle class with private fields for lives and powerups. Key to the game's failure switch will be the public method getLives, which if ever 0, will switch the Scene to the game over screen.


 * Ball class - an extension of the Circle class. Because there will be multiple balls, I plan on having a private boolean isMain field and a public isMain() method so that only the real ball controls game failure.


 * Block class - another extension of the Rectangle class, this time with private fields for lives and block type. A public getType() method will be key to determine its behavior in the main program.


 * ImageView class - for aesthetic design. Because I'd want it to move with the object it belongs to, its setX and setY methods will come into play.

