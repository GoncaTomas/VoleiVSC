package org.g21.API.services;

import java.util.List;

import org.g21.API.models.Atletas;
import org.g21.API.models.User;
import org.g21.API.repositories.AtletasRepository;
import org.g21.API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import jakarta.persistence.Id;

@Service
public class AtletasService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    static
    AtletasRepository atletasRepository;

    public Atletas getAtletas(Integer id) {
        return atletasRepository.findById(id).orElse(null);
    }

    public List<Atletas> getListaAtletas() {
        List<Atletas> listaAtletas = atletasRepository.findAll();
        return listaAtletas;
    }
    
    public List<Atletas> listarAtletas() {
        List<Atletas> listaAtletas = atletasRepository.findAll(); 
        return listaAtletas;
    }
    
    public static void criarAtleta(Atletas novoAtleta) {
        atletasRepository.save(novoAtleta);
    }

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

