public class Element {
     private Element below;
     private String value;

     public Element(String value) {
          this.value = value;
     }

     public void setBelow(Element below) {
          this.below = below;
     }

     public Element getBelow() {
          return below;
     }

     public void setValue(String value) {
          this.value = value;
     }

     public String getValue() {
          return value;
     }
}
