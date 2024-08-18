/**
 * Classe que representa um item em uma fila.
 * Cada item possui um valor, uma referência para o próximo item e uma
 * referência para o item anterior.
 */
public class Item {
     private Item last;
     private Item next;
     private String value;

     /**
      * Construtor da classe {@link Item}.
      * 
      * @param value Valor a ser atribuído ao item.
      */
     public Item(String value) {
          this.value = value;
     }

     /**
      * Define o próximo item na fila.
      * 
      * @param next O próximo item a ser definido.
      */
     public void setNext(Item next) {
          this.next = next;
     }

     /**
      * Retorna o próximo item na fila.
      * 
      * @return O próximo item na fila.
      */
     public Item getNext() {
          return next;
     }

     /**
      * Define o item anterior na fila.
      * 
      * @param last O item anterior a ser definido.
      */
     public void setLast(Item last) {
          this.last = last;
     }

     /**
      * Retorna o item anterior na fila.
      * 
      * @return O item anterior na fila.
      */
     public Item getLast() {
          return last;
     }

     /**
      * Define o valor deste item.
      * 
      * @param value O valor a ser atribuído a este item.
      */
     public void setValue(String value) {
          this.value = value;
     }

     /**
      * Retorna o valor deste item.
      * 
      * @return O valor deste item.
      */
     public String getValue() {
          return value;
     }
}