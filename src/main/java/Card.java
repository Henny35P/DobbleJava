import java.util.ArrayList;
import java.util.Objects;

public class Card {
    public ArrayList<String> Elementos;

    public Card() {
        Elementos = new ArrayList<String>();
    }

    public ArrayList<String> getElementos() {
        return Elementos;
    }

    public void setElementos(ArrayList<String> elementos) {
        Elementos = elementos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getElementos(), card.getElementos());
    }
}

