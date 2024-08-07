public class Item {
     private Item last;
     private Item next;
     private String value;

     public Item(String value) {
          this.value = value;
     }

     public void setNext(Item next) {
          this.next = next;
     }

     public Item getNext() {
          return next;
     }

     public void setLast(Item last) {
          this.last = last;
     }

     public Item getLast() {
          return last;
     }

     public void setValue(String value) {
          this.value = value;
     }

     public String getValue() {
          return value;
     }
}
