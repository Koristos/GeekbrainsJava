import Message.Message;
import MessageFactory.BeelineMessageFactory;
import MessageFactory.MegafonMessageFactory;
import MessageFactory.MtsMessageFactory;
import Message.MessageTypes;

public class MessageFabric {
    enum Companies {
        BEELINE,
        MTS,
        MEGAFON
    }


    public static Message getMessage (Companies company, MessageTypes messageType){
        Message message;
        switch (company){
            case MTS:
               message = new MtsMessageFactory().getMessage(messageType);
                break;
            case BEELINE:
                message = new BeelineMessageFactory().getMessage(messageType);
                break;
            case MEGAFON:
                message = new MegafonMessageFactory().getMessage(messageType);
                break;
            default:
                message=null;
        }
        return message;
    }
}
