package Message.Megafon;

import Message.Message;

public class MegafonInfoMessage implements Message {
    @Override
    public String getText() {
        return "Мегфон информирует, что";
    }
}
