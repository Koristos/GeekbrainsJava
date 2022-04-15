package Message.Megafon;

import Message.Message;

public class MegafonGreetingMessage implements Message {
    @Override
    public String getText() {
        return "Вас приветствует Мегафон";
    }
}
