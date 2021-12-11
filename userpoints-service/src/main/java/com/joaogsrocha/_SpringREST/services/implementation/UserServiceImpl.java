package com.joaogsrocha._SpringREST.services.implementation;

import com.joaogsrocha._SpringREST.model.user.User;
import com.joaogsrocha._SpringREST.repository.UserRepository;
import com.joaogsrocha._SpringREST.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements GenericService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User find(Long id) {
        return (User) userRepository.findById(id).get();
    }

    @Override
    public User create(User user) {
        return (User) userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
