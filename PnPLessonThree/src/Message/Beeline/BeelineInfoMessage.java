package Message.Beeline;

import Message.Message;

public class BeelineInfoMessage implements Message {
    @Override
    public String getText() {
        return "Билайн информирует, что";
    }
}
