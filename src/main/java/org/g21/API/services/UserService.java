package org.g21.API.services;

import org.g21.API.models.User;
import org.g21.API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User verificarLogin(String username, String password) {

        return userRepository.getUserByUsernameAndPassword(username, password);
    }

    public User getUser(int idUser) {

        return userRepository.findById(idUser);
    }

    public void criarUser(User user) {

        userRepository.save(user);
    }
}
