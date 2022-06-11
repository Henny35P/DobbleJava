import java.util.ArrayList;

public class Card {
    public ArrayList<String> Elementos;
    public Card(){
        Elementos = new ArrayList<String>();
    }

    public ArrayList<String> getElementos() {
        return Elementos;
    }

    public void setElementos(ArrayList<String> elementos) {
        Elementos = elementos;
    }
}

