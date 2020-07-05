package UserInfo;

import UserPackage.User;

import java.util.HashSet;

public class UserDAO {
    private HashSet<User> users;

    public UserDAO(){
        users = new HashSet<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean containsUserName(String userName){
        for(User usr : users){
            if(usr.getUsername().equals(userName))
                return true;
        }
        return false;
    }
    public boolean successfulLogin(User user){
        for(User usr : users){
            if(usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }
    public boolean containsUser(User user){
        return users.contains(user);
    }

}
