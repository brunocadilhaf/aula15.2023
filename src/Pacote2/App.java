package Pacote2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Pacote3.Motorista;
import Pacote3.Pessoa;
import Pacote3.Viagem;
import Pacote3.Passageiro;
public class App {
    public static void main(String[] args) throws Exception {
        /* Limpa o terminal */
        System.out.print("\033[H\033[2J");
        System.out.flush();
        /* Limpa o terminal */
        // List<Pessoa> lista = new ArrayList<>(); 
        // lista.add(new Passageiro("Bruno - 1","358425", 29));
        // lista.add(new Passageiro("Jose - 2","158425547854", 19));
        // lista.add(new Passageiro("Kesia - 3","573753", 15));
        // lista.add(new Motorista("Camille - 1", "1234", 15));
        // lista.add(new Motorista("chris - 2","155664", 19));

        // double media =
        //   lista.stream().collect(Collectors.averagingDouble(Pessoa::getIdade));
        // System.out.println("Média: " + media);

        // System.out.println("*******");

        // IntSummaryStatistics resumo =
        //   lista.stream().collect(Collectors.summarizingInt(Pessoa::getIdade));

        // System.out.println("Média: " + resumo.getAverage());

        // System.out.println("*******");

        // List<Pessoa> novaLista = lista.stream()
        //   .filter(p -> p instanceof Passageiro)
        //   .sorted(Comparator.comparing(Pessoa::getCpf))
        //   .collect(Collectors.toList());

        //   novaLista.forEach(System.out::println);

        List<Viagem> viagens = obterDados();
        viagens.forEach(System.out::println);     

        System.out.println("**********");
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Map<LocalDate, List<Viagem>> viagensPorData = viagens.stream()
          .collect(Collectors.groupingBy(Viagem::getData));
        
        viagensPorData.entrySet()
          .forEach(item -> 
            System.out.printf("Dia: %s - Viagens: %s \n", item.getKey().format(df), item.getValue()));

        System.out.println("**********");  
        
        Map<LocalDate, Double> viagemMedia = viagens.stream()
          .collect(Collectors.groupingBy(Viagem::getData, Collectors.averagingDouble(Viagem::getValor)));

        viagemMedia.entrySet()
          .forEach(item ->
            System.out.printf("Data: %s - Valor médio do dia: %.2f \n", item.getKey().format(df), item.getValue()));

    }

    public static List<Viagem> obterDados() {
      List<Viagem> viagens = new ArrayList<>();

      viagens.add(new Viagem(
          LocalDate.parse("2023-06-01"),
          new Motorista("Motorista 1", "812791496128", 29),
          new Passageiro("Passageiro 1", "221412412412", 20),
          122));
      
      viagens.add(new Viagem(
          LocalDate.parse("2023-06-01"),
          new Motorista("Motorista 2", "812791496128", 29),
          new Passageiro("Passageiro 2", "221412412412", 20),
          28.20));

      viagens.add(new Viagem(
          LocalDate.parse("2023-06-02"),
          new Motorista("Motorista 3", "812791496128", 29),
          new Passageiro("Passageiro 3", "221412412412", 20),
          98.23));
      
      viagens.add(new Viagem(
          LocalDate.parse("2023-06-02"),
          new Motorista("Motorista 4", "812791496128", 29),
          new Passageiro("Passageiro 4", "221412412412", 20),
          19.98));

      viagens.add(new Viagem(
          LocalDate.parse("2023-06-02"),
          new Motorista("Motorista 5", "812791496128", 32),
          new Passageiro("Passageiro 5", "221412412412", 20),
          34.20));
      
      viagens.add(new Viagem(
          LocalDate.parse("2023-06-02"),
          new Motorista("Motorista 6", "812791496128", 25),
          new Passageiro("Passageiro 6", "221412412412", 20),
          115.40));

      return viagens;
    }
}
