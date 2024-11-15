package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {
        flag = false;
        while (!flag) {
            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + 
                               "1. Imprimir tablero \n" + 
                               "2. Jugada de la maquina \n" + 
                               "3. Jugada de humano \n" + 
                               "4. Verificar ganador \n" + 
                               "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida.");
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese las coordenadas para su jugada (fila y columna, entre 1 y 3):");
        System.out.print("Fila (1,2,3): ");
        int fila = reader.nextInt() - 1; // Ajuste para indexar desde 0
        System.out.print("Columna (1,2,3): ");
        int columna = reader.nextInt() - 1; // Ajuste para indexar desde 0

        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Coordenadas fuera de rango. Intente de nuevo.");
            return;
        }

        if (cont.jugadaHumano(fila, columna)) {
            System.out.println("Su jugada ha sido registrada.");
        } else {
            System.out.println("La casilla seleccionada ya esta ocupada o es invalida. Intente de nuevo.");
        }
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.validarGanador();
        if (ganador.equals("X")) {
            System.out.println("¡La maquina ha ganado!, Buena suerte en la proxima xd");
        } else if (ganador.equals("O")) {
            System.out.println("¡Felicidades! Usted ha ganado.");
        } else {
            System.out.println("Aun no hay ganador.");
        }
    }
}
