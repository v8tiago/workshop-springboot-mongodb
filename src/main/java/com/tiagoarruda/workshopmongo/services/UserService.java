package com.tiagoarruda.workshopmongo.services;

import com.tiagoarruda.workshopmongo.domain.User;
import com.tiagoarruda.workshopmongo.dto.UserDTO;
import com.tiagoarruda.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tiagoarruda.workshopmongo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll()
    {
        return repo.findAll();
    }

    public User findById(String id)
    {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj)
    {
        return repo.insert(obj);
    }

    public void delete(String id)
    {
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO)
    {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }


}
