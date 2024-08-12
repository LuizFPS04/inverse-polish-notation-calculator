public class App {
     public static void main(String[] args) {
          Stack myStack = ReaderFile.openDir();
          Recursao recursao = new Recursao(myStack);

          recursao.unstackPushQueue(myStack);
          recursao.fila.print();
     }
}