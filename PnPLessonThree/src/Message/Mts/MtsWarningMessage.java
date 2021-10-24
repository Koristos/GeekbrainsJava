package Message.Mts;

import Message.Message;

public class MtsWarningMessage implements Message {
    @Override
    public String getText() {
        return "МТС настойчиво предупреждает:";
    }
}
