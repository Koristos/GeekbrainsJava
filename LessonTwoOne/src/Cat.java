import java.util.Random;

public class Cat implements ObstacleOvercome{
    private String name;
    private int climbMax;
    private int runMax;

        Cat(String name) {
            Random rnd = new Random();
            this.name = name;
            this.climbMax = 2 + rnd.nextInt(3);
            this.runMax = 50 + rnd.nextInt(20);
        }

        @Override
        public boolean Overcome(Wall toClimb) {
            if (toClimb.GetHeight() < climbMax) {
                System.out.println("Кот "+this.name + " перепрыгнул стену высотой " + toClimb.GetHeight());
                return true;
            } else {
                System.out.println("Кот "+this.name + " не хочет прыгать - стену высотой " + toClimb.GetHeight()+". Слишком высоко для него.");
                return false;
            }
        }

        @Override
        public boolean Overcome(RunDistance toRun) {
            if (toRun.GetDistance() < runMax) {
                System.out.println("Кот "+this.name + " легко пробежал дистанцию " + toRun.GetDistance());
                return true;
            } else {
                System.out.println("Кот " + this.name + " устал и не пробежал дистанцию " + toRun.GetDistance());
                return false;
            }
        }



}
