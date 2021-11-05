import java.util.HashMap;
import java.util.Map;

public class UserIdentityMap {
    private Map<Integer, User> userMap;

    UserIdentityMap(){
        this.userMap = new HashMap<>();
    }

    public User getUser (Integer id){
        if (userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    public void putUser (User user){
        userMap.put(user.getId(), user);
    }

    public Map<Integer, User> getUserMap(){
        return this.userMap;
    }
}
