

import java.lang.Math;

/**
 * Clase que calculará la primera mitad de números primos.
 */
public class CalcularPrimos extends Thread{
    /**
     * Se definen los parámetros a utilizar dentro de la clase.
     */

    //from indica el límite inferior
    int from;
    //to indica el límite superior
    int to;
    //total indica la cantidad final de primoss en el intervalo determinado
    int total;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    CalcularPrimos(int from, int to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Método que inicia la ejecución del hilo.
     */
    public void run() {
        isPrimeCounter(from,to);
    }

    /**
     * Función que retorna si un número es efectivamente primo o no.
     * @param n es el número a poner a prueba.
     * @return true si n es primo.
     */
    public boolean isPrime(long n) {
        // No se pueden procesar números negativos.
        if (n <= 0) {
            throw new IllegalArgumentException("Error in n: Can't process negative numbers");
        }

        // Uno no es primo.
        if (n == 1) {
            return false;
        }

        //Dos no es primo.
        if (n == 2) {
            return false;
        }

        //Números pares no son primos.
        if (n % 2 == 0) {
            return false;
        }

        long max = (long)Math.sqrt(n);

        // Se utiliza max como el límite de la evaluación del ciclo.
        for (long i = 3; i <= max; i++) {

            // If module == 0 -> no es primo!
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Método que establece los límites superior e inferior para la evaluación de la cantidad de primos.
     * @param from corresponde al límite inferior.
     * @param to corresponde al límite superior.
     */
    public void isPrimeCounter(long from, long to) {
        int primes = 0;
        for (long k = from; k <= to; k++) {
            if (isPrime(k)) {
                primes++;
            }
        }
        //Se actualiza el total de primos de la mitad determinada.
        total = primes;
        System.out.println("Hay "+primes+" numeros primos entre "+from+" y "+to+".");
    }
}
