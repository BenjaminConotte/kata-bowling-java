package fr.benjaminconotte;


import fr.benjaminconotte.bowling.Game;
import junit.framework.TestCase;

public class BowlingTest extends TestCase {
    public void testCreateAGame(){
        var game = new Game();
        assertEquals(game.getClass(), Game.class);
    }
    public void testFailAllTry(){
        var game = new Game();
        for(var i=0 ; i < 10; i++) {
            game.hit(0);
            game.hit(0);
        }
        assertEquals(0, game.getScore());
    }
    public void testTouchOnlyOnePinEachTime(){
        var game = new Game();
        for(var i=0 ; i < 10; i++) {
            game.hit(1);
            game.hit(1);
        }
        assertEquals(20, game.getScore());
    }
    public void testComputeASpare(){
        var game = new Game();
        game.hit(5); // 5
        game.hit(5); // 5 + 5 + 1
        game.hit(1); // 5 + 5 + 1 + 1
        game.hit(1); // 5 + 5 + 1 + 1 + 1
        for(var i=0 ; i < 8 ; i++){
            game.hit(0);
            game.hit(0);
        }
        assertEquals(13, game.getScore());
    }
    public void testComputeAStrike(){
        var game = new Game();
        game.hit(10);
        game.hit(0);
        game.hit(3);
        game.hit(3);
        for(var i=0 ; i < 8 ; i++){
            game.hit(0);
            game.hit(0);
        }
        assertEquals(22, game.getScore());
    }
    public void testAddOneTurnWhenTheLastIsASpare(){
        var game = new Game();
        for(var i = 0 ; i < 9 ; i++){
            game.hit(0);
            game.hit(0);
        }
        game.hit(5); // 5
        game.hit(5); // 5 + 5 + 1
        game.hit(1); // 5 + 5 + 1 + 1
        game.hit(1); // 5 + 5 + 1 + 1 + 1
        assertEquals(13, game.getScore());
    }
    public void testAddTwoExtraTurnWhenTheLastIsAStrike(){
        var game = new Game();
        for(var i = 0 ; i < 9 ; i++){
            game.hit(0);
            game.hit(0);
        }
        game.hit(10);
        game.hit(0);
        game.hit(1);
        game.hit(1);
        game.hit(1);
        game.hit(1);
        assertEquals(16, game.getScore());
    }
}
