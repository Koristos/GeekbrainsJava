package Message.Mts;

import Message.Message;

public class MtsInfoMessage implements Message {
    @Override
    public String getText() {
        return "МТС информирует, что";
    }
}
