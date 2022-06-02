import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dobble{
    int numE;
    int numCartas;
    ArrayList<Object> mazo;
    ArrayList<String> listaElementos;

    public static void main(String[] args) {
        Dobble dobble = new Dobble(7,30);
    }

    public Dobble(int numElementos, int numeroCartas) {
        numE = numElementos;
        numCartas = numeroCartas;

    }

    }

    static int numCards(ArrayList mazo){
            return mazo.size();
        }
    static ArrayList<Object> primeraCarta(ArrayList mazo){
            return (ArrayList<Object>) mazo.get(0);}
    static String cardsSetToString(ArrayList mazo) {
            StringBuilder CardsString = new StringBuilder();
            int i = 1;
            for (Object carta : mazo) {
                String cartaString = carta.toString();
                CardsString.append("Carta ");
                CardsString.append(i);
                CardsString.append(": ");
                CardsString.append(cartaString);
                CardsString.append("\n");
                i++;
            }
            String CardsSetToString = CardsString.toString();
            return CardsSetToString;
        }

    public int getnumCartas() {
        return numCartas;
    }

    public void setnumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public ArrayList<Object> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Object> mazo) {
        this.mazo = mazo;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumE(int numE) {
        this.numE= numE;
    }

    public ArrayList<String> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(ArrayList<String> listaElementos) {
        this.listaElementos = listaElementos;
    }
}


