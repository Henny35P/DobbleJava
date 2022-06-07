import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Dobble {
    int numE;
    int numCartas;
    ArrayList<Card> mazo;
    ArrayList<String> listaElementos;

    public static void main(String[] args) {
        Dobble dobble = new Dobble(7, 10);
        dobble.generacionMazo(3);
//        dobble.isDobble(dobble.mazo);
//        dobble.missingCards(dobble.mazo);
        //System.out.println(dobble.mazo);
        //ArrayList<Card> X = dobble.getMazo();
        //Collections.shuffle(X);
        //System.out.println(cardsSetToString(dobble.mazo));
    }

    public Dobble(int numElementos, int numeroCartas) {
        numE = numElementos;
        numCartas = numeroCartas;

    }

    void generacionMazo(int N) {
        int num = this.numCartas;
        ArrayList<Card> mazo = new ArrayList<Card>();
        int i, j, k;

        Card x = new Card();
        for (i = 1; i <= N + 1; i++) {
            x.Elementos.add(i);
        }
        mazo.add(x);
        for (i = 1; i <= N; i++) {
            Card y = new Card();
            y.Elementos.add(1);
            for (j = 1; j <= N; j++) {
                y.Elementos.add(i * N + (j + 1));
            }
            mazo.add(y);
        }
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                Card z = new Card();
                z.Elementos.add(i + 1);
                for (k = 1; k <= N; k++) {
                    z.Elementos.add(N + 2 + N * (k - 1) + (((i - 1) * (k - 1) + j - 1) % N));
                }
                mazo.add(z);
            }
        }
        Collections.shuffle(mazo);
        double Y = Math.pow(N,2) + N + 1;


        if ((num > 0) && (num < Y)) {
            ArrayList<Card> mazoMax = new ArrayList<Card>();
            for (i = 0; i < num; i++) {
                mazoMax.add(mazo.get(i));
            }
            setMazo(mazoMax);
        } else {
            setMazo(mazo);
            setnumCartas(mazo.size());

        }

    }


    static int numCards(ArrayList mazo) {
        return mazo.size();
    }

    static Card primeraCarta(ArrayList mazo) {
        return (Card) mazo.get(0);
    }

    String cardsSetToString(ArrayList<Card> mazo) {
        StringBuilder CardsString = new StringBuilder();
        int i = 0;
        for (Card carta : mazo) {
            String cartaString = carta.getElementos().toString();
            CardsString.append("Carta ");
            CardsString.append(i + 1);
            CardsString.append(": ");
            CardsString.append(cartaString);
            CardsString.append("\n");
            i++;
        }
        String CardsSetToString = CardsString.toString();
        return CardsSetToString;
    }

    boolean isDobble (ArrayList<Card> mazo) {
        int j = 0;
        // Numero correcto cartas
        int N = this.getNumE();
        double cartasNecesarias = Math.pow(N,2) + N + 1;

        if (mazo.size() > (cartasNecesarias)) {
            return false;
        }

        // Elementos solo se repiten una vez
        for (Card carta : mazo){
            Set<Integer> X = carta.Elementos.stream().collect(Collectors.toSet());
            for (Card carta2 : mazo) {
                Set<Integer> Y = carta2.Elementos.stream().collect(Collectors.toSet());
                Y.retainAll(X);
                if (Y.size() > 1) {
                    j++;
                }
            }
        }
        if (j > this.numCartas){
            return false;
        }
        return true;
    }

    void missingCards (ArrayList<Card> mazo) {
        int X = this.numE - 1;
        Dobble missing = new Dobble(X,-1);
        missing.generacionMazo(X);
        Set<Card> Y = mazo.stream().collect(Collectors.toSet());
        Set<Card> Z = missing.mazo.stream().collect(Collectors.toSet());
        Z.retainAll(Y);
    }

    public int getnumCartas() {
        return numCartas;
    }

    public void setnumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public ArrayList<Card> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Card> mazo) {
        this.mazo = mazo;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public ArrayList<String> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(ArrayList<String> listaElementos) {
        this.listaElementos = listaElementos;
    }
}


