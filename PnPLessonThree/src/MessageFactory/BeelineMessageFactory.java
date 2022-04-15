package MessageFactory;

import Message.Beeline.BeelineGreetingMessage;
import Message.Beeline.BeelineInfoMessage;
import Message.Beeline.BeelineWarningMessage;
import Message.Message;
import Message.MessageTypes;


public class BeelineMessageFactory implements MessageFactory{
    @Override
    public Message getMessage(MessageTypes messageType) {
        switch (messageType){
            case INFO:
                return new BeelineInfoMessage();
            case WARNING:
                return new BeelineWarningMessage();
            case GREETINGS:
                return new BeelineGreetingMessage();
            default:
                return null;
        }
    }
}
