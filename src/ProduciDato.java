/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */

/**
 *
 * @author informatica
 */
public class ProduciDato extends Thread{
    
    Semaforo pieno;
    Semaforo vuoto;
    
    int tanti = 5;
    
   final int attesa = 500;
   
   public ProduciDato(Semaforo s1, Semaforo s2){
       pieno = s1;
       vuoto = s2;
   }
   
   public void run(){
       for(int k = 0; k < tanti; k++)
       {
           vuoto.P();
           ProdConsSem.buffer = (int)(Math.random()*101);
           System.out.println("Scrittore: dato scritto : "+ProdConsSem.buffer);
           pieno.V();
           try{Thread.sleep(attesa);}
           catch(Exception e){}
       }
       
       System.out.println("Scrittore: termine scrittura dati.");
   }
    
}
