package cuentapalabras;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ContadorPalabras {
    private final ArrayList<PalabraEnTexto> palabras;
    public ContadorPalabras(){
        this.palabras=new ArrayList<>();
    }
    private int esta(String n){
        boolean esta = false;
        int pos = 0;
        PalabraEnTexto aux = new PalabraEnTexto(n);
        while(pos<palabras.size() && !esta){
            if(aux.equals(palabras.get(pos))){
                esta=true;
            }else{
                pos++;
            }
        }
        if(!esta){
            pos=-1;
        }
        return pos;
    }
    protected void incluye(String pal){
        if(!pal.isEmpty()){
            int aux = esta(pal);
            if(aux!=-1){
                palabras.get(aux).incrementa();
            }else{
                palabras.add(new PalabraEnTexto(pal));
            }
        }
    }
    private void incluyeTodas(String monkey, String del){
        String[] data = monkey.split(del);
        for (String datum : data) {
            incluye(datum);
        }
    }
    public void incluyeTodas(String[] texto, String del){
        for(String aux : texto){
            incluyeTodas(aux, del);
        }
    }
    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        try (BufferedReader bruh = new BufferedReader(new FileReader(nomFich))){
            String linea;
            while((linea = bruh.readLine())!=null){
                incluyeTodas(linea, del);
            }
        }catch(IOException exception){
            throw new IOException("Couldn't read the file specified");
        }
    }
    public PalabraEnTexto encuentra(String n){
        int pos = esta(n);
        PalabraEnTexto aux;
        if(pos!=-1){
            aux = palabras.get(pos);
        }else{
            throw new NoSuchElementException("No existe la palabra "+n);
        }
        return aux;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder object
        for (PalabraEnTexto palabra : palabras) { // Iterate over each PalabraEnTexto object in the list 'palabras'
            sb.append(palabra).append(" - "); // Append the string representation of the PalabraEnTexto object followed by a hyphen and space to the StringBuilder
        }
        if (sb.length() > 2) { // Check if the StringBuilder's length is greater than 2 characters
            sb.setLength(sb.length() - 2); // If so, remove the last two characters (hyphen and space) from the StringBuilder
        }
        return "[" + sb + "]"; // Return the StringBuilder content enclosed in square brackets as a String
    }
    public void presentaPalabras(String fichero)throws FileNotFoundException{
        try (PrintWriter pw = new PrintWriter(fichero)){
            for(PalabraEnTexto palabraEnTexto : palabras){
                pw.println(palabraEnTexto);
            }
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("The file specified was not found");
        }
    }
    public void presentaPalabras(PrintWriter pw){
        for(PalabraEnTexto palabraEnTexto : palabras){
            pw.println(palabraEnTexto);
        }
    }

}
