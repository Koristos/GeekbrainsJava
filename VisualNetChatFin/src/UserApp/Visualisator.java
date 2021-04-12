package UserApp;

import java.util.function.Consumer;

public class Visualisator {

Consumer <String> sendMessage;
ChatFrame frame;

Visualisator (Consumer send){
    this.sendMessage=send;
    frame=new ChatFrame(this.sendMessage);

}

public void printMessage(String text){
    String message;
    if (text.startsWith("cmd authorisation ")){
        message=text.replaceAll("cmd authorisation ","");
        new Thread(()->{frame.authorisationRequest(message);}).start();
    }else if (text.startsWith("authorisationmessage ")){
        message=text.replaceAll("authorisationmessage ","");
        frame.authorisationMessage(message);
    }else frame.center.addMessage("\n"+text);
}

}
