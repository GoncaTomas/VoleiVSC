package org.g21.API.controllers;

import org.g21.API.models.User;
import org.g21.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JogoController {

    @Autowired
    UserService userService;

    @GetMapping("/jogos")
    public String verJogos(@RequestParam("idUser") Integer idUser, Model model) {

        User user = userService.getUser(idUser);

        model.addAttribute("user", user);

        return "jogos";
    }
}
