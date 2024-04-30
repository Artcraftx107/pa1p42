package cuentapalabras;

import java.util.ArrayList;

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

    }
    public PalabraEnTexto encuentra(String n){

    }
}
