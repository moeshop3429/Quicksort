import java.util.Random;

public class QuickSort {

    // Método principal
    public static void main(String[] args) {
        int[] tamanios = {1000, 5000, 10000, 20000};

        for (int n : tamanios) {
            System.out.println("Tamaño del arreglo: " + n);

            int[] aleatorio = generarAleatorio(n);
            int[] ordenado = generarOrdenado(n);
            int[] inverso = generarInverso(n);

            medirTiempo("Aleatorio", aleatorio);
            medirTiempo("Ordenado", ordenado);
            medirTiempo("Inverso", inverso);

            System.out.println("----------------------------------");
        }
    }

    // QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = particion(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

private static int particion(int[] arr, int low, int high) {
    int pivotIndex = low + (int)(Math.random() * (high - low + 1));
    intercambiar(arr, pivotIndex, high);

    int pivote = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivote) {
            i++;
            intercambiar(arr, i, j);
        }
    }
    intercambiar(arr, i + 1, high);
    return i + 1;
}


    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Medición de tiempo
    private static void medirTiempo(String tipo, int[] arr) {
        long inicio = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long fin = System.nanoTime();
        long tiempo = fin - inicio;

        System.out.println(tipo + ": " + tiempo + " ns");
    }

    // Generadores de arreglos
    private static int[] generarAleatorio(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    private static int[] generarOrdenado(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generarInverso(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }
}