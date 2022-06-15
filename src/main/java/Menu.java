import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Menu x = new Menu();
        x.iniciarMenu();


    }

    void iniciarMenu(){
        System.out.println("\t|Bienvenido a Dobble, porfavor elija una opcion|");
        System.out.println("\t|----------------------------------------------|");
        System.out.println("\t|1. Crear un Juego                             |");
        System.out.println("\t|2. Registrar un Jugador                       |");
        System.out.println("\t|3. Jugar                                      |");
        System.out.println("\t|4. Ver estado del juego                       |");
        System.out.println("\t|----------------------------------------------|");
        Scanner myScanner = new Scanner(System.in);
        int input = myScanner.nextInt();

        switch (input) {
            case 1:

        }


    }

}
