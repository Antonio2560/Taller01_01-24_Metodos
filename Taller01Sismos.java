package Taller01_Package;

import java.util.Random;//Permite la entrega de variables aleatorias como int,float,double,long.
import java.util.Scanner;//Permite la entrada de datos por parte del usuario.

public class Taller01Sismos {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static double[] sismos = new double[168]; // 7 días * 24 horas

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu()//ESTE ES EL METODO QUE SE ENCARGA DE MOSTRAR EL MENU
    {
        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ingresar datos de sismos");
            System.out.println("2. Mostrar sismo de mayor magnitud");
            System.out.println("3. Contar sismos mayores o iguales a 5.0");
            System.out.println("4. Enviar SMS por cada sismo mayor o igual a 7.0");
            System.out.println("5. Salir");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    ingresarDatos();
                    break;
                case "2":
                    System.out.println("Mayor sismo: " + buscarMayorSismo());
                    break;
                case "3":
                    System.out.println("Sismos >= 5.0: " + contarSismos());
                    break;
                case "4":
                    enviarSMS();
                    break;
                case "5":
                    salir = salir();// si tuvieramos salir=true; se terminaria el programa con solo pulsar la opcion 5 que no es lo que pide la tarea ya que hay que escribir una S para confirmar que se quiere salir del programa.
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void ingresarDatos() {
        System.out.println("Ingresando datos de sismos...");
        for (int i = 0; i < sismos.length; i++) {
            sismos[i] = random.nextDouble() * 10; // Valores entre 0.0 y 9.9
        }
        System.out.println("Datos de sismos ingresados correctamente.");
    }

    private static double buscarMayorSismo(){
    double mayor = 0;
    for (double sismo:sismos){
        if (sismo>mayor){
            mayor=sismo;
        }
    }
    return mayor;



    }

    private static int contarSismos() {
        int contador = 0;
        for (double sismo : sismos) {
            if (sismo >= 5.0) {
                contador++;
            }
        }
        return contador;
    }

    private static void enviarSMS() {
        for (double sismo : sismos) {
            if (sismo >= 7.0) {
                System.out.println("Alerta!!! se debe evacuar zona costera!");
            }
        }
    }

    private static boolean salir() {
        System.out.println("¿Está seguro que desea salir? (S/N)");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
}
