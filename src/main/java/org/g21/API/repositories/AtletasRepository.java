package org.g21.API.repositories;

import org.g21.API.models.Atletas;
import org.g21.API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletasRepository extends JpaRepository<Atletas, Integer> {

    public User getUserByUsernameAndPassword(String username, String password);

    Atletas findById(int id);

}
