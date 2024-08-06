public class Stack {
     private Element topElement;
     Element element;

     public Stack() {
          topElement = null;
     }

     public void stackUp(String element) {
          this.element = new Element(element);
          this.element.setBelow(topElement);
          topElement = this.element;
     }

     public Element unstack() {
          if (!isEmpty()) {
               System.out.println("there are no elements in the stack");
               return null;
          }
          Element aux = topElement;
          topElement = topElement.getBelow();
          aux.setBelow(null);
          return aux;
     }

     public boolean isEmpty() {
          if(topElement != null){
               return true;
          }
          return false;
     }

     public void print() {
          if (!isEmpty()) {
               System.out.println("there are no elements in the stack");
          } else {
               Element aux = topElement;
               while (aux != null) {
                    System.out.println("Element: " + aux.getValue() + " ");
                    aux = aux.getBelow();
               }
          }
     }
}
