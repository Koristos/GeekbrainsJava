package Message.Beeline;

import Message.Message;

public class BeelineGreetingMessage implements Message {
    @Override
    public String getText() {
        return "Вас приветствует Билайн";
    }
}
