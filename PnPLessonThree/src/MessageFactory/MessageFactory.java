package MessageFactory;

import Message.Message;
import Message.MessageTypes;

public interface MessageFactory {
    Message getMessage (MessageTypes messageType);
}
