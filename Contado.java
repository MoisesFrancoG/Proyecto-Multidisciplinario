import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contado extends Vendido{
    private double precio;
    private double montoPagar;
    Scanner entrada = new Scanner(System.in);

    @Override
    public void realizarVenta(ArrayList<Cliente> listaClientes) {
        int polloP = 0;
        int polloD = 0;
        double precio = 0;
        double monto;
        boolean validacion1 = true;
        boolean validacion2 = true;

        boolean opcionValida = true;
        do {
            try {
                do {
                    System.out.print("Asigne un precio al pollo de esta venta: ");
                    precio = entrada.nextDouble();
                    if (precio <= 0) {
                        System.out.println("Precio no válido... Intente nuevamente.");
                    } else {
                        opcionValida = false;
                        setPrecio(precio);
                    }
                }while(precio <= 0);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción númerica.");
                System.out.println(" ");
                entrada.next();
            }
        } while (opcionValida);

        do {
            try {
                System.out.print("Ingrese la cantidad de pollo en pie vendido: ");
                polloP = entrada.nextInt();
                if(polloP < 0) {
                    System.out.println("Número no válido");
                } else {
                    validacion1 = false;
                    setPolloEnPie(polloP);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción númerica.");
                System.out.println(" ");
                entrada.next();
            }
        }while(validacion1);

        do{
            try {
                System.out.print("Ingrese la cantidad de pollo destazado vendido: ");
                polloD = entrada.nextInt();
                if (polloD < 0) {
                    System.out.println("Número no válido");
                } else {
                    validacion2 = false;
                    setPolloDestazado(polloD);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción númerica.");
                System.out.println(" ");
                entrada.next();
            }
        }while(validacion2);
        monto = (polloD + polloP) * precio; 
        setMontoPagar(monto);
        System.out.println("La cantidad a pagar es: " + getMontoPagar());
        System.out.println("La cantidad total de pollos vendidos fue: " + (getPolloDestazado() + getPolloEnPie()));

    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }
    public double getMontoPagar() {
        return montoPagar;
    }
    public double getPrecio() {
        return precio;
    }
}
