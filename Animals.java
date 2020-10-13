public abstract class Animals {
    private String name;
    private int age;
    private int weight;
    private int jumpMax;
    private int swimMax;
    private int runMax;

    Animals(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
        jumpMax=SetJumpMax();
        swimMax=SetSwimMax();
        runMax=SetRunMax ();
    }

    public boolean Run (int runDistance){
        boolean checkRun= CheckAction(runDistance,runMax,"пробежать");
        return checkRun;
    }

    public boolean Jump (int height){
        boolean checkRun= CheckAction(height,jumpMax,"перепрыгнуть");
        return checkRun;

    }


    public boolean Swim (int swimDistance){
        boolean checkRun= CheckAction(swimDistance,swimMax,"проплыть");
        return checkRun;

    }

    private boolean CheckAction(int dist, int maxDist, String action){
        if (dist<maxDist&&dist>0){
            System.out.println(this.name + " может "+ action +" " + dist + " метров.");
            return true;
        }else {
            System.out.println(this.name + " не может "+ action +" " + dist + " метров.");
        } return false;

    }
    public String GetName(){
        return this.name;
    }
    public int GetAge(){
        return this.age;
    }
    public int GetWeight(){
        return this.weight;
    }


    protected abstract int SetJumpMax();
    protected abstract int SetRunMax();
    protected abstract int SetSwimMax();




}
