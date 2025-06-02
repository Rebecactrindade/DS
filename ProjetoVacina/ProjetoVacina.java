import java.util.Scanner;

public class ProjetoVacina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] genes = new int[N];

        for (int i = 0; i < N; i++) {
            genes[i] = scanner.nextInt();
        }

        int valorAnalise = scanner.nextInt();

        int contador = 0;
        for (int i = 0; i < N; i++) {
            if (genes[i] == valorAnalise) {
                contador++;
            }
        }

        if (contador > 1) {
            System.out.println("Achei o danado");
        } else if (contador == 1) {
            System.out.println("Ainda não é o suficiente");
        } else {
            System.out.println("Sumiuu!");
        }

        scanner.close();
    }
}
