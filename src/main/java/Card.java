import java.util.ArrayList;

public class Card {
    public ArrayList<Integer> Elementos;
    public Card(){
        Elementos = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getElementos() {
        return Elementos;
    }

    public void setElementos(ArrayList<Integer> elementos) {
        Elementos = elementos;
    }
}

