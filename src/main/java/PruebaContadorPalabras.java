import cuentapalabras.*;
public class PruebaContadorPalabras {
    private static final String[] datos={
            "Esta es la primera frase del ejemplo",
            "y esta es la segunda frase"
    };
    public static void main(String[] args){
        ContadorPalabras contadorPalabras = new ContadorPalabras();
        contadorPalabras.incluyeTodas(datos, " ");
        System.out.println(contadorPalabras);
    }
}
