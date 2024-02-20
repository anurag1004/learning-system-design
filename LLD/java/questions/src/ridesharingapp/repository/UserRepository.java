package ridesharingapp.repository;

import ridesharingapp.model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private static UserRepository instance;
    private final Map<String, User> userMap;
    private UserRepository(){
        this.userMap = new ConcurrentHashMap<>();
    }
    public static UserRepository getInstance(){
        if(instance==null){
            synchronized (UserRepository.class){
                if(instance==null){
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    public void saveAll(List<User> users){
        for(User user: users){
            this.save(user);
        }
    }
    public void save(User user){
        userMap.put(user.getName(), user);
    }
    public Optional<User> getUser(String name){
        if(userMap.containsKey(name)){
            return Optional.of(userMap.get(name));
        }
        return Optional.empty();
    }
    public void deleteUser(String name){
        userMap.remove(name);
    }

}
