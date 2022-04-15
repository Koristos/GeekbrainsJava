import java.util.Date;

public class Main {

    public static void main(String[] args) {
        UserService service = new UserService();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Ivan");
        user1.setBirthDate(new Date());
        user1.setPhone("2222222");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Petr");
        user2.setBirthDate(new Date());
        user2.setPhone("3333333");

        service.saveUser(user1);
        service.saveUser(user2);

        User user = service.getUser(1);

        service.getUserMap().forEach((key, value) -> System.out.println(value.getName()));
    }
}
