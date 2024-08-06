public class App {
     public static void main(String[] args) {
          Pilha pilha = new Pilha();
          pilha.Empilhar("?");
          pilha.Empilhar("bem");
          pilha.Empilhar("tudo");
          pilha.Empilhar("oi");
          pilha.print();
          System.out.println(pilha.Desempilhar());
          System.out.println(pilha.Desempilhar());
          System.out.println(pilha.Desempilhar());
          System.out.println(pilha.Desempilhar());
     }
}