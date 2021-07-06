package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository <User, Long>{
    @Override
    User save(User user);

    List<User> findAll();
}
