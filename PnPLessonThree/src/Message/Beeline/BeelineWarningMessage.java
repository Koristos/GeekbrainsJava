package Message.Beeline;

import Message.Message;

public class BeelineWarningMessage implements Message {
    @Override
    public String getText() {
        return "Билайн настойчиво предупреждает:";
    }
}
