import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dobble{
    int N;
    int numeroCartas;
    ArrayList<Object> mazo;
    ArrayList<String> elementos;
    int seed;

    public Dobble(ArrayList<String> elementos,int N, int numeroCartas, int seed) {
    }

    public static void main(String[] args) {
        System.out.println(generacionMazo(3));
        System.out.println(primeraCarta(generacionMazo(3)));
        System.out.println(numCards(generacionMazo(3)));
        System.out.println(cardsSetToString(generacionMazo(3)));
    }
    static ArrayList<Object> generacionMazo(int N) {
        ArrayList<Object> mazo = new ArrayList<Object>();
            ArrayList<Integer> firstCard = new ArrayList<Integer>();
            int i, j, k;
            for (i = 1; i <= N + 1; i++) {
                firstCard.add(i);
            }
            mazo.add(firstCard);
            for (i = 1; i <= N; i++) {
                ArrayList<Integer> nCards = new ArrayList<Integer>();
                nCards.add(1);
                for (j = 1; j <= N; j++) {
                    nCards.add(i * N + (j + 1));
                }
                mazo.add(nCards);
            }
            for (i = 1; i <= N; i++) {
                for (j = 1; j <= N; j++) {
                    ArrayList<Integer> n2Cards = new ArrayList<Integer>();
                    n2Cards.add(i + 1);
                    for (k = 1; k <= N; k++) {
                        n2Cards.add(N + 2 + N * (k - 1) + (((i - 1) * (k - 1) + j - 1) % N));
                    }
                    mazo.add(n2Cards);
                }
            }
            return mazo;
        }static int numCards(ArrayList mazo){
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

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getNumeroCartas() {
        return numeroCartas;
    }

    public void setNumeroCartas(int numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    public ArrayList<Object> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Object> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<String> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<String> elementos) {
        this.elementos = elementos;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}


