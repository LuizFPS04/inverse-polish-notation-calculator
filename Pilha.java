public class Pilha {
     private Element topElement;
     Element element;

     public Pilha() {
          topElement = null;
     }

     public void Empilhar(String element) {
          this.element = new Element(element);
          this.element.setBelow(topElement);
          topElement = this.element;
     }

     public Element Desempilhar() {
          if (!isVoid()) {
               System.out.println("there are no elements in the stack");
               return null;
          }
          Element aux = topElement;
          topElement = topElement.getBelow();
          aux.setBelow(null);
          return aux;
     }

     public boolean isVoid() {
          if(topElement != null){
               return true;
          }
          return false;
     }

     public void print() {
          if (!isVoid()) {
               System.out.println("there are no elements in the stack");
          } else {
               Element aux = topElement;
               while (aux.getBelow() != null) {
                    System.out.println("Element: " + aux.getValue() + " ");
                    aux = aux.getBelow();
               }
          }
     }
}
