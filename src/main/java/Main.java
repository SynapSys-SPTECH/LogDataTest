import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Obtém a data e a hora atuais
        LocalDateTime now = LocalDateTime.now();

        // Define um formato para data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Formata a data e a hora como string
        String formattedDateTime = now.format(formatter);

        // Exibe a data e hora no console
        System.out.println(formattedDateTime);

        String estado ="ERRO";
        String mensagem= "Mensagem de Erro";
        String cor = "\033[0;31m";
        String reset = "\033[0m";

//        while(!formattedDateTime.equals("2024-09-06 16:14:30")){
//            formattedDateTime = now.format(formatter);
//            System.out.println(String.format("[%s]%s%6s%s  %s", formattedDateTime,cor, estado,reset, mensagem));
//        };
//        do {
//            System.out.println(now);
//        }while (!now.equals("2024-09-06T16:17:10.00"));

        // Definindo o tempo máximo de execução (em milissegundos)
        long tempoMaximo = 10000; // 5 segundos (5000 ms)

        // Obtendo o tempo atual em milissegundos
        long tempoInicio = System.currentTimeMillis();

//        int contador = 0;

        // Iniciando o laço
        while (true) {
            // Executando alguma tarefa (exemplo: incrementando um contador)
//            contador++;

            // Verificando o tempo atual
            long tempoAtual = System.currentTimeMillis();

            now = LocalDateTime.now();
            formattedDateTime = now.format(formatter);

            System.out.println(formattedDateTime);
            // Verificando se o tempo máximo foi atingido
            if (tempoAtual - tempoInicio >= tempoMaximo) {
                System.out.println("Tempo limite atingido. Interrompendo o laço.");
                break;
            }

            // Simula uma tarefa que leva algum tempo para ser executada
            // Isso é só para mostrar como a condição de tempo afeta um loop
            try {
                Thread.sleep(2000); // Pausa de 100 milissegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final do contador: ");


//        System.out.println(String.format("[%s]%s%6s%s  %s", formattedDateTime,cor, estado,reset, mensagem));
    }
}
