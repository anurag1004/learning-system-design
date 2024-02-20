package ridesharingapp.service;

import ridesharingapp.model.enums.Gender;
import ridesharingapp.model.exceptions.NoSuchUserFoundException;
import ridesharingapp.model.user.User;
import ridesharingapp.model.vehicle.Vehicle;
import ridesharingapp.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    public UserService(){
        this.userRepository = UserRepository.getInstance();
    }
    public User createUser(String name, String gender, int age){
        User user = new User(name, Gender.valueOf(gender), age);
        userRepository.save(user);
        return user;
    }
    public void addUserVehicle(String name, Vehicle vehicle) throws NoSuchUserFoundException {
        User user = getUser(name);
        user.addVehicle(vehicle);
    }
    public User getUser(String name) throws NoSuchUserFoundException {
        Optional<User> userOptional = userRepository.getUser(name);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new NoSuchUserFoundException("no such user found with name: "+name);
        }
    }
}
