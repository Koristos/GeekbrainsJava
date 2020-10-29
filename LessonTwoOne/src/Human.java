import java.util.Random;

public class Human implements ObstacleOvercome {
    private String name;
    private int climbMax;
    private int swimMax;
    private int runMax;
    Human(String name){
        Random rnd = new Random();
        this.name=name;
        this.climbMax=20+rnd.nextInt(10);
        this.swimMax=50+rnd.nextInt(20);
        this.runMax=80+rnd.nextInt(20);
    }

    @Override
    public boolean Overcome(Wall toClimb) {
        if (toClimb.GetHeight() < climbMax) {
            System.out.println("Человек "+this.name + " ловко залез на стену высотой "+toClimb.GetHeight());
            return true;
        } else {
            System.out.println("Человек " + this.name + " не может залезть на стену высотой "+toClimb.GetHeight());
            return false;
        }
    }

    @Override
    public boolean Overcome(RunDistance toRun) {
        if (toRun.GetDistance() < runMax) {
            System.out.println("Человек "+this.name + " быстро и уверенно пробежал дистанцию "+toRun.GetDistance());
            return true;
        } else {
            System.out.println("Человек " + this.name + " выдoхся раньше, чем смог пробежать дистанцию " +toRun.GetDistance());
            return false;
        }
    }

}
