package asdd;

import java.util.Random;

public class Asdd {

    public static void main(String[] args) {
       Persona persona1 = new Persona("KEVIN", 26, 0, "masculino", 115, 1.79);

        System.out.println(persona1);
        System.out.println("\n");

        persona1.calcularIMC(persona1.getPeso(), persona1.getAltura());
        persona1.esMayorDeEdad(persona1.getEdad());        
        persona1.validarSexo(persona1.getSexo()); 
        persona1.setDNI(persona1.generaNumeroAleatorio());    
        System.out.println("----------");
        persona1.setDNI(persona1.generaDNI());    
        System.out.println(persona1.getDNI());
       
        System.out.println(persona1);
       
        
         
      


    }

   
}