package cuentapalabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ContadorPalabras {
    private ArrayList<PalabraEnTexto> palabras;
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
        for(int i = 0; i<data.length; i++){
            incluye(data[i]);
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
            throw new NoSuchElementException("La palabra indicada no esta en la lista de palabras");
        }
        return aux;
    }
    
}
