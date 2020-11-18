import java.util.Random;

public class Obstacle implements Trial {
    private int height;

    Obstacle(){
        Random rnd = new Random();
        this.height=rnd.nextInt(3)+1;
    }

    @Override
    public int GetHeight() {
        return this.height;
    }
}
