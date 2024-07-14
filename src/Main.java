import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Map<String, String> diccionario = new HashMap<>();
    diccionario.put("base de datos", "database");
    diccionario.put("servidor", "server");
    diccionario.put("lenguaje", "language");
    diccionario.put("algoritmo", "algorithm");
    diccionario.put("programación", "programming");
    diccionario.put("compilador", "compiler");
    diccionario.put("nube", "cloud");
    diccionario.put("seguridad", "security");
    diccionario.put("framework", "framework");
    diccionario.put("debug", "debug");
    diccionario.put("cliente", "client");
    diccionario.put("API", "API");
    diccionario.put("interface", "interface");
    diccionario.put("backend", "backend");
    diccionario.put("frontend", "frontend");
    diccionario.put("desarrollo", "development");
    diccionario.put("software", "software");
    diccionario.put("hardware", "hardware");
    diccionario.put("ingeniería", "engineering");
    diccionario.put("código", "code");

    List<String> palabrasElegidas = seleccionarPalabras(diccionario, 5);

    jugarTraduccion(diccionario, palabrasElegidas);
  }

  private static List<String> seleccionarPalabras(Map<String, String> diccionario, int cantidad) {
    Random random = new Random();
    return random.ints(0, diccionario.size())
            .distinct()
            .limit(cantidad)
            .mapToObj(i -> (String) diccionario.keySet().toArray()[i])
            .collect(Collectors.toList());
  }

  private static void jugarTraduccion(Map<String, String> diccionario, List<String> palabrasElegidas) {
    Scanner scanner = new Scanner(System.in);
    int respuestasCorrectas = 0;
    int respuestasIncorrectas = 0;

    System.out.println("¡Bienvenido al juego de traducción español-inglés!");
    for (String palabra : palabrasElegidas) {
      System.out.print("¿Cuál es la traducción de '" + palabra + "' en inglés?: ");
      String respuestaUsuario = scanner.nextLine().trim().toLowerCase();

      if (diccionario.containsKey(palabra) && diccionario.get(palabra).equalsIgnoreCase(respuestaUsuario)) {
        System.out.println("¡Correcto!");
        respuestasCorrectas++;
      } else {
        System.out.println("Incorrecto. La respuesta correcta es: " + diccionario.get(palabra));
        respuestasIncorrectas++;
      }
    }

    System.out.println("\nResumen:");
    System.out.println("Respuestas correctas: " + respuestasCorrectas);
    System.out.println("Respuestas incorrectas: " + respuestasIncorrectas);

    scanner.close();
  }
}
