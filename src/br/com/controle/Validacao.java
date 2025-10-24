/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas Araujo
 */
public class Validacao {
    char[] senha;
    public Validacao(char[] senha){
        this.senha = senha;
        
    }
    public String validarpassword(){
       //Quais restrições nosso userNome tem?;
       //Quais restrições nossa senha tem?; 8 caracteres, Carecter Especial, Letra Maiuscula, nome e sobrenome não são permitidos
        String senhaString = new String(senha);
        Pattern letter = Pattern.compile("[a-z A-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");            
        Matcher hasLetter = letter.matcher(senhaString);
        Matcher hasDigit = digit.matcher(senhaString);
        Matcher hasSpecial = special.matcher(senhaString);
        
        if (hasLetter.find()&& hasSpecial.find() && hasDigit.find()){
            return "Senha possível";
            
        } else{
            return "Senha invalida, a senha deve conter pelo menos uma letra maiuscula"
            + ", deve conter mais de 8 digitos, não pode conter o nome do usuário,"
            + "deve conter pelo menos um caracter especial e deve conter pelo menos um número ";
        }

    }
}
