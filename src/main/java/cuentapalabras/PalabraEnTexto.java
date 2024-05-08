package cuentapalabras;

public class PalabraEnTexto {
    private final String palabra;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PalabraEnTexto palabraEnTexto = (PalabraEnTexto) obj;
        return palabra.equalsIgnoreCase(palabraEnTexto.palabra);
    }

    @Override
    public int hashCode() {
        return palabra.hashCode()+32;
    }
}
