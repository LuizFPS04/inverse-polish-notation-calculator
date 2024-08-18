/**
 * Classe principal.
 * A aplicação realiza a leitura de um arquivo contendo uma expressão em notação polonesa inversa (RPN),
 * converte a expressão para notação infixa, e imprime o resultado da expressão.
 */
public class App {
     /**
      * Método principal que executa a aplicação.
      * 
      * @param args Argumentos da linha de comando (não utilizados nesta aplicação).
      */
     public static void main(String[] args) {
         // Abre o diretório e lê o arquivo para obter a pilha com a expressão RPN
         Stack myStack = ReaderFile.openDir();
         
         // Obtém o resultado da leitura do arquivo
         String resulString = ReaderFile.result.printResult();
         
         // Cria um objeto Converter com a pilha lida do arquivo
         Converter converterObj = new Converter();
 
         // Converte a expressão RPN para notação infixa
         converterObj.unstackAndStackUp(myStack);
         
         // Move os elementos da pilha convertida para a fila
         converterObj.unstackPushQueue();
         
         // Imprime a expressão convertida e o resultado
         converterObj.printExpression(resulString);
     }
 }