/**
 * Classe que representa uma pilha.
 */
public class Stack {
     private Element topElement;
     private Element element;

     /**
      * Construtor da classe {@link Stack}.
      * Inicializa a pilha com o elemento de topo como {@code null}.
      */
     public Stack() {
          topElement = null;
     }

     /**
      * Adiciona um novo elemento ao topo da pilha.
      * 
      * @param element O valor do novo elemento a ser empilhado.
      */
     public void stackUp(String element) {
          this.element = new Element(element);
          this.element.setBelow(topElement);
          topElement = this.element;
     }

     /**
      * Remove e retorna o elemento do topo da pilha.
      * 
      * @return O elemento removido do topo da pilha; {@code null} se a pilha estiver
      *         vazia.
      */
     public Element unstack() {
          if (isEmpty()) {
               System.out.println("there are no elements in the stack");
               return null;
          }
          Element stackAux = topElement;
          topElement = topElement.getBelow();
          stackAux.setBelow(null);
          return stackAux;
     }

     /**
      * Verifica se o elemento fornecido é o topo da pilha.
      * 
      * @param myElement O elemento a ser verificado.
      * @return {@code true} se o elemento fornecido for o topo da pilha;
      *         {@code false} caso contrário.
      */
     public boolean isTop(Element myElement) {
          return myElement == topElement;
     }

     /**
      * Verifica se a pilha está vazia.
      * 
      * @return {@code true} se a pilha estiver vazia; {@code false} caso contrário.
      */
     public boolean isEmpty() {
          return topElement == null;
     }

     /**
      * Imprime todos os elementos da pilha, do topo ao fundo.
      * Se a pilha estiver vazia, exibe uma mensagem informando que não há elementos.
      */
     public void print() {
          if (isEmpty()) {
               System.out.println("there are no elements in the stack");
          } else {
               Element stackAux = topElement;
               while (stackAux != null) {
                    System.out.println("Element: " + stackAux.getValue() + " ");
                    stackAux = stackAux.getBelow();
               }
          }
     }
}