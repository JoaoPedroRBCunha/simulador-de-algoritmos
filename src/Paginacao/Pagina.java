package Paginacao;

public class Pagina {
    public int numero;
    public int contador;

    public Pagina(int numero) {
        this.numero = numero;
        this.contador = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pagina page = (Pagina) obj;
        return numero == page.numero;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }
}