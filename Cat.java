public class Cat extends Animals {
    Cat(String name,int age, int weight){
        super(name, age, weight);
    }

    @Override
    protected int SetJumpMax() {
        int age=GetAge();
        int weight=GetWeight();
        int jumpMax=2;
        if (age>1&&age<8) jumpMax+=3;
        else if (age>8&&age<12)jumpMax+=1;
        if (weight<1||weight>15) jumpMax-=1;
        return jumpMax;
    }

    @Override
    protected int SetRunMax() {
        int age=GetAge();
        int weight=GetWeight();
        int runMax=200;
        if (age>1&&age<8) runMax+=100;
        else if (age>8&&age<12)runMax+=50;
        if (weight<1||weight>15) runMax-=100;
        return runMax;
    }

    @Override
    protected int SetSwimMax() {
        return 0;
    }

    @Override
    public boolean Swim(int distance) {
        System.out.println(GetName()+" не поплывет. Коты не умеют плавать!");
        return false;
    }
}
