/**
 * Cantidad de numeros primos dado un límite inferior y superior, a través del uso de hilos
 * @author Helmer Pizarro Sandoval
 * @version 0.0.2
 */
public class Main {
    /**
     * Función main.
     * @param args
     */
    public static void main(String[] args) {
        //Se instancian ambos hilos
        CalcularPrimos parte1 = new CalcularPrimos(1,125000);
        CalcularPrimos parte2 = new CalcularPrimos(125001,250000);
        CalcularPrimos parte3 = new CalcularPrimos(250001,375000);
        CalcularPrimos parte4 = new CalcularPrimos(375001,500000);
        long startTime = System.currentTimeMillis();

        //Se comienza la ejecución de ambos hilos.
        parte1.start();
        parte2.start();
        parte3.start();
        parte4.start();
        try
        {
            //Se espera a que ambos terminen, para poder calcular el tiempo de ejecución.
            parte1.join();
            parte2.join();
            parte3.join();
            parte4.join();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        //El tiempo final de ejecución.
        long endTime =  System.currentTimeMillis() -  startTime;
        System.out.println("Hay en total: "+(parte1.getTotal()+parte2.getTotal()+parte3.getTotal()+parte4.getTotal())+" numeros primos entre "+parte1.getFrom()+" y "+parte4.getTo()+".");
        System.out.println("End time: "+endTime+" ms");
    }
}