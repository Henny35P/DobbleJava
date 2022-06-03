import java.util.ArrayList;

public class Card {
    public ArrayList<Object> Elementos;
    public Card(){
        Elementos = new ArrayList<Object>();
    }

    public ArrayList<Object> getElementos() {
        return Elementos;
    }

    public void setElementos(ArrayList<Object> elementos) {
        Elementos = elementos;
    }
}

