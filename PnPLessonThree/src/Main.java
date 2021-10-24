import Message.MessageTypes;

public class Main {
    public static void main(String[] args) {
        System.out.println(MessageFabric.getMessage(MessageFabric.Companies.MEGAFON, MessageTypes.GREETINGS).getText());
    }
}
