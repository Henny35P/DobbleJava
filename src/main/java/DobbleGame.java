import java.util.ArrayList;

public class DobbleGame {
    private ArrayList<Player> players;
    private Dobble cardsSet;
    private int numPlayers;


    public DobbleGame(DobbleGame game, ArrayList<Player> players, Dobble cardsSet, int numPlayers) {
        this.players = players;
        this.cardsSet = cardsSet;
    }

// Considerar como booleano/Integer
    // Verlo con exceptions
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