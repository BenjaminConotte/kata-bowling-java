package fr.benjaminconotte.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final private List<Integer> frames = new ArrayList<>();
    public void hit(final int pins) {
        this.frames.add(pins);
    }
    public int getScore() {
        var score = 0;
        for (var i = 0 ; i < this.frames.size() ; i=i+2) {
            var firstFrame = this.frames.get(i);
            var secondFrame = this.frames.get(i+1);
            if(this.isStrike(i))
                score += firstFrame + this.frames.get(i+2) + this.frames.get(i+3);
            else if(this.isSpare(i))
                score += firstFrame + secondFrame + this.frames.get(i+2);
            else
                score += firstFrame + secondFrame;
        }
        return score;
    }
    private boolean isSpare(final int frameId) {
        return (this.frames.get(frameId)+this.frames.get(frameId+1)) == 10;
    }
    private boolean isStrike(final int frameId){
        return this.frames.get(frameId) == 10;
    }
}
