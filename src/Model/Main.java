 package Model;
import java.util.ArrayList;

import java.util.Scanner;
//
//public class Main {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    System.out.print("Digite seu nome: ");
//    String nome = sc.nextLine();
//    System.out.print("Digite seu Usuario: ");
//    String usuario = sc.nextLine();
//    System.out.print("Digite sua Senha: ");
//    String senha = sc.nextLine();
//
//
//    System.out.println("Tipos de ingresso disponíveis:");
//    System.out.println("1. Normal");
//    System.out.println("2. Meia");
//    System.out.println("3. VIP");
//
//    System.out.print("Escolha o tipo de ingresso (1, 2 ou 3): ");
//    int tipoIngresso = sc.nextInt();
//
//    // Capturando a quantidade desejada
//    System.out.print("Digite a quantidade desejada: ");
//    int quantidade = sc.nextInt();
//
//    double precoTotal = calcularPrecoTotal(tipoIngresso, quantidade);
//
//    Ingresso ingresso;
//    switch (tipoIngresso) {
//      case 1:
//        ingresso = new IngressoNormal("Normal", 50.0, quantidade, "Sem benefícios");
//        break;
//      case 2:
//        ingresso = new IngressoMeia("Meia", 50.0, quantidade, "50% de desconto");
//        break;
//      case 3:
//        ingresso = new IngressoVip("VIP", 50.0, quantidade, "Cadeira VIP");
//        break;
//      default:
//        System.out.println("Tipo de ingresso inválido");
//        return;
//    }
//
//    System.out.println("\nDetalhes da compra:");
//    System.out.println("Nome: " + nome);
//    System.out.println("Tipo de ingresso: " + ingresso.tipoIngresso());
//    System.out.println("Quantidade: " + quantidade);
//    System.out.println("Beneficio: " + ingresso.Beneficios());
//    System.out.println("Preço total: R$" + precoTotal);
//
//    sc.close();
//  }
//
//  public static double calcularPrecoTotal(int tipoIngresso, int quantidade) {
//    double precoUnitario = 50.0; // Preço padrão para todos os tipos de ingresso;
//    switch (tipoIngresso) {
//      case 1:
//        precoUnitario = 50.0; // Normal
//        break;
//      case 2:
//        precoUnitario = 50.0 / 2; // meia
//        break;
//      case 3:
//        precoUnitario = 50.0 + (precoUnitario * 0.5);// Vip
//        break;
//      default:
//        System.out.println("Tipo de ingresso inválido");
//    }
//    return precoUnitario * quantidade;
//  }
//}
