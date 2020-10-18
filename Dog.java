public class Dog extends Animals {


    Dog(String name,int age, int weight){
        super(name, age, weight);

    }

    @Override
    protected int SetJumpMax() {
        int age=GetAge();
        int weight=GetWeight();
        int jumpMax=1;
        if (age>3&&age<10) jumpMax+=2;
        else if (age>10&&age<15)jumpMax+=1;
        if (weight<10||weight>30) jumpMax-=1;
        return jumpMax;
    }

    @Override
    protected int SetRunMax() {
        int age=GetAge();
        int weight=GetWeight();
        int runMax=400;
        if (age>3&&age<10) runMax+=200;
        else if (age>10&&age<15)runMax+=100;
        if (weight<10||weight>30) runMax-=100;
        return runMax;
    }

    @Override
    protected int SetSwimMax() {
        int age=GetAge();
        int weight=GetWeight();
        int swimMax=30;
        if (age>3&&age<10) swimMax+=20;
        else if (age>10&&age<15)swimMax+=10;
        if (weight<10||weight>30) swimMax-=10;
        return swimMax;
    }
}
