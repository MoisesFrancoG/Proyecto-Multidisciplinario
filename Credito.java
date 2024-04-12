import java.util.ArrayList;
import java.util.InputMismatchException;

public class Credito extends Vendido{
    private double precio;
@Override
public void realizarVenta(ArrayList<Cliente> listaClientes) {
        int polloP = 0;
        int polloD = 0;
        double precio = 0;
        double montoPagar;
        boolean validacion1 = true;
        boolean validacion2 = true;

        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            System.out.println("Para continuar primero registre un cliente para asignar la deuda.");
            return;
        }
        
        boolean opcionValida = true;
        do {
            try {
                do {
                    System.out.print("Asigne un precio al pollo de esta venta: ");
                    precio = entrada.nextDouble();
                    if (precio <= 0) {
                        System.out.println("Precio no válido... Intente nuevamente.");
                    } else {
                        setPrecio(precio);
                    }
                }while(precio <= 0);
                opcionValida = false;
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
                if(polloP <  0) {
                    System.out.println("Número no valido");
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

        montoPagar = (polloD + polloP) * precio;
        System.out.println("El monto a pagar es: " + montoPagar);

        boolean clienteEncontrado = false;
        do {
            boolean validacion = true;
            int clienteEscoger = 0;
            do {
                try {
                    System.out.println("LISTA DE CLIENTES");
                    System.out.println("------------------");
                    for (Cliente cliente : listaClientes) {
                        System.out.println("ID: " + cliente.getId() + "Nombre: " + cliente.getNombre());
                    }
                    System.out.println("Seleccione el cliente para asignar la deuda.");
                    System.out.print("Su opción: ");
                    clienteEscoger = entrada.nextInt();
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getId() == clienteEscoger) {
                            double nuevoMonto = cliente.getMontoDeuda();
                            nuevoMonto = nuevoMonto + montoPagar;
                            cliente.setMontoDeuda(nuevoMonto);
                            System.out.println("Se ha asignado la deuda de: " + montoPagar);
                            clienteEncontrado = true;   
                            break;
                        }
                    }
                    if (!clienteEncontrado) {
                        System.out.println("El cliente a escoger no está en la lista.");
                    }
                    validacion = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción númerica.");
                    System.out.println(" ");
                    entrada.next(); 
                }
            } while (validacion);            
        }while(!clienteEncontrado);

}
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }
    
}