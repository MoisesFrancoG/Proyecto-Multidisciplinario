import java.util.InputMismatchException;
import java.util.Scanner;

public class Producto {
    private int cantidadViva;
    private int cantidadDevolver;

    public void agregarProducto() {
        Scanner entrada = new Scanner(System.in);
        int cantidadViva = 0;
        int cantidadDevolver = 0;

        boolean opcionValida = true;
        do {
            try {
                System.out.print("Ingrese la cantidad de pollos vivos a ingresar: ");
                cantidadViva = entrada.nextInt();
                if (cantidadViva < 0) {
                    System.out.println("Cantidad no válida.");
                    System.out.println(" ");
                } else {
                    opcionValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while(opcionValida);

        boolean opcionValida2 = true;

        do {
            try {
                System.out.print("Ingrese la cantidad de pollos muertos a devolver: ");
                cantidadDevolver = entrada.nextInt();
                if (cantidadDevolver < 0) {
                    System.out.println("Cantidad no válida.");
                    System.out.println(" ");
                } else {
                    opcionValida2 = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while(opcionValida2);

        if (cantidadViva > 0 || cantidadDevolver > 0) {
            this.cantidadViva += cantidadViva;
            this.cantidadDevolver += cantidadDevolver;
            verProducto();
        } else {
            System.out.println("Cantidades no válidas.");
            System.out.println("No se agrego nada de producto.");
        }
    }

    public void eliminarProducto() {
        Scanner entrada = new Scanner(System.in);
        int cantidad = 0;
        boolean opcionValida = true;

        do {
            try {
                verProducto();
                System.out.print("Ingrese la cantidad de pollos vivos a eliminar: ");
                cantidad = entrada.nextInt();
                if (cantidad < 0) {
                    System.out.println("Cantidad no válida. Intente de nuevo.");
                    System.out.println(" ");
                } else {
                    System.out.println("Pollos eliminados: " + cantidad);
                    opcionValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while (opcionValida);

        if (cantidad <= this.cantidadViva) {
            this.cantidadViva -= cantidad;
        } else {
            System.out.println("No hay suficientes productos para eliminar");
            System.out.println(" ");
        }
        verProducto();
    }

    public void verProducto() {
        System.out.println(" ");
        System.out.println("Cantidad viva: " + cantidadViva);
        System.out.println("Cantidad a devolver: " + cantidadDevolver);
        System.out.println(" ");
    }

    public int getCantidadViva() {
        return cantidadViva;
    }

    public int getCantidadDevolver() {
        return cantidadDevolver;
    }

    public void setCantidadViva(int cantidadViva) {
        this.cantidadViva = cantidadViva;
    }

    public void setCantidadDevolver(int cantidadDevolver) {
        this.cantidadDevolver = cantidadDevolver;
    }
}