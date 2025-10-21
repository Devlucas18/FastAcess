/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controle;

import com.profesorfalken.jpowershell.PowerShell;
import java.util.Arrays;

public class CriaAcesso {
    String nomeCompleto;
    String primeiroNome;
    String ultimoNome;
    String userNome;
    char[] senha;
    
    public CriaAcesso(String nomeCompleto, String primeiroNome, String ultimoNome, String userNome, char[] senha){
        this.nomeCompleto = nomeCompleto;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.userNome = userNome;
        this.senha = senha;
    } 
    public String Criar(){
        String senhaString = new String(senha);
        Arrays.fill(senha, ' ');
        
        String command = "powershell.exe -File C:\\Scripts\\ScriptCriacaodeAcesso.ps1 -FullName \"" + nomeCompleto + "\" -FirstName \""
        + primeiroNome + "\" -LastName \"" + ultimoNome + "\" -LogonName \"" + userNome + "\" -Password \"" + senhaString + "\"";
        
        
        System.out.println(command);  
        return PowerShell.executeSingleCommand(command).getCommandOutput();

    }
}
