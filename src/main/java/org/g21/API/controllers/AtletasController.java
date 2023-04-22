package org.g21.API.controllers;

import org.g21.API.models.Atletas;
import org.g21.API.services.AtletasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import java.util.List;

@Controller
public class AtletasController {

    @Autowired
    AtletasService atletasService;

    @GetMapping("/atletas")
    public String listarAtletas(Model model) {
        //List<Atletas> atletas = atletasService.listarAtletas();
        //model.addAttribute("atletas", atletas);
  
        return "atletas";
    }

    

    @GetMapping("/atletas/criaratleta")
    public String criacaoAtleta(Model model) {
        return "criaratleta";
    }

    @PostMapping("/atletas/criaratleta")
    public String criarAtleta(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("idade") int idade,
                               @RequestParam("telefone") int telefone,
                               @RequestParam("posicao") String posicao,
                               @RequestParam("peso") double peso,
                               @RequestParam("altura") double altura,
                               @RequestParam("percentMassaMuscular") double percentMassaMuscular,
                               @RequestParam("percentMassaGorda") double percentMassaGorda,
                               @RequestParam("imc") double imc,
                               @RequestParam("impulsao") double impulsao,
                               @RequestParam("forca") double forca,
                               Model model) {

        Atletas novoAtleta = new Atletas();
        novoAtleta.setUsername(username);
        novoAtleta.setPassword(password);
        novoAtleta.setEmail(email);
        novoAtleta.setIdade(idade);
        novoAtleta.setTelefone(telefone);
        novoAtleta.setPosicao(posicao);
        novoAtleta.setPeso(peso);
        novoAtleta.setAltura(altura);
        novoAtleta.setPercentMassaMuscular(percentMassaMuscular);
        novoAtleta.setPercentMassaGorda(percentMassaGorda);
        novoAtleta.setImc(imc);
        novoAtleta.setImpulsao(impulsao);
        novoAtleta.setForca(forca);

        AtletasService.criarAtleta(novoAtleta);
        model.addAttribute("atleta", novoAtleta);

        //  return "perfilatleta";  
      return "login";
    }

}
