import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        while (true) {
            System.out.println("_____MENU_____");
            System.out.println("1 - Árvore Binária ");
            System.out.println("2 - Árvore AVL");
            System.out.println("3 - Teste Árvore Binária com X Valores");
            System.out.println("4 - Teste Árvore AVL com X Valores");
            System.out.println("5 - Teste Árvore AVL  e Binária, Remover ou Buscar valor dentro da árvore");
            System.out.println("0 - Sair");
            System.out.print("Digite a Opção: ");
            int arvore = sc.nextInt();
            switch (arvore) {
                case 1:
                    while (true) {
                        System.out.println("_____MENU_____");
                        System.out.println("1 - Inserir ");
                        System.out.println("2 - Deletar");
                        System.out.println("3 - Buscar");
                        System.out.println("0 - Sair");
                        System.out.print("Digite a Opção: ");
                        int bin = sc.nextInt();
                        switch (bin) {
                            case 1:
                                System.out.print("Digite o número para inserir na Árvore");
                                int valorI = sc.nextInt();
                                arvoreBinaria.inserir(valorI);
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                                break;
                            case 2:
                                System.out.print("Digite o número para deletar da Árvore");
                                int valorD = sc.nextInt();
                                arvoreBinaria.deletar(valorD);
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                                break;
                            case 3:
                                System.out.print("Digite o número para buscar na Árvore");
                                int valorB = sc.nextInt();
                                arvoreBinaria.buscar(valorB);
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Digite uma opção válida!");
                        }
                    }
                case 2:
                    while (true) {
                        System.out.println("_____MENU_____");
                        System.out.println("1 - Inserir ");
                        System.out.println("2 - Deletar");
                        System.out.println("3 - Buscar");
                        System.out.println("0 - Sair");
                        System.out.print("Digite a Opção: ");
                        int avl = sc.nextInt();
                        switch (avl) {
                            case 1:
                                System.out.print("Digite o número para inserir na Árvore");
                                int valorI = sc.nextInt();
                                arvoreAVL.inserir(valorI);
                                System.out.println("Pré-ordem da Árvore AVL");
                                arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                                break;
                            case 2:
                                System.out.print("Digite o número para deletar da Árvore");
                                int valorD = sc.nextInt();
                                arvoreAVL.deletar(valorD);
                                System.out.println("Pré-ordem da Árvore AVL");
                                arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                                break;
                            case 3:
                                System.out.print("Digite o número para buscar na Árvore");
                                int valorB = sc.nextInt();
                                arvoreAVL.buscar(valorB);
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Digite uma opção válida!");
                        }
                    }
                case 3:
                    System.out.print("Digite o número de inserções: ");
                    int inserB = sc.nextInt();
                    long startB = System.nanoTime();
                    for(int i = 0; i<inserB; i++) {
                        int valorI = rd.nextInt(1,1000);
                        arvoreBinaria.inserir(valorI);
                    }
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    long endB = System.nanoTime();
                    long duracaoB = endB - startB;
                    System.out.println("\nTempo decorrido para criar Arvore AVL com "+ inserB + " inserções: " + duracaoB + " nanosegundos");
                    System.exit(0);
                case 4:
                    System.out.print("Digite o número de inserções: ");
                    int inserA = sc.nextInt();
                    long startA = System.nanoTime();
                    for(int i = 0; i<inserA; i++) {
                        int valorI = rd.nextInt(1,1000);
                        arvoreAVL.inserir(valorI);
                    }
                    arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                    long endA = System.nanoTime();
                    long duracaoA = endA - startA;
                    System.out.println("\nTempo decorrido para criar Arvore AVL com "+ inserA + " inserções: " + duracaoA + " nanosegundos");
                    System.exit(0);
                case 5:
                    System.out.print("Digite o número de inserções: ");
                    int inser = sc.nextInt();
                    for(int i = 0; i<inser; i++) {
                        int valor = rd.nextInt(1,1000);
                        arvoreBinaria.inserir(valor);
                        arvoreAVL.inserir(valor);
                    }
                    System.out.println();
                    System.out.println("Pré-ordem da Árvore Binária");
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    System.out.println();
                    System.out.println("Pré-ordem da Árvore AVL");
                    arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                    while (true) {
                        System.out.println();
                        System.out.println("_____MENU_____");
                        System.out.println("1 - Deletar");
                        System.out.println("2 - Buscar");
                        System.out.println("0 - Sair");
                        System.out.print("Digite a Opção: ");
                        int op = sc.nextInt();
                        switch (op) {
                            case 1:
                                System.out.print("Digite o número para deletar da Árvore: ");
                                int valorD = sc.nextInt();
                                long start1 = System.nanoTime();
                                arvoreBinaria.deletar(valorD);
                                long end1 = System.nanoTime();
                                long start2 = System.nanoTime();
                                arvoreAVL.deletar(valorD);
                                long end2 = System.nanoTime();
                                long duracao1 = end1 - start1;
                                long duracao2 = end2 - start2;
                                System.out.println();
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                                System.out.println();
                                System.out.println("Pré-ordem da Árvore AVL");
                                arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                                System.out.println();
                                System.out.println("Tempo decorrido para deletar "+ valorD +" da Arvore Binária: " + duracao1 + " nanosegundos");
                                System.out.println("Tempo decorrido para deletar "+ valorD +" da Arvore AVL: " + duracao2 + " nanosegundos");
                                break;
                            case 2:
                                System.out.print("Digite o número para buscar da Árvore: ");
                                int valorB = sc.nextInt();
                                long start3 = System.nanoTime();
                                arvoreBinaria.buscar(valorB);
                                long end3 = System.nanoTime();
                                long start4 = System.nanoTime();
                                arvoreAVL.buscar(valorB);
                                long end4 = System.nanoTime();
                                long duracao3 = end3 - start3;
                                long duracao4 = end4 - start4;
                                System.out.println();
                                System.out.println("Pré-ordem da Árvore Binária");
                                arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                                System.out.println();
                                System.out.println("Pré-ordem da Árvore AVL");
                                arvoreAVL.preOrdem(arvoreAVL.getRaiz());
                                System.out.println();
                                System.out.println("Tempo decorrido para buscar "+ valorB +" da Arvore Binária: " + duracao3 + " nanosegundos");
                                System.out.println("Tempo decorrido para buscar "+ valorB +" da Arvore AVL: " + duracao4 + " nanosegundos");
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Digite uma opção válida!");

                        }
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Digite uma opção válida!");
            }
        }
    }
}
