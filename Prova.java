import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        System.out.println("CONVERSOR DE TEMPERATURAS\n");

        Scanner teclado = new Scanner(System.in);
        int quantidade = 0;

        while (quantidade<=0) {
            System.out.println("Informe quantas temperaturas deseja converter: ");
            quantidade = teclado.nextInt();
            if (quantidade <=0){
                System.out.println("Você deve informar ao menos 1 quantidade!");
            }
        }


        double[] temperaturas = new double[quantidade];
        int[] origem = new int[quantidade];
        int[] destino = new int[quantidade];
        double somaOrigem = 0;
        double somaDestino = 0;

        for (int i = 0; i<quantidade; i++){
            System.out.println("Digite a temperatura nº " + i +" :");
            temperaturas[i] = teclado.nextDouble();
            do {
                System.out.println("Qual a unidade de origem? (1 - Celsius / 2 - Kelvin / 3 - Farenheit): ");
                origem[i] = teclado.nextInt();
                if (origem[i] < 1 || origem[i] > 3){
                    System.out.println("Informe um número de 1 a 3.");
                }
            } while (origem[i] < 1 || origem[i] > 3);

            do {
                do {
                    System.out.println("Para qual unidade deseja converter? (1 - Celsius / 2 - Kelvin / 3 - Farenheit): ");
                    destino[i] = teclado.nextInt();
                    if (origem[i] == destino[i]){
                        System.out.println("A unidade de origem não pode ser igual à de destino! Escolha outra medida para converter!\n");
                    }
                }while (origem[i] == destino[i]);

                if (destino[i] < 1 || destino[i] > 3){
                    System.out.println("Informe um número de 1 a 3.");
                }

            } while (destino[i] < 1 || destino[i] > 3);
        }

        for (int i = 0; i<quantidade; i++){
            double convertido = blocoIf(origem[i], destino[i], temperaturas[i]);
            String nomeOrigem = switchOrigem(origem[i]);
            String nomeDestino = switchDestino(destino[i]);
            String unidade = "";
            switch (destino[i]){
                case 1:
                    unidade = "ºC";
                    break;
                case 2:
                    unidade = "ºK";
                    break;
                case 3:
                    unidade = "ºF";
                    break;
            }
            System.out.printf("%.2fº %s convertidos em %s: %.2f%s\n", temperaturas[i], nomeOrigem, nomeDestino, convertido, unidade);
            somaOrigem = somaOrigem + temperaturas[i];
            somaDestino = somaDestino + convertido;
        }

        System.out.println("Média das temperaturas de origem: " + (somaOrigem/quantidade));
        System.out.println("Média das temperaturas de destino: " + (somaDestino/quantidade));


    }

    public static double blocoIf (int origem, int destino, double temperatura){
        double convertido = 0;
        if (origem == 1 && destino == 2){
            convertido = celsiusParaKelvin(temperatura);
        } else if (origem == 1 && destino == 3) {
            convertido = celsiusParaFarenheit(temperatura);
        } else if (origem == 2 && destino == 1) {
            convertido = kelvinParaCelsius(temperatura);
        } else if (origem == 2 && destino == 3) {
            convertido = kelvinParaFarenheit(temperatura);
        } else if (origem == 3 && destino == 1) {
            convertido = farenheitParaCelsius(temperatura);
        }else {
            convertido = farenheitParaKelvin(temperatura);
        }
        return convertido;
    }

    public static double celsiusParaFarenheit(double temperatura){
        double convertido = (temperatura * (9/5)) + 32;
        return convertido;

    }
    public static double celsiusParaKelvin(double temperatura){
        double convertido = temperatura + 273.15;
        return convertido;
    }
    public static double kelvinParaFarenheit(double temperatura){
        double convertido = ((temperatura - 273.15) * (9/5)) + 32;
        return convertido;
    }
    public static double kelvinParaCelsius(double temperatura){
        double convertido = temperatura - 273.15;
        return convertido;
    }
    public static double farenheitParaCelsius(double temperatura){
        double convertido = (temperatura - 32) * (5/9);
        return convertido;
    }
    public static double farenheitParaKelvin(double temperatura){
        double convertido = ((temperatura - 32) * (5/9)) + 273.15;
        return convertido;
    }

    public static String switchOrigem(int numero){
        String origem = "";
        switch (numero){
            case 1:
                origem = "Celsius";
                break;
            case 2:
                origem = "Kelvin";
                break;
            case 3:
                origem = "Farenheit";
                break;
        }
        return origem;
    }
    public static String switchDestino(int numero){
        String destino = "";
        switch (numero){
            case 1:
                destino = "Celsius";
                break;
            case 2:
                destino = "Kelvin";
                break;
            case 3:
                destino = "Farenheit";
                break;
        }
        return destino;
    }
}
