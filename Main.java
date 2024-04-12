import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); 
        ArrayList<Insumos> listaInsumos = new ArrayList<Insumos>();
        Contado objContado = new Contado();
        Credito objCredito = new Credito();
        Producto objProducto = new Producto();
        Insumos objInsumo = new Insumos();
        Scanner entrada = new Scanner(System.in);
        int menu;
        boolean acceso;
        
          do {
            acceso = ingresarAlSistema(entrada);
        } while(acceso); 

        do {
            menu = mostrarMenu(entrada, listaClientes, objContado, objCredito, objProducto, listaInsumos, objInsumo);
        } while(menu != 5);
    }

    public static boolean ingresarAlSistema(Scanner entrada) {
        String usuario = "Admin"; // Variable de acceso al sistema
        String contraseña = "Admin"; // Variable de acceso al sistema
        boolean accesoSistema = true; // Control de acceso al sistema

        System.out.println(" ");
        System.out.print("Ingrese su usuario: ");
        String user = entrada.nextLine();
        if (user.equals(usuario)) {
            System.out.print("Ingrese su contraseña: ");
            String password = entrada.nextLine();
            if (password.equals(contraseña)) {
                accesoSistema = false;
                System.out.println("BIENVENIDO AL SISTEMA " + usuario);
            } else {
                System.out.println("Contraseña incorrecta... Inténtelo nuevamente.");
            }
        } else {
            System.out.println("Usuario incorrecto... Inténtelo nuevamente.");
        }
        
        return accesoSistema;
    }

    public static int mostrarMenu(Scanner entrada,ArrayList<Cliente> listaClientes, Contado objContado,Credito objCredito, Producto objProducto, ArrayList<Insumos> listaInsumos, Insumos objInsumo) {
        
        int opcionMenu = 0;
        boolean opcionValida = true;
        do {
            try {
                System.out.println(" ");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Producto");
                System.out.println("2. Clientes");
                System.out.println("3. Ventas");
                System.out.println("4. Insumos");
                System.out.println("5. Salir");
                System.out.print("Su opción es: ");
                opcionMenu = entrada.nextInt();
                opcionValida = false;
            } catch (InputMismatchException exception) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while (opcionValida);

        switch (opcionMenu) {
            case 1: {
                int opcionProducto = 0;
                do {
                    opcionProducto = mostrarMenuProducto(entrada, objProducto);
                } while (opcionProducto != 4);
                break;
            }
            case 2: {

                int opcionCliente = 0;
                do {
                    opcionCliente = mostrarMenuCliente(opcionCliente, entrada, listaClientes);
                } while(opcionCliente != 5);
                break;
            }
            case 3: {
                int opcionVenta = 0;
                do {
                    opcionVenta = mostrarMenuVentas(opcionVenta, entrada, objContado, objCredito, listaClientes);
                }while(opcionVenta != 3);
                break;
            }
            case 4: {
                int opcionInsumo = 0;
                do {
                    opcionInsumo = mostrarMenuInsumos(opcionInsumo, entrada, listaInsumos, objInsumo);
                } while (opcionInsumo != 5);
                break;
            }
            case 5: {
                System.out.println("SALIENDO DEL SISTEMA...");
                break;
            }
            default: {
                System.out.println("Opción no valida... Ingrese de nuevo");
            }
        }
        return opcionMenu;
    }

    public static int mostrarMenuProducto(Scanner entrada, Producto objProducto) {

        int opcionProducto = 0;
        boolean opcionValida = true;
        do {
            try {
                System.out.println(" ");
                System.out.println("PRODUCTO");
                System.out.println("1. Agregar producto.");
                System.out.println("2. Eliminar producto.");
                System.out.println("3. Ver producto.");
                System.out.println("4. Salir del apartado de producto.");
                System.out.print("Su opción es: ");
                opcionProducto = entrada.nextInt();
                opcionValida = false;
            } catch (InputMismatchException exception) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while (opcionValida);
        switch(opcionProducto) {
            case 1: {
                objProducto.agregarProducto();
                break;
            }
            case 2: {
                objProducto.eliminarProducto();
                break;
            }
            case 3: {
                objProducto.verProducto();
                break;
            }
            case 4: {
                break;
            }
            default: {
                System.out.println("Opción no valida... Ingrese de nuevo");
            }
        }
        return opcionProducto;
    }

    public static int mostrarMenuCliente (int opcionCliente, Scanner entrada,ArrayList<Cliente> listaClientes) {
        Cliente objCliente = new Cliente();
        boolean opcionValida = true;
            do {
                try {
                    System.out.println(" ");
                    System.out.println("CLIENTES");
                    System.out.println("¿Qué quiere hacer?");
                    System.out.println("1. Agregar cliente.");
                    System.out.println("2. Eliminar cliente.");
                    System.out.println("3. Modificar deuda del cliente.");
                    System.out.println("4. Ver clientes.");
                    System.out.println("5. Salir del apartado clientes");
                    System.out.print("Su opción es: ");
                    opcionCliente = entrada.nextInt();
                    opcionValida = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción numérica. Intente de nuevo");
                    System.out.println(" ");
                    entrada.next();
                }
            } while (opcionValida);
                    switch(opcionCliente) {
                        case 1: {
                            objCliente.agregarCliente(listaClientes);
                            break;
                        }
                        case 2: {
                            objCliente.eliminarCliente(listaClientes);
                            break;
                        }
                        case 3: {
                            objCliente.modificarDeuda(listaClientes);
                            break;
                        }
                        case 4: {
                            objCliente.verClientes(listaClientes);
                            break;
                        }
                        case 5: {
                            break;
                        }
                        default: {
                            System.out.println("Opción no válida... Ingrese otra vez");
                        }
                    }
        return opcionCliente;
    }

    public static int mostrarMenuVentas(int opcionVenta,Scanner entrada,Contado objContado,Credito objCredito,ArrayList<Cliente> listaClientes ) {
        boolean opcionValida = true;    
        do {
               try {
                System.out.println(" ");
                System.out.println("VENTAS");
                System.out.println("1. Realizar venta de contado.");
                System.out.println("2. Realizar venta a crédito.");
                System.out.println("3. Salir del apartado ventas.");
                System.out.print("Su opción es: ");    
                opcionVenta = entrada.nextInt();
                opcionValida = false;
               } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
               } 
            } while (opcionValida);
            switch(opcionVenta) {
                case 1: {
                    objContado.realizarVenta(listaClientes);
                    break;
                }
                case 2: {
                    objCredito.realizarVenta(listaClientes);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Opción no válida... Ingrese otra vez");
                }
            }
        return opcionVenta;
    }

    public static int mostrarMenuInsumos(int opcionInsumo, Scanner entrada, ArrayList<Insumos> listaInsumos, Insumos objInsumo){
        
        boolean opcionValida = true;
        do {
            try {
                System.out.println(" ");
                System.out.println("INSUMOS");
                System.out.println("1. Agregar insumos");
                System.out.println("2. Eliminar insumo");
                System.out.println("3. Modificar insumo");
                System.out.println("4. Ver insumos");
                System.out.println("5. Salir del apartado de insumos");
                System.out.print("Su opción es: ");
                opcionInsumo = entrada.nextInt();
                opcionValida = false;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while (opcionValida);
        switch (opcionInsumo) {
            case 1: {
                objInsumo.agregarInsumo(listaInsumos);
                break;
            }
            case 2: {
                objInsumo.eliminarInsumo(listaInsumos);
                break;            }
            
            case 3: {
                objInsumo.modificarInsumo(listaInsumos);
                break;
            }
            case 4: {
                objInsumo.verInsumos(listaInsumos);
                break;
            }
            case 5: {
                break;
            }
        }
        return opcionInsumo;
    }
}