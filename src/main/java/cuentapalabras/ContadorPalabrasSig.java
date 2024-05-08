package cuentapalabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContadorPalabrasSig extends ContadorPalabras{
    private ArrayList<String> noSignificativas;

    /**
     * Using the constructor written in ContadorPalabras, the only thing
     * this adds is a list of NonSignificant words.
     */
    public ContadorPalabrasSig(){
        super();
        this.noSignificativas=new ArrayList<>();
    }

    /**
     * After being given an array as a parameter (in this case cs2),
     * this method reads it and adds all the String
     * elements to the NonSignificant list, until said array is empty.
     * If the array given was empty, it does nothing.
     * @param cs2
     */
    public void leeArrayNoSig(String[] cs2){
        this.noSignificativas=new ArrayList<>();
        for (String s : cs2) {
            if (!s.isEmpty()) {
                noSignificativas.add(s.toUpperCase());
            }
        }
    }

    /**
     * Same thing as the method written before, just this time it reads from a file
     * in the project (the parameter recieved is the name of said file).
     * Using, as well, the delimiters specified by the user.
     * If the reading of the file fails, or the file does not exist, an exception will be thrown.
     * This method uses the anyadePalabrasNoSignificativas method.
     * @param filNom
     * @param del
     * @throws IOException
     */
    public void leeFicheroNoSig(String filNom, String del) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filNom))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                anyadePalabrasNoSignificativas(linea, del);
            }
        }

    }

    /**
     * Given a line of String elements, and delimiters specified by the user beforehand,
     * it adds each element to the NonSignificant list.
     * @param linea
     * @param del
     */
    private void anyadePalabrasNoSignificativas(String linea, String del) {
        String[] data = linea.split(del);
        for (String word : data) {
            if (!word.isEmpty()) {
                String upperWord = word.toUpperCase();
                if (!noSignificativas.contains(upperWord)) {
                    noSignificativas.add(upperWord);
                }
            }
        }
    }

    /**
     * An override of the method incluye, which will
     * add any elemt that's NOT on the NonSignificant list, using the method estaNoSig for it.
     * @param pal
     */
    @Override
    protected void incluye(String pal) {
        if (!pal.isEmpty()) {
            String upperPal = pal.toUpperCase();
            if (estaNoSig(upperPal) == -1) {
                super.incluye(upperPal);
            }
        }
    }

    /**
     * This method will recieve a String element as a parameter,
     * and will read the NonSignificant list to see if said element is in the NonSignificant list.
     * Returning the position where the element is found if that's the case, or returning -1 if not found.
     * @param pal
     * @return
     */
    public int estaNoSig(String pal){
        return noSignificativas.indexOf(pal.toUpperCase());
    }

}
