import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido a la calculadora personal de huella de carbono");
            System.out.println("Ingresa tu nombre en la siguiente linea:");
            String currentName = scanner.nextLine();
            ArrayList currentHomeValues = new ArrayList<Double>();
            System.out.println("A continuación requerimos que ingreses algunos datos para calcular tu huella de carbono personal");
            System.out.println("Ingresa el monto en quetzales de tu recibo mensual de gas");
            currentHomeValues.add(scanner.nextDouble());
            System.out.println("Ingresa el monto en quetzales de tu recibo mensual de luz");
            currentHomeValues.add(scanner.nextDouble());
            System.out.println("Cuantas personas viven en tu hogar?");
            currentHomeValues.add(scanner.nextDouble());
            ArrayList<Integer> currentTransportValues = new ArrayList<Integer>();
            System.out.println("Ingresa el numero de vuelos menores a 4 horas que has tomado el ultimo año");
            currentTransportValues.add(scanner.nextInt());
            System.out.println("Ingresa el número de vuelos mayores a 4 horas que has tomado el último año");
            currentTransportValues.add(scanner.nextInt());
            System.out.println("Ingresa el kilometraje anual de tu carro (0 si no tienes), únicamente valores enteros");
            currentTransportValues.add(scanner.nextInt());
            ArrayList<Integer> currentFoodValues = new ArrayList<Integer>();
            System.out.println("Selecciona la opción que mejor describe tu consumo de productos animales");
            System.out.println("1. Nunca - Vegano");
            System.out.println("2. Poco frecuente - Vegetariano / Huevos y leche, no carne");
            System.out.println("3. Ocasionalmente - Mayormente vegetariano, a veces carne leche o huevos");
            System.out.println("4. Frecuentemente - Carne algunas veces a la semana, huevos o leche casi diario");
            System.out.println("5. Muy frecuentemente - Carne todos los días");
            currentFoodValues.add(scanner.nextInt());
            System.out.println("Qué porcentaje de la comida que consumes es no procesada, sin empaquetar o local? Ingresa un número entero");
            currentFoodValues.add(scanner.nextInt());
            User newUser = new User(currentHomeValues, currentTransportValues, currentFoodValues);
            newUser.updateScores();
            newUser.showScores();
        }
    }
}