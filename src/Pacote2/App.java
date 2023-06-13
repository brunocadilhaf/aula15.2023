package Pacote2;

import java.util.Scanner;

import Pacote3.Carro;
import Pacote3.Motorista;
import Pacote3.PlacaInvalidaException;


public class App {
    public static void main(String[] args)  {
        /* Limpa o terminal */
        System.out.print("\033[H\033[2J");
        System.out.flush();
        /* Limpa o terminal */

        Scanner sc = new Scanner(System.in);
        try {
          Carro carro = new Carro(sc.next(), 12345, new Motorista());
          System.out.println("Placa do carro: " + carro.getPlaca());
        } catch (PlacaInvalidaException e) {
          System.out.println(e.getMessage());
        } finally {
          sc.close();
        }
    }
}
