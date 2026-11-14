import java.util.Scanner;

public class Campeonato {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] times = new String[10];
        int[][] tabela = new int[10][4];

        for (int i = 0; i < 10; i++) {
            System.out.println("\nTime " + (i + 1));
            System.out.print("  Nome: ");
            times[i] = entrada.next();
            System.out.print("  Vitórias: ");
            tabela[i][0] = entrada.nextInt();
            System.out.print("  Empates: ");
            tabela[i][1] = entrada.nextInt();
            System.out.print("  Derrotas: ");
            tabela[i][2] = entrada.nextInt();

            tabela[i][3] = tabela[i][0] * 3 + tabela[i][1] * 1 + tabela[i][2] * 0;
        }

        int[] ordem = new int[10];
        for (int i = 0; i < 10; i++) {
            ordem[i] = i;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {
                int atual = ordem[j];
                int proximo = ordem[j + 1];
                boolean trocar = tabela[proximo][3] > tabela[atual][3]
                        || (tabela[proximo][3] == tabela[atual][3] && tabela[proximo][0] > tabela[atual][0]);
                if (trocar) {
                    ordem[j ] = proximo;
                    ordem[j + 1] = atual;
                }
            }
        }

        System.out.println("\n TABELA ");
        System.out.printf("%-4s %-15s %3s %3s %3s %4s%n", "Pos", "Time", "V", "E", "D", "Pts");
        for (int i = 0; i < 10; i++) {
            int t = ordem[i];
            System.out.printf("%-4d %-15s %3d %3d %3d %4d%n",
                    i + 1, times[t], tabela[t][0], tabela[t][1], tabela[t][2], tabela[t][3]);
        }

        System.out.println("\n TRÊS PRIMEIROS ");
        for (int i = 0; i < 3; i++) {
            int t = ordem[i];
            System.out.println((i + 1) + "º lugar: " + times[t] + " com " + tabela[t][3] + " pontos");
        }

        entrada.close();
    }
}
