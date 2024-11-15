package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones especificas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacios.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la maquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    /**
     * Permite que el jugador humano realice una jugada.
     *
     * @param i Coordenada de fila (0-2).
     * @param j Coordenada de columna (0-2).
     * @return true si la jugada fue exitosa, false si la casilla ya estaba ocupada.
     */
    public boolean jugadaHumano(int i, int j) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3 && tableroTresEnRaya[i][j].equals(" ")) {
            tableroTresEnRaya[i][j] = "O";
            return true;
        }
        return false;
    }

    /**
     * Valida si existe un ganador.
     *
     * @return "X" si gana la maquina, "O" si gana el humano, " " si no hay ganador.
     */
    public String validarGanador() {
        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tableroTresEnRaya[i][0].equals(tableroTresEnRaya[i][1]) &&
                tableroTresEnRaya[i][1].equals(tableroTresEnRaya[i][2]) &&
                !tableroTresEnRaya[i][0].equals(" ")) {
                return tableroTresEnRaya[i][0];
            }
            if (tableroTresEnRaya[0][i].equals(tableroTresEnRaya[1][i]) &&
                tableroTresEnRaya[1][i].equals(tableroTresEnRaya[2][i]) &&
                !tableroTresEnRaya[0][i].equals(" ")) {
                return tableroTresEnRaya[0][i];
            }
        }

        // Revisar diagonales
        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) &&
            !tableroTresEnRaya[0][0].equals(" ")) {
            return tableroTresEnRaya[0][0];
        }
        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) &&
            !tableroTresEnRaya[0][2].equals(" ")) {
            return tableroTresEnRaya[0][2];
        }

        return " "; // No hay ganador
    }
}
