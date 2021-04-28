package bowling.domain;

import java.util.Objects;

public class FrameScore {
    public static final int NO_TRY = 0;
    public static final int ONE_TRY = 1;
    public static final int TWO_TRIES = 2;
    public static final FrameScore UNSCORED = new FrameScore(-1,-1);

    private final int score;
    private final int triesLeft;

    private FrameScore(int score, int triesLeft) {
        this.score = score;
        this.triesLeft = triesLeft;
    }

    public static FrameScore of(int score, int triesLeft) {
        return new FrameScore(score, triesLeft);
    }

    public FrameScore scoreAddedBonus(int score, int triesLeft) {
        return new FrameScore(this.score + score, triesLeft);
    }

    public boolean hasNoTryLeft() {
        return triesLeft == NO_TRY;
    }

    public boolean hasOneTryLeft() {
        return triesLeft == ONE_TRY;
    }

    public boolean hasTwoTriesLeft() {
        return triesLeft == TWO_TRIES;
    }

    public int Score() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrameScore)) return false;
        FrameScore frameScore = (FrameScore) o;
        return score == frameScore.score &&
                triesLeft == frameScore.triesLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, triesLeft);
    }
}
