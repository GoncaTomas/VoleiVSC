package org.g21.API.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atleta")
public class Atletas{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String username;
    private String password;
    private String email;
    private int idade; 
    private int telefone; 
    private String posicao;
    private double peso;
    private double altura;
    private double percentMassaMuscular;
    private double percentMassaGorda;
    private double imc;
    private double impulsao;
    private double forca;
}
