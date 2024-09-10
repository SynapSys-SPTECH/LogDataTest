import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Main2 {
    public static void main(String[] args) {

        LocalDateTime horario = LocalDateTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String horarioFormatado = horario.format(formatador);

        System.out.println(horarioFormatado + " Horario Iniciado Programa");

        String estado;
        String mensagem;

        String cor;
        String vermelho = "\033[0;31m";
        String verde = "\033[0;32m";
        String amarelo = "\033[0;33m";
        String azul = "\033[0;34m";
        String reset = "\033[0m";


        // Definindo o tempo máximo de execução (em milissegundos)
        long tempoMaximo = 900000; // 15Min (900000 ms)
        long tempoInicio = System.currentTimeMillis();

        while (true) {

            long tempoAtual = System.currentTimeMillis();
            Integer random = ThreadLocalRandom.current().nextInt(1,5);

            if (random == 1){
                cor = vermelho;
                mensagem = "Mensagem de erro!";
                estado = "ERRO";
            }else if (random == 2){
                cor = verde;
                mensagem = "Mensagem de sucesso!";
                estado = "OKAY";
            }else if(random == 3){
                cor = amarelo;
                mensagem = "Mensagem de alerta!";
                estado = "ALERTA";
            }else {
                cor = azul;
                mensagem = "Mensagem de atualizando!";
                estado = "UPDATE";
            }

            horario = LocalDateTime.now();
            horarioFormatado = horario.format(formatador);

            System.out.println(String.format("[%s]%s%7s%s  %s", horarioFormatado, cor, estado, reset, mensagem));

            if (tempoAtual - tempoInicio >= tempoMaximo) {
                System.out.println("Tempo limite atingido. Interrompendo o log.");
                break;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

