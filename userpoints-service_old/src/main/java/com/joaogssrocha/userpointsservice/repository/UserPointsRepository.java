package com.joaogssrocha.userpointsservice.repository;

import com.joaogssrocha.userpointsservice.model.UserPoints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository("userpointsRepository")
public interface UserPointsRepository<T> extends JpaRepository<UserPoints, Long> {

    Page<UserPoints> findById(@RequestParam("id") Long id, Pageable pageable);

}
