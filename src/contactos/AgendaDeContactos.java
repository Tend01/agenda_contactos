package contactos;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nEmail: " + email;
    }
}

public class AgendaDeContactos {
    public static void main(String[] args) {
        ArrayList<Contacto> agenda = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // contactos agregados desde un inicio
        agenda.add(new Contacto("Lalo Lara", "123-456-7890", "laloexample.com"));
        agenda.add(new Contacto("Sebastian Enriquez", "987-654-3210", "msebas@example.com"));
        agenda.add(new Contacto("Derik Salazar", "555-555-5555", "derik@example.com"));

        while (true) {
            System.out.println("\n--- Agenda de Contactos ---");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar Contacto por Nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email del contacto: ");
                    String email = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, telefono, email);
                    agenda.add(nuevoContacto);
                    System.out.println("Contacto agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("\nLista de Contactos:");
                    for (Contacto contacto : agenda) {
                        System.out.println(contacto);
                        System.out.println("--------------------");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    boolean encontrado = false;

                    for (Contacto contacto : agenda) {
                        if (contacto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                            System.out.println("\nContacto encontrado:");
                            System.out.println(contacto);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\nContacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
