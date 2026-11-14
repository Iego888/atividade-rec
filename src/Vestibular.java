import java.util.Scanner;

public class Vestibular {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        long[][] inscritos = new long[10][3];
        int totalInscritos = 0;

        while (totalInscritos < 10) {
            System.out.println("\nInscrição " + (totalInscritos + 1) + " de 10");
            System.out.print("  CPF (somente números): ");
            long cpf = entrada.nextLong();

            boolean cpfRepetido = false;
            for (int i = 0; i < totalInscritos; i++) {
                if (inscritos[i][0] == cpf) {
                    cpfRepetido = true;
                    break;
                }
            }

            if (cpfRepetido) {
                System.out.println("  CPF já cadastrado, registro não inserido.");
                continue;
            }

            System.out.print("  Idade: ");
            int idade = entrada.nextInt();
            while (idade <= 0) {
                System.out.print("  Idade inválida. Digite novamente: ");
                idade = entrada.nextInt();
            }

            System.out.print("  Curso (1-ADS, 2-GECOM, 3-Eventos, 4-RH): ");
            int curso = entrada.nextInt();
            while (curso < 1 || curso > 4) {
                System.out.print("  Curso inválido. Digite de 1 a 4: ");
                curso = entrada.nextInt();
            }

            inscritos[totalInscritos][0] = cpf;
            inscritos[totalInscritos][1] = idade;
            inscritos[totalInscritos][2] = curso;
            totalInscritos++;
        }

        int ads = 0, gecom = 0, eventos = 0, rh = 0;
        double somaIdades = 0;

        for (int i = 0; i < totalInscritos; i++) {
            somaIdades += inscritos[i][1];
            switch ((int) inscritos[i][2]) {
                case 1: ads++; break;
                case 2: gecom++; break;
                case 3: eventos++; break;
                case 4: rh++; break;
            }
        }

        System.out.println("\n RESULTADO ");
        System.out.println("ADS: " + ads + " inscrito(s)");
        System.out.println("GECOM: " + gecom + " inscrito(s)");
        System.out.println("Eventos: " + eventos + " inscrito(s)");
        System.out.println("RH: " + rh + " inscrito(s)");
        System.out.printf("Média de idade: %.1f anos%n", somaIdades / totalInscritos);

        entrada.close();
    }
}
