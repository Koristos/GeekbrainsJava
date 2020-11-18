import java.util.Random;

public class TeamMember implements Copmetition {
    private String name;
    private String qualify;
    private int energy;
    private int maxHeight;
    private int obstPassed;
    private String resultDescription="Ни разу не проходил полосу препятствий.";
    private static String [] nameCollection= new String[]{"Евгений", "Тимофей", "Антон", "Александр", "Егор", "Владимир", "Ипполит", "Игорь", "Абдула", "Михаил", "Аристотель", "Анисий", "Петр"};

    TeamMember (int type){
        Random rnd = new Random();
        this.name=nameCollection[rnd.nextInt(nameCollection.length-1)];
        this.energy=rnd.nextInt(5)+8;
        this.maxHeight=rnd.nextInt(2)+1;
        switch (type){
            case 1: this.qualify= "новичок";
                break;
            case 2: this.qualify= "спортсмен";
                this.maxHeight+=1;
                this.energy+=5;
                break;
            case 3: this.qualify= "мастер спорта";
                this.maxHeight+=2;
                this.energy+=8;
                break;
        }

    }

    @Override
    public void PassTheObstacleCourse(Obstacle[] toPass) {
        int vit = this.energy;
        this.resultDescription="успешно прошел всю полосу препятствий.";
        for (int i=0; i<toPass.length;i++){
            this.obstPassed=i;
            if (toPass[i].GetHeight()>this.maxHeight){
                this.resultDescription="не смог преодолеть препятствие - слишком высокое.";
                break;
            }else if (vit-toPass[i].GetHeight()<0){
                this.resultDescription="оказался недостаточно вынослив, чтобы преодолеть всю полосу препятствий.";
                break;
            }
            vit-=toPass[i].GetHeight();
            this.obstPassed+=1;
        }

    }

    @Override
    public void ShowLastResult() {
        System.out.println("\n"+this.qualify + " " + this.name + " преодолел " + this.obstPassed + " препятствий. \nОн "+this.resultDescription);

    }

    @Override
    public void ShowData() {
        System.out.println(this.name + " - " +this.qualify);
    }
}
