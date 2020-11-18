import java.util.Random;

public class Team {
    TeamMember[] dreamTeam;

    Team(int size){
        this.dreamTeam=new TeamMember[size];
        Random rnd = new Random();
        for (int i=0;i<size;i++){
            this.dreamTeam[i]=new TeamMember((rnd.nextInt(3)+1));
        }
    }

    public void PassCourse(ObstacleCourse toPass){
        for (TeamMember toGo:this.dreamTeam){
            toGo.PassTheObstacleCourse(toPass.GetObstacleCourse());
        }
    }

    public void ShowResults(){
        for (TeamMember toGo:this.dreamTeam){
            toGo.ShowLastResult();
        }
    }

    public void ShowInfo(){
        for (TeamMember toGo:this.dreamTeam){
            toGo.ShowData();
        }
    }
}
