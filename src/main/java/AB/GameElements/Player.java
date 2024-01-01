package AB.GameElements;

public class Player {
    private int score = 0;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(){
        this.score += 1;
    }
}
