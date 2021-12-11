package com.joaogsrocha._SpringREST.services.implementation;


import com.joaogsrocha._SpringREST.model.userpoints.UserPoints;
import com.joaogsrocha._SpringREST.repository.UserPointsRepository;
import com.joaogsrocha._SpringREST.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userpointsService")
public class UserPointsServiceImpl implements GenericService<UserPoints> {

    @Autowired
    private UserPointsRepository userPointsRepository;

    @Override
    public Iterable<UserPoints> findAll() {
        return userPointsRepository.findAll();
    }

    @Override
    public UserPoints find(Long id) {
        return (UserPoints) userPointsRepository.findById(id).get();
    }

    @Override
    public UserPoints create(UserPoints userPoints) {
        return (UserPoints) userPointsRepository.save(userPoints);
    }

    @Override
    public void update(UserPoints userPoints) {
        userPointsRepository.save(userPoints);
    }

    @Override
    public void delete(String id) {
        userPointsRepository.delete(id);
    }
}
