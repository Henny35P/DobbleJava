import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DobbleGame {
    private ArrayList<Player> players;
    private static Dobble mazo;
    private int numPlayers;


    public DobbleGame(Dobble cardsSet, int numPlayers) {
        this.players = players;
        this.mazo = cardsSet;
    }

    public static void main(String[] args) {
        Dobble Y = new Dobble(4,-5);
        Y.generacionMazo(Y.numE);
        DobbleGame X = new DobbleGame(Y,4);
        System.out.println(stackMode(Y));
    }
// Considerar como booleano/Integer
    // Verlo con exceptions

    // Editar esto
    public static ArrayList<String> stackMode (Dobble cardsSet){
        ArrayList<Card> X = cardsSet.getMazo();
        ArrayList<String> Y = new ArrayList<>();
        for (int i = 0; i < 2 ; i++ ){

            Y.addAll(X.get(i).getElementos());
        }
        return Y;
    }

    void play (String X){
        if (X == "null"){
            stackMode(this.mazo);
        }
        else if (X == "pass"){
            this.players.add(this.players.get(0));
            this.players.remove(0);
        }
        else if (X == "spotit") {
            stackMode(this.mazo);
            Scanner myScanner = new Scanner(System.in);
            String respuesta = myScanner.nextLine();
            if (respuesta == (match(stackMode(this.mazo)))){
                Player actual = this.players.get(0);
                actual.setPuntaje(actual.getPuntaje() + 1);
            }
            ArrayList<Card> nuevoMazo = this.mazo.getMazo();
            this.mazo.setMazo(nuevoMazo);
            this.players.add(this.players.get(0));
            this.players.remove(0);

        }
        else {
            System.out.println("NO ingreso comando");
        }
    }
    static String match(ArrayList<String> cartas){
        HashSet X = new HashSet();
        for (String elemento : cartas){
            if (X.add(elemento) == false){
                return elemento;
            }
        }
        return "ERROR";
    }

    void registerPlayer(String nombre){
        if (players.size() > numPlayers){
            System.out.println("Maximo de Jugadores"); // Poner con exceptions
        }
        for (Player player : this.players){
            if (nombre == player.nombre){
                System.out.println("Nombre repetido"); // Igualmente
            }
        }
        Player player = new Player(nombre,0);
        players.add(player);
    }

    String whoseTurnIsIt(){
      Player X = this.getPlayers().get(0);
      return X.getNombre();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Dobble getCardsSet() {
        return mazo;
    }

    public void setCardsSet(Dobble mazo) {
        this.mazo = mazo;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}