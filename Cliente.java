import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Cliente {
    private int id;
    private String nombre;
    private String numeroTelefónico;
    private String dirección;
    private double montoDeuda;
    private String fechaDeuda;

    public void agregarCliente(ArrayList<Cliente> listaClientes) {
        Scanner entrada = new Scanner(System.in);
        int validacion;
        boolean control = true;
        boolean pass = true;
        int id;
        String nombre;
        String numero;
        String direccion;
        
        do{
            Cliente objCliente = new Cliente();

            boolean validacion1 = true;
            do {
                try {
                    System.out.println(" ");
                    System.out.println("INGRESANDO CLIENTES");
                    System.out.print("Ingrese el id del cliente: ");
                    id = entrada.nextInt();
                    objCliente.setId(id);
                    boolean idRepetido = false;
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getId() == id) {
                            idRepetido = true;
                            break;
                        }
                    }
                    if (idRepetido) {
                        System.out.println("El ID ingresado ya existe. Por favor, ingrese un ID único.");
                        continue;
                    }
                    validacion1 = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción numérica. Intente de nuevo");
                    System.out.println(" ");
                    entrada.next();
                }
            } while (validacion1);
            entrada.nextLine();
            System.out.print("Ingrese el nombre del cliente: ");
            nombre = entrada.nextLine();
            objCliente.setNombre(nombre);
            
            do {
                System.out.print("Ingrese el número telefónico del cliente (10 dígitos): ");
                numero = entrada.nextLine();
                if (numero.matches("\\d{10}")) {
                    break;
                } else {
                    System.out.println("El número telefónico debe contener exactamente 10 dígitos.");
                }
            } while (true);
            objCliente.setNumeroTelefónico(numero);
            
            System.out.print("Ingrese la dirección del cliente: ");
            direccion = entrada.nextLine();
            objCliente.setDirección(direccion);

            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaActual.format(formatter);
            objCliente.setFechaDeuda(fechaFormateada);

            do {
                try {
                    System.out.println("¿Los datos a ingresar son correctos?");
                    System.out.println(objCliente.getId());
                    System.out.println("Nombre del cliente: " + objCliente.getNombre());
                    System.out.println("Número telefónico del cliente: " + objCliente.getNumeroTelefonico());
                    System.out.println("Dirección del cliente: " + objCliente.getDireccion());
                    System.out.println("Fecha de la deuda: " + objCliente.getFechaDeuda());
                    System.out.println("1. Si, 2.Volver a ingresar los datos");
                    validacion = entrada.nextInt();
                    if (validacion == 1 || validacion == 2) {
                    if (validacion == 1) {
                        listaClientes.add(objCliente);
                        control = false;
                    }else {
                        control = true;
                    }
                    pass = false;
                    } else {
                        System.out.println("Opción no valida...");
                        pass = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción numérica. Intente de nuevo");
                    System.out.println(" ");
                    entrada.next();
                }
            }while(pass == true);
            control = preguntarOtroCliente(entrada);
        }while(control == true);
    }

    public static boolean preguntarOtroCliente(Scanner entrada) {
        boolean validacion = true;
        boolean controlCliente = true;
        
        do {
            try {
                System.out.println("¿Desea ingresar otro cliente?");
                System.out.println("1.Si, 2.No");
                int opcioC = entrada.nextInt();
                if (opcioC == 1 || opcioC == 2) {
                    if (opcioC == 1) {
                        controlCliente = true;
                    } else {
                        controlCliente = false;
                    }
                    validacion = false;
                } else {
                    System.out.println("Opción no válida");
                    validacion = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while(validacion);
        
        return controlCliente;
    }
    public void eliminarCliente(ArrayList<Cliente> listaClientes) {
        Scanner entrada = new Scanner(System.in);
        boolean controlEliminar = true;
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        do {
            try {
                System.out.println(" ");
                System.out.println("LISTA DE CLIENTES:");
                for (Cliente cliente : listaClientes) {
                    System.out.println("ID: " + cliente.getId() + " - Nombre: " + cliente.getNombre());
                }
        
                System.out.print("Ingrese el ID del cliente que desea eliminar: ");
                int idClienteEliminar = entrada.nextInt();
        
                boolean clienteEncontrado = false;
                for (Cliente cliente : listaClientes) {
                    if (cliente.getId() == idClienteEliminar) {
                        listaClientes.remove(cliente);
                        System.out.println("Cliente eliminado correctamente.");
                        clienteEncontrado = true;
                        break; 
                    }
                }
                if (!clienteEncontrado) {
                    System.out.println("Cliente no encontrado.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
            controlEliminar = preguntarOtroClienteEliminar(entrada);
        }while(controlEliminar);
        
    }

    public static boolean preguntarOtroClienteEliminar(Scanner entrada) {
        boolean validacion = true;
        boolean controlEliminar = true;
        
        do {
            try {
                System.out.println(" ");
                System.out.println("¿Desea eliminar otro cliente?");
                System.out.println("1.Si, 2.No");
                int opcioC = entrada.nextInt();
                if (opcioC == 1 || opcioC == 2) {
                    if (opcioC == 1) {
                        controlEliminar = true;
                    } else {
                        controlEliminar = false;
                    }
                    validacion = false;
                } else {
                    System.out.println("Opción no válida");
                    validacion = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while(validacion);
        
        return controlEliminar;
    }

    public void modificarDeuda(ArrayList<Cliente> listaClientes) {
        Scanner entrada = new Scanner(System.in);
        double nuevaDeuda;
        double abonoDeuda = 0;
        int clienteModificado = 0;
        
        verClientes(listaClientes);

        boolean validacion = true;
        if (listaClientes.isEmpty()) {
            return;
        }
        do {
            try {
                System.out.println(" ");
                System.out.print("Ingrese el id del cliente para modificar la deuda: ");
                clienteModificado = entrada.nextInt();
                validacion = false;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción numérica. Intente de nuevo");
                System.out.println(" ");
                entrada.next();
            }
        } while (validacion);

        Cliente clienteModifcar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == clienteModificado) {
                clienteModifcar = cliente;
                break;
            }
        }
        if (clienteModifcar != null) {
            boolean valida = true;
            do {
                try {
                    System.out.println(" ");
                    System.out.print("Ingrese la cantidad a pagar de la deuda: ");
                    abonoDeuda = entrada.nextInt();
                    valida = false;
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese una opción numérica. Intente de nuevo");
                    System.out.println(" ");
                    entrada.next();   
                }
            } while (valida);
            if (abonoDeuda <= 0) {
                System.out.println("Cantidad no válida.");
            } else {
                if(abonoDeuda > clienteModifcar.getMontoDeuda()) {
                    System.out.println("La cantidad abonada sobrepasa la deuda.");
                } else {
                    nuevaDeuda = clienteModifcar.getMontoDeuda();
                    nuevaDeuda = nuevaDeuda - abonoDeuda;
                    clienteModifcar.setMontoDeuda(nuevaDeuda);
                    System.out.println("Se ha abonado " + abonoDeuda + " a la cuenta.");
                }
            }
        } else {
            System.out.println("Id del cliente no encontrado.");
        }
    }

    public void verClientes(ArrayList<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println(" ");
        System.out.println("LISTA DE CLIENTES:");
    for (Cliente cliente : listaClientes) {
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Número Telefónico: " + cliente.getNumeroTelefonico());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Monto de Deuda: " + cliente.getMontoDeuda());
        System.out.println("Fecha de Deuda: " + cliente.getFechaDeuda());
        System.out.println("------------------------");
        System.out.println(" ");
    }
    }
    public int getId() {
        return id;
    }
    public String getDireccion() {
        return dirección;
    }
    public String getFechaDeuda() {
        return fechaDeuda;
    }
    public double getMontoDeuda() {
        return montoDeuda;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNumeroTelefonico() {
        return numeroTelefónico;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
    public void setNumeroTelefónico(String numeroTelefónico) {
        this.numeroTelefónico = numeroTelefónico;
    }
    public void setFechaDeuda(String fechaDeuda) {
        this.fechaDeuda = fechaDeuda;
    }
    public void setMontoDeuda(double montoDeuda) {
        this.montoDeuda = montoDeuda;
    }
}