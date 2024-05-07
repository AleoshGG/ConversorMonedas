package Principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        verMenu();
    }

    public static void verMenu() {
        int opcion = 0;

        do {
            System.out.println("\t\n----Bienvenido----\nElija una de las opciones de conversion");
            System.out.println("1. Dolar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dolar");
            System.out.println("3. Dolar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dolar");
            System.out.println("5. Dolar a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dolar");
            System.out.print("7. Salir\n>> ");
            try {
                opcion = ingresaEntero(opcion);
                switch (opcion) {
                    case 1:
                        realizarConversion("USD", "ARS", "Ingrese la cantidad en dolares: ", "USD equivalen a:", "ARS");
                        break;
                    case 2:
                        realizarConversion("ARS", "USD", "Ingrese la cantidad en peso argentino: ", "ARS equivalen a:", "USD");
                        break;
                    case 3:
                        realizarConversion("USD", "BRL", "Ingrese la cantidad en dolares: ", "USD equivalen a:", "BRL");
                        break;
                    case 4:
                        realizarConversion("BRL", "USD", "Ingrese la cantidad en real brasileño: ", "BRL equivalen a:", "USD");
                        break;
                    case 5:
                        realizarConversion("USD", "COP", "Ingrese la cantidad en dolares: ", "USD equivalen a:", "COP");
                        break;
                    case 6:
                        realizarConversion("COP", "USD", "Ingrese la cantidad en peso colombiano: ", "COP equivalen a:", "USD");
                        break;
                    case 7:
                        opcion = 0;
                        break;
                    default:
                        System.out.println("No valido");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vuelve a intentarlo");
                opcion = 1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while(opcion != 0);
    }

    public static void realizarConversion(String dvs1, String dvs2, String mensaje1, String resultado, String resultadoCola) throws IOException, InterruptedException {
        double cantidad = 0;
        Conversor conversor =  new Conversor(dvs1, dvs2);
        conversor.obtenerValorMoneda();

        try {
            System.out.print(mensaje1);
            cantidad = ingresaDouble(cantidad);
            System.out.println(cantidad + " " +resultado + " " + conversor.convertirCantidad(cantidad) + " " + resultadoCola);
        } catch (InputMismatchException e) {
            System.out.println("Intentelo de nuevo");
        }
    }

    public static int ingresaEntero(int numero) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();
        return numero;
    }

    public static double ingresaDouble(double numero) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        numero = sc.nextDouble();
        return numero;
    }
}
