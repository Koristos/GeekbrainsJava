import java.util.Random;

public class Robot implements ObstacleOvercome {
    private String name;
    private int climbMax;
    private int swimMax;
    private int runMax;
    Robot(String name){
        Random rnd = new Random();
        this.name=name;
        this.climbMax=10+rnd.nextInt(5);
        this.swimMax=20+rnd.nextInt(10);
        this.runMax=100+rnd.nextInt(30);
    }

    @Override
    public boolean Overcome(Wall toClimb) {
        if (toClimb.GetHeight() < climbMax) {
            System.out.println("Робот "+this.name + " использовал втроенный механизм, чтобы залезть на стену высотой "+toClimb.GetHeight());
            return true;
        } else {
            System.out.println("Технические ограничения робота " + this.name + " не позволяют ему перелезть через стену высотой "+toClimb.GetHeight());
            return false;
        }
    }

    @Override
    public boolean Overcome(RunDistance toRun) {
        if (toRun.GetDistance() < runMax) {
            System.out.println("Робот "+this.name + " гремя всеми комплектующими пробежал дистанцию "+toRun.GetDistance());
            return true;
        } else {
            System.out.println("Батарейка робота " + this.name + " села раньше, чем он смог пробежать дистанцию " +toRun.GetDistance());
            return false;
        }
    }


}
