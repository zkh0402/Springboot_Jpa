package com.zkh.sy3.springbootjpa.repository;

import com.zkh.sy3.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zkh
 * @date 2022/6/12 -9:58
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUserName(String userName);
    @Query(value = "select userName from User")
    public List<String> findAllUserName();

}
