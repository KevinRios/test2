package asdd;

import java.util.Random;

public class Persona {

    private String nombre;
    private int edad;
    private int DNI;
    private String sexo;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, int DNI, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona() {
    }

    //calculara si la persona esta en su peso ideal imc= peso/(altura*altura);
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

    public void calcularIMC(double peso, double altura) {

        double IMC = 0;
        IMC = peso / (altura * altura);

        System.out.println("REFERENCIAS DE INDICE DE MASA MUSCULAR: ");
        System.out.println("INDICE DE MASA MUSCULAR DE : 18 A 20    : BAJO PESO. ");
        System.out.println("INDICE DE MASA MUSCULAR DE : 20 A 25    : PESO IDEAL.");
        System.out.println("INDICE DE MASA MUSCULAR DE : 25 A 30    : SOBRE PESO.");
        System.out.println("INDICE DE MASA MUSCULAR DE : MAYOR A 30 : OBESIDAD.");
        System.out.println("\n");

        if ((IMC <= 18) && (IMC <= 20)) {
            System.out.println("SU MASA CORPORAL ES : " + IMC);
            System.out.println("UD ESTA CON BAJO PESO. CONSULTE A UN ESPECALISTA.");
        }
        if ((IMC > 20) && (IMC <= 25)) {
            System.out.println("SU MASA CORPORAL ES : " + IMC);
            System.out.println("UD ESTA EN SU PESO IDEAL.CONTINUE CON SU ACTIVIDAD NORMAL.");
        }
        if ((IMC > 25) && (IMC < 30)) {
            System.out.println("SU MASA CORPORAL ES : " + IMC);
            System.out.println("UD ESTA  CON SOBRE PESO. SI SE DEJA ESTAR CORRE RIESGO SU SALUD, CONSULTE A UN ESPECIALISTA.");

        }

        if (IMC >= 30) {
            System.out.println("SU MASA CORPORAL ES : " + IMC);
            System.out.println("UD TIENE OBESIDAD. NUNCA  ES TARDE PARA CAMBIAR SU RUTINA. VEA HOY A UN ESPECIALISTA.");

        }

    }

    //indica si es mayor de edad, devuelve un booleano.
    public boolean esMayorDeEdad(int edad) {
        if (edad >= 18) {
            System.out.println("ES MAYOR DE EDAD");
            return true;
        } else {
            System.out.println("ES MENOR DE EDAD ");
            return false;
        }
    }

    public boolean validarSexo(String sexoPersona) {

        sexoPersona = sexoPersona.toUpperCase();

        if (sexoPersona.equals("MASCULINO")) {
            System.out.println("sexo ok");
            return true;
        } else {
            System.out.println("sexo error");
            return false;
        }

    }
    
     public int generaNumeroAleatorio() {
        int numero = (int) (Math.random() * 99999999) + 1;
        return numero;
    }
     
      public int generaDNI() {
         Random rnd = new Random();
         int dni =  rnd.nextInt() * 57000000 + 0;
        return dni;   
    }


}// END CLASS
