/**
 * Classe que representa um elemento da pilha.
 * Cada elemento possui um valor e uma referência para o elemento abaixo dele.
 */
public class Element {
     private Element below;
     private String value;

     /**
      * Construtor da classe {@link Element}.
      * 
      * @param value Valor a ser atribuído ao elemento.
      */
     public Element(String value) {
          this.value = value;
     }

     /**
      * Define o elemento abaixo deste elemento.
      * 
      * @param below O elemento a ser definido como o elemento abaixo.
      */
     public void setBelow(Element below) {
          this.below = below;
     }

     /**
      * Retorna o elemento abaixo deste elemento.
      * 
      * @return O elemento abaixo deste elemento.
      */
     public Element getBelow() {
          return below;
     }

     /**
      * Define o valor deste elemento.
      * 
      * @param value O valor a ser atribuído a este elemento.
      */
     public void setValue(String value) {
          this.value = value;
     }

     /**
      * Retorna o valor deste elemento.
      * 
      * @return O valor deste elemento.
      */
     public String getValue() {
          return value;
     }
}