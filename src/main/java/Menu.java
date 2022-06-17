import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements IMenu {

    DobbleGame newJuego;
    ArrayList<String> registrados;

    public static void main(String[] args) {
        Menu x = new Menu();
        x.iniciarMenu();


    }

    public void iniciarMenu() {
        int exitState = 0;
        int exitSubmenu = 0;
        int exitRegistro = 0;

        Scanner myScanner = new Scanner(System.in);
        this.registrados = new ArrayList<String>();
        while (exitState != 1) {
            // Se inicia con el registro de usuarios debido a el enunciado de el laboratorio
            while (exitRegistro != 1) {
                System.out.println("\t|Bienvenido a Dobble, ingrese el nombre de el jugador a registrar|");
                System.out.println("\t|Si quiere dejar de registrar, ingrese 0                         |");
                String input = myScanner.nextLine();
                if (input.equals("0")){
                    exitRegistro = 1;
                }
                registrados.add(input);
            }

            System.out.println("\t\tRegistrado como " + this.registrados.get(0));
            System.out.println("\t|Bienvenido a Dobble, porfavor elija una opcion|");
            System.out.println("\t|----------------------------------------------|");
            System.out.println("\t|1. Crear un Juego                             |");
            System.out.println("\t|2. Registrar un Jugador en el juego           |");
            System.out.println("\t|3. Jugar                                      |");
            System.out.println("\t|4. Ver estado del juego                       |");
            System.out.println("\t|4. Opciones Extras                            |");
            System.out.println("\t|0. Cerrar el juego                            |");
            System.out.println("\t|----------------------------------------------|");
            int input = myScanner.nextInt();

            switch (input) {
                case 1:
                    while (exitSubmenu != 1) {
                        crearJuego();
                        exitSubmenu = 1;
                    }
                    exitSubmenu = 0;
                    break;

                case 2:
                    while (exitSubmenu != 1) {
                        registrarUser();
                        exitSubmenu = 1;
                    }
                    exitSubmenu = 0;
                    break;
                case 3:
                    jugarJuego();
                    break;
                case 4:
                    verStatus();
                    break;
                case 0:
                    exitState = 1;
                    break;
            }
        }
    }

    public void crearJuego() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("\t|Ingrese el numero de elementos por carta      |");
        int input = myScanner.nextInt();
        System.out.println("\t|Ingrese el maximo de cartas                   |");
        int input2 = myScanner.nextInt();
        Dobble newMazo = new Dobble(input, input2);
        System.out.println("\t|Ingrese la cantidad de jugadores              |");
        int input3 = myScanner.nextInt();
        DobbleGame newJuego = new DobbleGame(newMazo, input3);
        newJuego.getCardsSet().generacionMazo(newJuego.getCardsSet().getNumE());
        this.newJuego = newJuego;
    }

    public void registrarUser() {
        int registrado = 0;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("\t|Ingrese el nombre del usuario a registrar      |");
        String input = myScanner.nextLine();
        for (String user : registrados){
            if (input.equals(user)){
                this.getNewJuego().registerPlayer(input);
                System.out.println("\t|Usuario registrado correctamente              |");
                registrado = 1;
            }
        }
        if (registrado == 0){
            System.out.println("Este Usuario no fue registrado anteriormente");
        }



    }

    public void jugarJuego() {
        int exitGame = 0;
        while (exitGame != 1) {
            String turno = "Es el turno de " + this.newJuego.getPlayers().get(0).getNombre();
            System.out.println("\t             " + turno);
            System.out.println("\t|Que accion desea realizar?                    |");
            System.out.println("\t|----------------------------------------------|");
            System.out.println("\t|1. Voltear cartas (No pasara turno)           |");
            System.out.println("\t|2. Spot it!                                   |");
            System.out.println("\t|3. Pasar turno                                |");
            System.out.println("\t|4. Regresar a menu principal                  |");
            Scanner myScanner = new Scanner(System.in);
            int input = myScanner.nextInt();

            switch (input) {
                case 1:
                    this.newJuego.play("null");
                    break;
                case 2:
                    this.newJuego.play("spotit");
                    break;
                case 3:
                    this.newJuego.play("pass");
                    break;
                case 4:
                    exitGame = 1;
                    break;
                default:
                    System.out.println("Porfavor elija una opcion valida");
                    break;
            }
        }
    }

    public void verStatus() {
        for (Player player : this.newJuego.getPlayers()) {
            String X = player.getNombre();
            String Y = player.getPuntaje().toString();
            System.out.println("El usuario " + X + " tiene " + Y + " Puntos");
        }
        int cartasRestantes = (this.newJuego.getCardsSet().numCards());
        System.out.println("Quedan " + cartasRestantes + " cartas");
    }

    public DobbleGame getNewJuego() {
        return newJuego;
    }

    public void setNewJuego(DobbleGame newJuego) {
        this.newJuego = newJuego;
    }


}
