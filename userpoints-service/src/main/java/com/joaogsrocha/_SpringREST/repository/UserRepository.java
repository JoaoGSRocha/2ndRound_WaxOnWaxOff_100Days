package com.joaogsrocha._SpringREST.repository;

import com.joaogsrocha._SpringREST.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository("userRepository")
public interface UserRepository<T> extends JpaRepository<User, Long> {

    Page<User> findByScreenNameContainingIgnoreCase(String screenName, Pageable pageable);

    Page<User> findById(@RequestParam("id") Long id, Pageable pageable);

}
