public class LessonSix {
    public static void main(String[] args) {

        Animals[] animalList = new Animals[4];
        animalList[0]=new Cat("Барсик",16,15);
        animalList[1]=new Cat("Мурка",5,6);
        animalList[2]=new Dog("Тузик",0,1);
        animalList[3]=new Dog("Барбос",8,20);

        for (Animals a:animalList){
            a.Jump(1);
            a.Run(200);
            a.Swim(25);
        }



    }
}
