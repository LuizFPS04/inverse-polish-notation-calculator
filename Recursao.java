public class Recursao {
    Stack pilha;
    Queue fila;
    String signal;

    public Recursao(Stack pilha){
        this.pilha = pilha;
        this.fila = new Queue();
        this.signal = "";
    }

    public Recursao unstackPushQueue(Stack pilha, String sinal){
        if (pilha.isEmpty()) {
            return null;
        }

        String firstElement = pilha.unstack().getValue();

        System.out.println("My Element: " + firstElement);

        if (pilha.topElement != null) {
            
            System.out.println("Top: " + pilha.topElement.getValue());
        }

        if (firstElement.equals("+") || firstElement.equals("-") || firstElement.equals("*") || firstElement.equals("/")) {
            this.signal = firstElement;
            return unstackPushQueue(pilha, firstElement);
        } else {
            fila.push(new Item(firstElement));
            fila.push(new Item(this.signal));
            return unstackPushQueue(pilha, sinal);
        }
    }
}
