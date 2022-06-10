import java.util.ArrayList;

public class DobbleGame {
    private ArrayList<Player> players;
    private static Dobble cardsSet;
    private int numPlayers;


    public DobbleGame(ArrayList<Player> players, Dobble cardsSet, int numPlayers) {
        this.players = players;
        this.cardsSet = cardsSet;
    }

    public static void main(String[] args) {
        DobbleGame X = new DobbleGame(4, );
        System.out.println(stackMode(X.cardsSet));
    }
// Considerar como booleano/Integer
    // Verlo con exceptions

    static public ArrayList<Card> stackMode (Dobble cardsSet){
        ArrayList<Card> X = cardsSet.getMazo();
        for (int i = 0; i < 2 ; i++ ){
            X.get(i);
        }



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
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}