import java.util.Objects;

public class Vertex {
    private String name;
    private int position;

    Vertex (String name){
        this.name=name;
        this.position=0;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass()== obj.getClass()) {
            return this.hashCode() == obj.hashCode();
        }
        return false;
    }
}
