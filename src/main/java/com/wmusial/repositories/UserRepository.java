package com.wmusial.repositories;

import com.wmusial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String search); //to jest automatyczna metoda Spring-data

    @Query("SELECT u FROM User u WHERE u.firstName LIKE :search OR u.lastName LIKE :search OR u.email LIKE :search") // SELECT u FROM User u odwołuje się do obiektu User, jezyk podobny do SQL, który jest pozniej tlumaczony na sql- podobne do SELECT * FROM user
    List<User> searchbyCustom(@Param("search") String search);
}
