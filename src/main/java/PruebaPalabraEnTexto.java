import cuentapalabras.*;
public class PruebaPalabraEnTexto {
    public static void main(String[] args){
        PalabraEnTexto gorra = new PalabraEnTexto("gorra");
        PalabraEnTexto bruh = new PalabraEnTexto("Gorra");
        gorra.incrementa();
        System.out.println("Palabra 1 = "+gorra);
        System.out.println("Palabra 2 = "+bruh);
        if(gorra.equals(bruh)){
            System.out.println("Las palabras son iguales");
        }
    }
}
