import java.util.ArrayList;
import java.util.Scanner;

public class Vuelo {
    private String numero;
    private String origen;
    private String destino;
    private String dia;
    private Clase clase;

    protected enum Clase {
        turista, primera;
    }

    public Vuelo(String numero, String origen, String destino, String dia, Clase clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDia() {
        return dia;
    }

    public Clase getClase() {
        return clase;
    }

    public void printVuelos(ArrayList<Vuelo> vuelos) {
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos.");
            return;
        }

        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo.toString());
        }
    }

    public void addVuelo(ArrayList<Vuelo> vuelos) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de vuelo(año-mes): ");
        String numero = sc.nextLine();

        System.out.print("Ahora, introduce la localización de origen: ");
        String origen = sc.nextLine();

        System.out.print("Introduce el destino: ");
        String destino = sc.nextLine();

        System.out.print("Introduce el día del vuelo(dia-mes): ");
        String dia = sc.nextLine();

        Clase clase = null;
        boolean claseValida = false;

        while (!claseValida) {
            try {
                System.out.print("Por último, elige la clase del vuelo (Turista o Primera): ");
                clase = Clase.valueOf(sc.nextLine().toLowerCase());
                claseValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Esa clase de vuelo no existe. Vuelve a intentarlo.");

            }
        }

        vuelos.add(new Vuelo(numero, origen, destino, dia, clase));
        System.out.println("Vuelo agregado con éxito!");
        System.out.println("-----------------------------------");
    }

    public boolean findVuelo(ArrayList<Vuelo> vuelos) {
        Scanner sc = new Scanner(System.in);
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos.");
            return false;
        }

        System.out.print("Número de vuelo: ");
        String numero = sc.nextLine();

        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumero().equalsIgnoreCase(numero)) {
                System.out.println(vuelo.toString());
                System.out.println("-----------------------------------");
                return true;
            }
        }
        System.out.println("No existe ningún vuelo con ese número");
        System.out.println("-----------------------------------");
        return false;
    }

    public void claveVuelo(ArrayList<Vuelo> vuelos) {
        Scanner sc = new Scanner(System.in);
        if (vuelos.isEmpty()) {
            System.out.println("Vuelos no encontrados");
            return;
        }

        System.out.print("Clave: ");
        String clave = sc.nextLine();

        if (clave.equalsIgnoreCase("numero") || clave.equalsIgnoreCase("origen") || clave.equalsIgnoreCase("destino") || clave.equalsIgnoreCase("dia") || clave.equalsIgnoreCase("clase")) {
            System.out.print("Valor: ");
            String valor = sc.nextLine().toLowerCase();

            for (Vuelo vuelo : vuelos) {
                if (vuelo.getNumero().equalsIgnoreCase(valor) || vuelo.getOrigen().equalsIgnoreCase(valor) || vuelo.getDestino().equalsIgnoreCase(valor) || vuelo.getDia().equalsIgnoreCase(valor) || vuelo.getClase().equals(valor)) {
                    System.out.println("Datos del vuelo:");
                    System.out.println(vuelo.toString());
                } else {
                    System.out.println("No existen datos para (" + clave + " = " + valor + ")");
                }
            }
        } else {
            System.out.println("Lo siento, pero la clave no existe");
        }
    }

    public boolean removeVuelo(ArrayList<Vuelo> vuelos) {
        Scanner sc = new Scanner(System.in);
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos.");
            return false;
        }

        System.out.print("Introduce la clave del vuelo: ");
        String clave2 = sc.nextLine();

        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumero().equalsIgnoreCase(numero)) {
                vuelos.remove(vuelo);
                System.out.println("Vuelo nº" + vuelo.getNumero() + " eliminado con éxito.");
                return true;
            }
        }
        System.out.println("No se ha encontrado el vuelo.");
        return false;
    }

    @Override
    public String toString() {
        return "[Número: " + numero + ", Origen: " + origen + ", Destino: " + destino + ", Día: " + dia + ", Clase: " + clase + "]";
    }
}
