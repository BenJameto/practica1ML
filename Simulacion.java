import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Simulacion {
    public static void main(String[] args) {
        SistemaCobro sistemaCobro = new SistemaCobro();

        Cliente alicia = new Cliente("Alicia", 15000);
        Cliente bob = new Cliente("Bob", 2400);
        Cliente cesar = new Cliente("César", 5000);
        Cliente diego = new Cliente("Diego", 9000);
        Cliente erika = new Cliente("Erika", 10000);
        Cliente fausto = new Cliente("Fausto", 5000);

        sistemaCobro.agregarCliente(alicia);
        sistemaCobro.agregarCliente(bob);
        sistemaCobro.agregarCliente(cesar);
        sistemaCobro.agregarCliente(diego);
        sistemaCobro.agregarCliente(erika);
        sistemaCobro.agregarCliente(fausto);

        // Simulación de un año
        try {
            FileWriter fileWriter = new FileWriter("transacciones.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int mes = 1; mes <= 12; mes++) {
                System.out.println("Registrando transacciones para el mes " + mes);

                printWriter.println("Mes " + mes + ":");

                alicia.contratarServicio("Memeflix", new MemeflixCobro());
                bob.contratarServicio("Memeflix", new MemeflixCobro());
                cesar.contratarServicio("Thisney+", new ThisneyCobro());
                diego.contratarServicio("HVO Max", new HvoMaxCobro());
                erika.contratarServicio("Memeflix", new MemeflixCobro());
                fausto.contratarServicio("Thisney+", new ThisneyCobro());

                sistemaCobro.cobrarServicios(mes);

                try {
                    Thread.sleep(2000); // Pausar la ejecución durante 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        
                printWriter.println();
            }
        
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}