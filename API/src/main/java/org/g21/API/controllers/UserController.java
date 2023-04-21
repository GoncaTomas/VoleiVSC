package org.g21.API.controllers;

import org.g21.API.models.User;
import org.g21.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {

        return "login";
    }

    @PostMapping("/login")
    public String verificarLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        User user = userService.verificarLogin(username, password);

        if(user != null) {

            model.addAttribute("user", user);

            return "home";
        }

        return "login";
    }

    @GetMapping("/perfil")
    public String verPerfil(@RequestParam("idUser") Integer idUser, Model model) {

        User user = userService.getUser(idUser);

        model.addAttribute("user", user);

        return "perfil";
    }

    @GetMapping("/criarUser")
    public String criarUser(@RequestParam("idUser") Integer idUser, Model model) {

        User user = userService.getUser(idUser);

        model.addAttribute("user", user);

        return "criarUser";
    }

    @PostMapping("/criarUser")
    public String criarUser(@RequestParam("idUser") Integer idUser, @RequestParam("username") String username,
                            @RequestParam("password") String password, @RequestParam("email") String email,
                            @RequestParam("idade") int idade, Model model) {

        User user = userService.getUser(idUser);

        User user1 = User.builder().username(username).password(password).email(email).idade(idade).build();

        userService.criarUser(user1);

        model.addAttribute("user", user);

        return "home";
    }
}
