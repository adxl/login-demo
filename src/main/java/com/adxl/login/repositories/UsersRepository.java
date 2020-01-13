package com.adxl.login.repositories;

import com.adxl.login.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<User,String>
{
    @Override
    Optional<User> findById(String s);
}
