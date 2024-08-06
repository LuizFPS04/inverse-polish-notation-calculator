public class App {
     public static void main(String[] args) {
          Stack pilha = new Stack();
          pilha.stackUp("?");
          pilha.stackUp("bem");
          pilha.stackUp("tudo");
          pilha.stackUp("oi");

          pilha.print();
          
          System.out.println(pilha.unstack());
          System.out.println(pilha.unstack());
          System.out.println(pilha.unstack());
          System.out.println(pilha.unstack());
     }
}