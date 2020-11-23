
public class PartTwoLessonOne {
    public static void main (String[] args){

        Team myTeam = new Team(4);
        ObstacleCourse myCourse = new ObstacleCourse(7);

        myTeam.ShowInfo();
        myTeam.PassCourse(myCourse);
        myTeam.ShowResults();


    }
}
