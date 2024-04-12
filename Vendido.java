import java.util.Scanner;
import java.util.ArrayList;
public abstract class Vendido {
 
    protected int polloDestazado;
    protected int polloEnPie;
    Scanner entrada = new Scanner(System.in);

    public abstract void realizarVenta(ArrayList<Cliente> listaClientes);

    public void setPolloDestazado(int polloDestazado) {
        this.polloDestazado = polloDestazado;
    }
    public void setPolloEnPie(int polloEnPie) {
        this.polloEnPie = polloEnPie;
    }
    public int getPolloDestazado() {
        return polloDestazado;
    }
    public int getPolloEnPie() {
        return polloEnPie;
    }
}