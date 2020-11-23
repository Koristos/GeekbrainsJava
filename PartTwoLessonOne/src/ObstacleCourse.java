public class ObstacleCourse {
    private Obstacle[] course;

    ObstacleCourse(int length){
        this.course=new Obstacle[length];
        for (int i=0;i<length;i++){
            this.course[i]= new Obstacle();
        }
    }
    public Obstacle[] GetObstacleCourse(){
        return this.course;
    }
}
