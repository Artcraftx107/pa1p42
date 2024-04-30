package cuentapalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContadorPalabrasSig extends ContadorPalabras{
    private ArrayList<String> noSignificativas;
    public ContadorPalabrasSig(){
        super();
        this.noSignificativas=new ArrayList<>();
    }
    public void leeArrayNoSig(String[] cs2){
        this.noSignificativas=new ArrayList<>();
        for(int i = 0; i< cs2.length; i++){
            if(!cs2[i].isEmpty()){
                noSignificativas.add(cs2[i].toUpperCase());
            }
        }
    }
    public void leeFicheroNoSig(String filNom, String del) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filNom))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                anyadePalabrasNoSignificativas(linea, del);
            }
        }

    }
    private void anyadePalabrasNoSignificativas(String linea, String del) {
        String[] data = linea.split(del);
        for(int i = 0; i<data.length; i++){
            if(!data[i].isEmpty()){
                incluye(data[i]);
            }
        }
    }

    @Override
    protected void incluye(String pal) {
        if (!pal.isEmpty() && estaNoSig(pal) == -1) {
            super.incluye(pal);
        }
    }

    public int estaNoSig(String pal){
        int bruh = 0;
        boolean found = false;
        while(bruh < noSignificativas.size() && !found){
            if(noSignificativas.get(bruh).equalsIgnoreCase(pal)){
                found = true;
            }else{
                bruh++;
            }
        }
        if(!found){
            bruh = -1;
        }
        return bruh;
    }

}
