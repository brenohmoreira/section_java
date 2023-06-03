import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Conceitos importantes:
         * 
         * Data-[hora] local: ano-mês-dia-[hora] sem fuso horário ([hora] opcional)
         * Data-hora global: ano-mês-dia-hora com fuso horário
         * Duração: tempo entre duas datas
         * 
         * Ex: 2022-07-23T14:30Z
         * 
         * 2022 é o ano, 7 é o mês, 23 é o dia. T indica que vai falar o horário, no caso: 14:30 no fuso de Z (Londres) 
         * 
         * Se o software só for utilizado de forma local (por exemplo em sistemas de supermercados), usamos data-hora local
         * Se o software for utilizado de forma global (a esmagadora maioria), interessa o fuso, logo, usamos data-hora global
         * 
         * Timezone (fuso horário):
         *      GMT (Greenwich mean time) 
         *           - Horário de Londres
         *           - Horário do padrão UTC - Coordinated Universal Time
         *           - "Z" time ou Zulu time
         * 
         *      Outros fusos são relativos ao GMT
         *           - São Paulo (SP): GMT-3 (Horário de Londres - 3 horas)
         *           - Portugal: GMT+1
         *           - Manaus: GMT-4
         *           - Algumas linguagens/tecnologias utilizam apenas o nome do fuso em questão
         * 
         * 
         * Padrão ISO 8601: padrão utilizado para data-hora local e global
         *      Data-hora local
         *          2022-07-21                 (ano-mes-dia)
         *          2022-07-21T14:52           (ano-mes-dia-hora:minuto)
         *          2022-07-21T14:52:09        (ano-mes-dia-hora:minuto:segundo)
         *          2022-07-21T14:52:09.4073   (ano-mes-dia-hora:minuto:segundo:miligegundo)
         *      
         *      Data-hora globa:
         *          2022-07-23T14:52:09Z        (ano-mes-dia-hora:minuto:segundoZ) -> Z: GMT/UTC (Londres)
         *          2022-07-23T14:52:09.254935Z (ano-mes-dia-hora:minuto:segundo.milisegundoZ) -> Z: GMT/UTC (Londres)
         *          2022-07-23t14:52:09-03:00   (ano-mes-dia-hora:minuto:segundo-03:00) -> GMT/UTC - 3 horas (SP - São Paulo)
         * 
         * Instanciação nas situações:
         *      (agora) -> Data-hora
         *      Texto ISO 8601 -> Data-hora
         *      Texto com formato personalizado -> Data-hora
         *      dia, mês, ano, [horário] -> Data-hora
         * 
         * Formatação nas situações:
         *      Data-hora -> Texto ISO 8601
         *      Data-hora -> Texto com formato personalizado
         * 
         * Operações importantes: Obter dados de uma data-hora local, converter data-hora global para local e cálculos data-hora
         * Obs: converter global para local seria pegar um texto iso 8601 genérico com o Z e converter dinamicamente para o horá
         * rio em cada região. Exemplo: 14:00 em Londres, em SP isso tem que ser convertido para a data-hora local: 11:00 
         * 
         * Data-hora local:
         *      - LocalDate
         *      - LocalDateTime (com horário junto)
         * 
         * Data-hora global:
         *      - Instant
         * 
         * Duração:
         *      - Duration
         * 
         * Outros:
         *      - Zoneld
         *      - ChronoUnit
         */

        // Instanciando d01 com o método estático LocalDate.now() -> (agora) -> data-hora
        LocalDate d01 = LocalDate.now();
        LocalDateTime d01_hour = LocalDateTime.now();
        Instant global = Instant.now();

        // Estamos usando o método toString dos objetos d01, d01_hour e global
        System.out.printf("" + d01 + "\n" + d01_hour + "\n" + "" + global + "\n");

        // Podemos escrever o horário manualmente. O -03:00 vai mudar no console para 04:30:26Z (ISO 8601 -> data-hora)
        Instant d01_read = Instant.parse("2022-07-20T01:30:26-03:00");

        System.out.printf("" + d01_read + "\n");

        /*
         * Para ler um formato personalizado de data em específico, usamos o datatimeformater
         * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
         */
        
        DateTimeFormatter ftr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ftr_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Vai pegar no formato personalizado, passar para o personalizado e armazena em person
        LocalDate person = LocalDate.parse("10/02/2022", ftr);
        LocalDateTime person_time = LocalDateTime.parse("10/02/2022 10:30", ftr_2);

        System.out.printf("" + person + "\n" + person_time + "\n");

        // of
        LocalDate of_person = LocalDate.of(2022, 10, 30);
        LocalDateTime oftime_person = LocalDateTime.of(2022, 10, 30, 10, 30, 10);

        System.out.printf("" + of_person + "\n" + oftime_person + "\n\n\n\n");

        // Agora veremos a formatação

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy. HH:mm\n");
        DateTimeFormatter only_hour = DateTimeFormatter.ofPattern("HH\n").withZone(ZoneId.systemDefault());
        // Pega uma data e transforma para a pattern selecionada com a timeZone (fuso) da pessoa
        DateTimeFormatter withTimeZone = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm\n").withZone(ZoneId.systemDefault());

        LocalDateTime exampleFormatter = LocalDateTime.now();
        Instant exampleGlobalFormat = Instant.now();

        System.out.printf("" + exampleFormatter.format(formatter));

        // Para Instant é obrigatório que seja DateTimeFormmater.format(data)
        System.out.printf("" + withTimeZone.format(exampleGlobalFormat));

        // Pegar um padrão já feito (link que já disse)
        DateTimeFormatter fmt = DateTimeFormatter.ISO_INSTANT;

        System.out.printf("" + fmt.format(exampleGlobalFormat) + "\n");
        System.out.printf("Only hour: " + only_hour.format(exampleGlobalFormat) + "\n\n\n\n");

        // Convertendo global p/local considerando um fuso horário específico

        Instant globalI = Instant.now();

        LocalDate local = LocalDate.ofInstant(globalI, ZoneId.systemDefault());
        LocalDate local_esp = LocalDate.ofInstant(globalI, ZoneId.of("Portugal"));

        System.out.printf("" + local + "\n" + local_esp + "\nOnly hour (sem formatter): " + local.getDayOfMonth() + "\n\n\n\n");

        // Cálculos com data e hora

        /*
         * São imutáveis. Precisamos criar outros objetos data-hora para guardar operações
         * Data-hora +/- tempo -> Data-hora
         * Data-hora 1, Data-hora 2 -> Duração
         */

        LocalDateTime timeNow = LocalDateTime.now();
        // Timenow +/- 7 dias
        LocalDateTime pastWeek = timeNow.minusDays(7);
        LocalDateTime nextWeek = timeNow.plusDays(7);

        System.out.printf("Time now: " + timeNow + "\nSemana passada: " + pastWeek + "\nPróxima semana: " + nextWeek + "\n");

        Instant inst_timeNow = Instant.now();

        Instant inst_pastWeek = inst_timeNow.minus(7, ChronoUnit.DAYS);
        Instant inst_nextWeek = inst_timeNow.plus(7, ChronoUnit.DAYS);

        System.out.printf("\nInstant time now: " + inst_timeNow + "\nSemana passada: " + inst_pastWeek + "\nPróxima semana: " + inst_nextWeek + "\n");
    
        // Duração -> Não dá com localdates

        Duration duration_local = Duration.between(pastWeek, nextWeek);

        System.out.printf("" + duration_local.toDays() + "\n");
    }
}
