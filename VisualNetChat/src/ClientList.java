import java.util.HashSet;
import java.util.Objects;

    public class ClientList {

        private HashSet<User> accountBase;

        ClientList(){
            accountBase = new HashSet<User>();
            this.accountBase.add(new User("user1","111"));
            this.accountBase.add(new User("user2","111"));
            this.accountBase.add(new User("user3","111"));

        }

        public boolean login(String login, String password){
            User userToCheck = new User(login,password);
            if(this.accountBase.contains(userToCheck)) return true;
            else return false;
        }

        private class User {
            private String login;
            private String password;

            User(String login,String password){
                this.login=login;
                this.password=password;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return Objects.equals(login, user.login) &&
                        Objects.equals(password, user.password);
            }

            @Override
            public int hashCode() {
                return Objects.hash(login, password);
            }
        }
    }



