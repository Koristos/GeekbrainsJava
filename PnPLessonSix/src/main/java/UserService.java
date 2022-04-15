import java.util.Map;

public class UserService {

    private final UserMapper mapper;
    private final UserIdentityMap identityMap;

    UserService (){
        this.mapper = new UserMapper();
        this.identityMap = new UserIdentityMap();
    }

    public void saveUser (User user){
        mapper.putUser(user);
    }

    public User getUser (Integer id){
        User user = identityMap.getUser(id);
        if (user == null){
            user = mapper.getUser(id);
            identityMap.putUser(user);
        }
        return user;
    }

    public Map<Integer, User> getUserMap(){
        return identityMap.getUserMap();
    }
}
