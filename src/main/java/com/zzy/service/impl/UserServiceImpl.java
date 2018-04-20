package com.zzy.service.impl;

import com.zzy.domain.User;
import com.zzy.repository.UserJpaRepository;
import com.zzy.repository.UserRepository;
import com.zzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name){
        List<User> userList1 = userRepository.findByName1(name);
        List<User> userList2 = userRepository.findByName2(name);
        List<User> userList3 = userRepository.findByNameAndAddress(name, "3");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(User book){
        userJpaRepository.save(book);
    }

    @Cacheable("users")
    public User findOne(long id){
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id){
        userJpaRepository.delete(id);
    }
}