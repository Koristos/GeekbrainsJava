public class LessonTwoOne {
    public static void main(String[] args) {
       Obstacle[] myObstacleLine=new Obstacle[]{new Wall(2),new RunDistance(22), new Wall(10),
               new RunDistance(50), new Wall(16), new RunDistance(100)};

       ObstacleOvercome[] myCompetitors=new ObstacleOvercome[]{new Cat("Барсик"), new Human("Иван"),
               new Robot("ER-120"),new Cat("Мурзик"),new Human("Владимир"), new Robot("T-800")};

       for(int a=0;a<myCompetitors.length;a++){
           for(int b=0;b<myObstacleLine.length;b++){
               boolean obstDone=true;
               if (myObstacleLine[b] instanceof Wall) obstDone=myCompetitors[a].Overcome((Wall) myObstacleLine[b]);
               if (myObstacleLine[b] instanceof RunDistance) obstDone=myCompetitors[a].Overcome((RunDistance) myObstacleLine[b]);
               if(obstDone==false){
                   System.out.println("Прохождение дистанции прервано \n\n");
                   break;
               }
           }
       }
    }
}
