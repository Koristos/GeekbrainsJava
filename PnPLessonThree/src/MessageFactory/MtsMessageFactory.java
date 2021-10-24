package MessageFactory;

import Message.Message;
import Message.MessageTypes;
import Message.Mts.MtsGreetingMessage;
import Message.Mts.MtsInfoMessage;
import Message.Mts.MtsWarningMessage;

public class MtsMessageFactory implements MessageFactory{
    @Override
    public Message getMessage(MessageTypes messageType) {
        switch (messageType){
            case INFO:
                return new MtsInfoMessage();
            case WARNING:
                return new MtsWarningMessage();
            case GREETINGS:
                return new MtsGreetingMessage();
            default:
                return null;
        }
    }
}
