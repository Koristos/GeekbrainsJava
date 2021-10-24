package MessageFactory;

import Message.Megafon.MegafonGreetingMessage;
import Message.Megafon.MegafonInfoMessage;
import Message.Megafon.MegafonWarningMessage;
import Message.Message;
import Message.MessageTypes;


public class MegafonMessageFactory implements MessageFactory{
    @Override
    public Message getMessage(MessageTypes messageType) {
        switch (messageType){
            case INFO:
                return new MegafonInfoMessage();
            case WARNING:
                return new MegafonWarningMessage();
            case GREETINGS:
                return new MegafonGreetingMessage();
            default:
                return null;
        }
    }
}
