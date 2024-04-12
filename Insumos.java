import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insumos {
    private int idInsumo;
    private String nombreInsumo;
    private double costoInsumo;
    private String periodoPagoInsumo;


    public void setnombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }
    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
    public int getidInsumo() {
        return idInsumo;
    }
    public String getnombreInsumo() {
        return nombreInsumo;
    }
    public void setCostoInsumo(double costoInsumo) {
        this.costoInsumo = costoInsumo;
    }
    public double getCostoInsumo() {
        return costoInsumo;
    }
    public void setPeriodoPagoInsumo(String periodoPagoInsumo) {
        this.periodoPagoInsumo = periodoPagoInsumo;
    }
    public String getPeriodoPagoInsumo() {
        return periodoPagoInsumo;
    }

    public void agregarInsumo(ArrayList<Insumos> listaInsumos){
        Scanner entrada= new Scanner (System.in);
        boolean control = true;
        int id = 0; 

            do {
                Insumos nuevoInsumo = new Insumos();

                boolean validacion = true;
                do {
                    try {
                        System.out.println(" ");
                        System.out.println("Agregando insumos");
                        System.out.print("Ingrese el Id del insumo: ");
                        id= entrada.nextInt();
                        nuevoInsumo.setIdInsumo(id);
                        validacion = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next();
                    }
                } while (validacion);

                boolean idRepetido = false;
                for (Insumos insumos : listaInsumos) {
                    if(insumos.getidInsumo() == id) {
                        idRepetido = true;
                        break;
                    }
                }
                if(idRepetido) {
                    System.out.println("El ID ingresado ya existe. Por favor, ingrese un ID único.");
                    continue;
                }
                entrada.nextLine(); 
            
                System.out.print("Ingrese el nombre del insumo: ");
                String insumo= entrada.nextLine();
                nuevoInsumo.setnombreInsumo(insumo);
                
                boolean validacion1 = true;
                do {
                    try {
                        System.out.print("Ingrese el costo del insumo: ");
                        double costo= entrada.nextDouble();
                        nuevoInsumo.setCostoInsumo(costo);
                        validacion1 = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next();
                    }
                } while (validacion1);
            
                entrada.nextLine(); 
            
                System.out.println("Ingrese el periodo a pagar del insumo: Diario-Semanal-Quincenal-Mensual-Anual");
                System.out.print(": ");
                String periodo = entrada.nextLine();
                nuevoInsumo.setPeriodoPagoInsumo(periodo);
            
                listaInsumos.add(nuevoInsumo);
                
                boolean agregarMas = true;
                int opcion = 0;
                do {
                    try {
                        System.out.println("¿Desea agregar otro insumo?");
                        System.out.println("1. Si, 2.No");
                        System.out.print("Su opción: ");
                        opcion = entrada.nextInt();
                        if(opcion == 1 || opcion == 2) {
                            if(opcion == 1) {
                                control = true;
                            }
                            if(opcion == 2) {
                                control = false;
                            }
                        } else {
                            System.out.println("Opción no válida.");
                            continue;
                        }
                        agregarMas = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next();
                    }
                } while (agregarMas);
            } while (control); 
        }
        

    public void eliminarInsumo(ArrayList<Insumos>listaInsumos) {
        Scanner entrada = new Scanner(System.in);
        if (listaInsumos.isEmpty()) {
            System.out.println("No hay insumos registrados.");
            return;
        }

        boolean validacion = true;
        do {
            try {
                System.out.println(" ");
                System.out.println("LISTA DE INSUMOS");
                for (Insumos insumos : listaInsumos) {
                    System.out.println("ID: " + insumos.getidInsumo() + " Nombre del insumo: " + insumos.getnombreInsumo());
                }
                System.out.print("Ingrese el id del insumo a eliminar: ");
                int idInsumoEliminar = entrada.nextInt();
                boolean insumoEncontrado = false;
        
                for (Insumos insumos : listaInsumos) {
                    if(insumos.getidInsumo() == idInsumoEliminar) {
                        listaInsumos.remove(insumos);
                        System.out.println("Insumo eliminado correctamente");
                        insumoEncontrado = true;
                        break;
                    }
                }
                if (!insumoEncontrado) {
                    System.out.println("Insumo no encontrado.");
                }
                validacion = false;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción númerica.");
                System.out.println(" ");
                entrada.next();
            }
        } while (validacion);
    }
    
    public void modificarInsumo(ArrayList<Insumos>listaInsumos) {
        Scanner entrada = new Scanner(System.in);
        int idModificar = 0;
        int opcion = 0;
        verInsumos(listaInsumos);
        if (listaInsumos.isEmpty()) {
            return;
        }
        
        boolean validacion = true;
        do {
            try {
                System.out.print("Ingrese el ID del insumo a modificar: ");
                idModificar = entrada.nextInt();
                validacion = false;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción númerica.");
                System.out.println(" ");
                entrada.next();
            }
        } while (validacion);

        Insumos insumoModificar = null;
        for (Insumos insumo : listaInsumos) {
            if (insumo.getidInsumo() == idModificar) {
                insumoModificar = insumo;
                break;
            }
        }
        if (insumoModificar != null) {
            boolean validacion1 = true;
            do {
                do {
                    try {
                        System.out.println("Seleccione qué desea modificar");
                        System.out.println("1. Costo del insumo");
                        System.out.println("2. Periodo de pago del insumo");
                        System.out.println("3. Terminar cambio");
                        System.out.print("Su opción: ");
                        opcion = entrada.nextInt();
                        validacion1 = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next(); 
                    }
                } while (validacion1);
            switch (opcion) {
                case 1:
                boolean opcionValida = true;
                do {
                    try {
                        System.out.println(" ");
                        System.out.print("Ingrese el nuevo costo del insumo: ");
                        double nuevoCosto = entrada.nextDouble();
                        insumoModificar.setCostoInsumo(nuevoCosto);
                        System.out.println("Costo del insumo modificado exitosamente");
                        opcionValida = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next();
                    }
                } while (opcionValida);
                    break;
                case 2:
                boolean opcionValida2 = true;
                do {
                    try {
                        entrada.nextLine(); 
                        System.out.println(" ");
                        System.out.println("Ingrese el nuevo periodo de pago del insumo: Diario-Semanal-Quincenal-Mensual-Anual");
                        System.out.print(": ");
                        String nuevoPeriodo = entrada.nextLine();
                        insumoModificar.setPeriodoPagoInsumo(nuevoPeriodo);
                        System.out.println("Periodo de pago del insumo modificado exitosamente");
                        opcionValida2 = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una opción númerica.");
                        System.out.println(" ");
                        entrada.next();  
                    }
                } while (opcionValida2);
                    break;
                
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Opción inválida.");
                    break;
                }
                }
            } while (opcion != 3);
        } else {
            System.out.println("No se encontró ningún insumo con el ID proporcionado");
        }
    }

    public void verInsumos(ArrayList<Insumos>listaInsumos) {
        if (listaInsumos.isEmpty()) {
            System.out.println("No hay insumos registrados.");
            return;
        }
        System.out.println("Lista de insumos:");
            for (Insumos insumo : listaInsumos) {
                System.out.println("--------------------------");
                System.out.println("ID: " + insumo.getidInsumo());
                System.out.println("Nombre: " + insumo.getnombreInsumo());
                System.out.println("Costo: " + insumo.getCostoInsumo());
                System.out.println("Periodo de Pago: " + insumo.getPeriodoPagoInsumo());
                System.out.println("--------------------------");
                System.out.println(" ");
            }
    }        
}