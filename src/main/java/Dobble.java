import javax.sound.midi.SysexMessage;
import java.util.*;
import java.util.stream.Collectors;

public class Dobble {
    int numE;
    int numCartas;
    ArrayList<Card> cardsSet;
    ArrayList<String> listaElementos;

    public static void main(String[] args) {

    }

    public Dobble(int numElementos, int numeroCartas) {
        numE = numElementos;
        numCartas = numeroCartas;

    }

    void generacionMazo(int numE) {
        int N = this.numE - 1;
        int num = this.numCartas;
        ArrayList<Card> cardsSet = new ArrayList<Card>();
        int i, j, k;

        Card x = new Card();
        for (i = 1; i <= N + 1; i++) {
            x.Elementos.add(String.valueOf(i));
        }
        cardsSet.add(x);
        for (i = 1; i <= N; i++) {
            Card y = new Card();
            y.Elementos.add(String.valueOf(1));
            for (j = 1; j <= N; j++) {
                y.Elementos.add(String.valueOf(i * N + (j + 1)));
            }
            cardsSet.add(y);
        }
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                Card z = new Card();
                z.Elementos.add(String.valueOf(i + 1));
                for (k = 1; k <= N; k++) {
                    z.Elementos.add(String.valueOf(N + 2 + N * (k - 1) + (((i - 1) * (k - 1) + j - 1) % N)));
                }
                cardsSet.add(z);
            }
        }
        Collections.shuffle(cardsSet);
        double Y = Math.pow(N, 2) + N + 1;
        if ((num > 0) && (num < Y)) {
            ArrayList<Card> cardsSetMax = new ArrayList<Card>();
            for (i = 0; i < num; i++) {
                cardsSetMax.add(cardsSet.get(i));
            }
            setMazo(cardsSetMax);
        } else {
            setMazo(cardsSet);
            setnumCartas(cardsSet.size());

        }

    }


    int numCards() {
        return this.cardsSet.size();
    }

    Card primeraCarta(ArrayList cardsSet) {
        return (Card) cardsSet.get(0);
    }

    @Override
    public String toString() {
        ArrayList<Card> X = this.cardsSet;
        StringBuilder CardsString = new StringBuilder();
        int i = 0;
        for (Card carta : X) {
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

    boolean isDobble(ArrayList<Card> cardsSet) {
        int j = 0;
        // Numero correcto cartas
        int N = this.getNumE();
        double cartasNecesarias = Math.pow(N, 2) + N + 1;
        if (cardsSet.size() > (cartasNecesarias)) {
            return false;
        }
        // Elementos solo se repiten una vez
        for (Card carta : cardsSet) {
            Set<String> X = carta.Elementos.stream().collect(Collectors.toSet());
            for (Card carta2 : cardsSet) {
                Set<String> Y = carta2.Elementos.stream().collect(Collectors.toSet());
                Y.retainAll(X);
                if (Y.size() > 1) {
                    j++;
                }
            }
        }
        if (j > this.numCartas) {
            return false;
        }
        return true;
    }

    void missingCards(ArrayList<Card> cardsSet) {
        Dobble missing = new Dobble(this.numE, -1);
        missing.generacionMazo(this.numE);
        Set<Card> Y = cardsSet.stream().collect(Collectors.toSet());
        Set<Card> Z = missing.cardsSet.stream().collect(Collectors.toSet());
        Z.retainAll(Y);
    }

    public int getnumCartas() {
        return numCartas;
    }

    public void setnumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public ArrayList<Card> getMazo() {
        return cardsSet;
    }

    public void setMazo(ArrayList<Card> cardsSet) {
        this.cardsSet = cardsSet;
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


