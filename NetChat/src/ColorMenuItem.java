import javax.swing.*;
import java.awt.*;

public class ColorMenuItem extends JCheckBoxMenuItem {
private Color color;
ColorMenuItem(String name, Color toChoose, boolean flag){
    super(name,flag);
    this.color=toChoose;
}

protected Color getColor(){
    return this.color;
}

    @Override
    public int hashCode() {
    int result=super.hashCode()+this.color.hashCode();
        return result;
    }
}
