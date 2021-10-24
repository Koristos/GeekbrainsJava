package Message.Mts;

import Message.Message;

public class MtsGreetingMessage implements Message {
    @Override
    public String getText() {
        return "Вас приветствует МТС";
    }
}
