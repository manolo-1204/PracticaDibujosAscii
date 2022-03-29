package es.rgmf;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int opcion, longitud, maxX, maxY;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("MENÚ:");
            System.out.println("1.- Dibujar cuadrado");
            System.out.println("2.- Dibujar triángulo rectángulo");
            System.out.println("3.- Dibujar puntos en un espacio bidimensional");
            System.out.println("0.- Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    longitud = pedirNumero(entrada, "Dame la longitud del lado: ");
                    dibujarCuadrado(longitud);
                    break;
                case 2:
                    longitud = pedirNumero(entrada, "Dame la altura del triángulo: ");
                    dibujarTrianguloRectangulo(longitud);
                    break;
                case 3:
                    maxX = pedirNumero(entrada, "Dame la longitud máxima en el eje X: ");
                    maxY = pedirNumero(entrada, "Dame la longitud máxima en el eje Y: ");
                    dibujarPuntos(maxX, maxY);
                    break;
                case 0:
                    System.out.println("Pos na tio, ta luego luca.");
                    break;
                default:
                    System.out.println("Cheee, la opción " + opcion + " no exite listo.");

            }

            System.out.print("Intro para continuar...");
            entrada.nextLine();
            System.out.println();
            System.out.println();
        } while (opcion != 0);

        entrada.close();
    }

    /**
     * Pide un número entero y devuelve lo que escriba el usuario tras limpiar la entrada.
     *
     * @param entrada objeto Scanner para leer de la entrada estándar.
     * @param mensaje objecto String con la información necesaria para que el usuario sepa lo que tiene que escribir.
     * @return el número entero escrito por el usuario.
     */
    private static int pedirNumero(Scanner entrada, String mensaje) {
        int numero;

        System.out.print(mensaje);
        numero = entrada.nextInt();
        entrada.nextLine();

        return numero;
    }

    /**
     * Dibuja un cuadrado de asteriscos.
     *
     * @param lado lado del cuadrado (número de asteriscos que habrá en cada lado del cuadrado).
     */
    private static void dibujarCuadrado(int lado) {
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                if (i == 0 || j == 0 || i == lado - 1 || j == lado - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Dibuja un triángulo rectángulo con asteriscos.
     *
     * @param altura altura del triángulo a dibujar.
     */
    private static void dibujarTrianguloRectangulo(int altura) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura; j++) {
                if (j == 0 || i == altura - 1 || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Dibuja asteriscos sobre un eje (x, y).
     *
     * @param maxX coordenada x máxima.
     * @param maxY coordenada y máxima.
     */
    private static void dibujarPuntos(int maxX, int maxY) {
        char[][] espacio = new char[maxX][maxY];
        int y;

        for (int i = 0; i < maxX; i++) {
            y = (int) (Math.random() * maxY);
            for (int j = 0; j < maxY; j++) {
                espacio[i][j] = y == j ? '*' : ' ';
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                System.out.print(espacio[i][j]);
            }
            System.out.println();
        }
    }
}
