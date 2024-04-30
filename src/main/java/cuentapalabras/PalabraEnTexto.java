package cuentapalabras;

public class PalabraEnTexto {
    private String palabra;
    private int veces;
    public PalabraEnTexto(String n){
        if(n.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }else{
            this.palabra=n.toUpperCase();
            this.veces=1;
        }
    }
    public void incrementa(){
        this.veces++;
    }

    @Override
    public String toString() {
        return this.palabra+": "+this.veces;
    }

    @Override
    public boolean equals(Object obj) {

    }
}
