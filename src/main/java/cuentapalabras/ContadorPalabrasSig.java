package cuentapalabras;

import java.util.ArrayList;

public class ContadorPalabrasSig extends ContadorPalabras{
    private ArrayList<String> noSignificativas;
    public ContadorPalabrasSig(){
        super();
    }
    public void leeArrayNoSig(String[] cs2){
        this.noSignificativas=new ArrayList<>();
        
    }
}
