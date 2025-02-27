import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vuelo vuelo = new Vuelo("2023-01", "París", "Alemania", "15-02", Vuelo.Clase.primera);
        vuelos.add(vuelo);

        int opcion = -1;
        menu();

        while (opcion != 0) {
            System.out.print("Dame la opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("DATOS DE LOS VUELOS:");
                        vuelo.printVuelos(vuelos);
                        System.out.println("-----------------------------------");
                        break;

                    case 2:
                        System.out.println("BUSCAR VUELO POR Nº:");
                        vuelo.findVuelo(vuelos);
                        System.out.println("Datos del vuelo:");
                        break;

                    case 3:
                        System.out.println("BUSCAR VUELO POR CLAVE:");
                        vuelo.claveVuelo(vuelos);
                        System.out.println("-----------------------------------");
                        break;

                    case 4:
                        System.out.println("AÑADIR VUELO NUEVO:");
                        vuelo.addVuelo(vuelos);
                        break;

                    case 5:
                        System.out.println("BORRAR VUELO:");
                        vuelo.removeVuelo(vuelos);
                        System.out.println("-----------------------------------");
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Solo puedes introducir números");
                sc.nextLine();
            }
        }
    }

    public static void menu() {
        System.out.println("=========================================\n" +
                "    VUELOS DEL AEROPUERTO DE VALENCIA\n" +
                "=========================================\n" +
                "1 - Imprimir todos los vuelos\n" +
                "2 - Buscar un número de vuelo\n" +
                "3 - Buscar un vuelo por clave\n" +
                "4 - Añadir un vuelo nuevo\n" +
                "5 - Borrar un vuelo por número\n" +
                "0 - SALIR\n" +
                "-----------------------------------");
    }
}