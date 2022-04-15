package Message.Megafon;

import Message.Message;

public class MegafonWarningMessage implements Message {
    @Override
    public String getText() {
        return "Мегафон настойчиво предупреждает:";
    }
}
