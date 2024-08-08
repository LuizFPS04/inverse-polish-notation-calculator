public class App {
     public static void main(String[] args) {
          Stack myStack = ReaderFile.read("C:\\Users\\upflo\\OneDrive\\Área de Trabalho\\IFMG\\PROG3\\inverse-polish-notation-calculator\\docs\\input.txt","input");
          Recursao recursao = new Recursao(myStack);

          recursao.unstackPushQueue(myStack);
          recursao.fila.print();
     }
}