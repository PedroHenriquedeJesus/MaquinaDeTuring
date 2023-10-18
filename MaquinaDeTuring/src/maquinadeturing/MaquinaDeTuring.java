/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maquinadeturing;

import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class MaquinaDeTuring {
    int cont = 0;
    char fita [];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaquinaDeTuring mt= new MaquinaDeTuring();
        Scanner sc = new Scanner(System.in);
        String palavra = "";
        System.out.println("Insira a palavra:");
        palavra = sc.nextLine();
        mt.iniciar(palavra);
        
    }
    public void iniciar(String sentenca){
        fita = sentenca.toCharArray();
        q0();
    }
    public void q0(){
        if(cont < fita.length){
            if(fita[cont] == 'T'){
               fita[cont] = 'T';
               cont++;
                q4();
            }
            else if (fita[cont] == 'B'){
                fita[cont] = 'B';
                cont++;
                q3();
            }
            else if (fita[cont] == 'a'){
                fita[cont] = 'A';
                cont++;
                q1();
            }
            else{
                qerro();
            }
            
        }
        else{
            qerro();
        }
    }
    public void q1(){
        if(cont < fita.length){
            if(fita[cont] == 'a'){
               fita[cont] = 'a';
               cont++;
                q1();
            }
            else if (fita[cont] == 'B'){
                fita[cont] = 'B';
                cont++;
                q1();
            }
            else if (fita[cont] == 'b'){
                fita[cont] = 'B';
                cont--;
                q2();
            }
            else{
                qerro();
            }
        }
        else{
            qerro();
        }
    }
    public void q2(){
        if(cont < fita.length){
            if(fita[cont] == 'a'){
               fita[cont] = 'a';
               cont--;
                q2();
            }
            else if (fita[cont] == 'B'){
                fita[cont] = 'B';
                cont--;
                q2();
            }
            else if (fita[cont] == 'A'){
                fita[cont] = 'A';
                cont++;
                q0();
            }
            else{
                qerro();
            }
        }
        else{
            qerro();
        }
    }
    public void q3(){
        if(cont < fita.length){
            if (fita[cont] == 'B'){
                fita[cont] = 'B';
                cont++;
                q3();
            }
            else if (fita[cont] == 'T'){
                fita[cont] = 'T';
                cont++;
                q4();
            }
            else{
                qerro();
            }
        }
        else{
            qerro();
        }
    }
    public void q4(){
        String palavra = "";
        for(int i = 0; i < (fita.length - 1); i++){
            palavra = palavra + fita[i];
        }
        System.out.println("Palavra aceita! : " + palavra);
    }
    public void qerro(){
        String palavra = "";
        for(int i = 0; i < fita.length; i++){
            palavra = palavra + fita[i];
        }
        System.err.println("Palavra não aceita");
    }
}
