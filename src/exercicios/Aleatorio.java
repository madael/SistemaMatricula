/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.Random;

/**
 *
 * @author Daniel Lucarelli
 */
public class Aleatorio {
    
    public static void jogarDado(String jogador1,String jogador2){
        int[] vet = new int[2];
        Random r = new Random(); 
        vet[1] = r.nextInt(6)+1;
        vet[0] = r.nextInt(6)+1;
        /*System.out.println(jogador1+" valor: "+vet[0]);
        System.out.println(jogador2+" valor: "+vet[1]);*/
        if(vet[0]>vet[1])
            System.out.println(jogador1+" ganhou o jogo");
        else if(vet[0]<vet[1])
            System.out.println(jogador2+" ganhou o jogo");
        else
            jogarDado(jogador1, jogador2);
    }
    
}
