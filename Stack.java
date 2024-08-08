public class Stack {
     Element topElement;
     Element element;

     public Stack() {
          topElement = null;
     }

     public void stackUp(String element) {// empilhar
          this.element = new Element(element);
          this.element.setBelow(topElement);
          topElement = this.element;
     }

     public Element unstack() { // desempilhar
          if (isEmpty()) {
               System.out.println("there are no elements in the stack");
               return null;
          }
          Element stackAux = topElement;
          topElement = topElement.getBelow();
          stackAux.setBelow(null);
          return stackAux;
     }

     public boolean isEmpty() {
          if(topElement != null){
               return false;
          }
          return true;
     }

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
