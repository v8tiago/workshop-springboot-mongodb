package com.tiagoarruda.workshopmongo.services;

import com.tiagoarruda.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tiagoarruda.workshopmongo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll()
    {
        return repo.findAll();
    }
}
