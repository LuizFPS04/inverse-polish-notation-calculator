public class Recursao {
    Stack pilha;
    Queue fila;
    String signal;

    public Recursao(Stack pilha){
        this.pilha = pilha;
        this.fila = null;
        this.signal = "";
    }

    public Recursao recu(Stack pilha, String sinal){
        String firstElement = pilha.unstack().getValue();

        if (firstElement.equals("+") || firstElement.equals("-") || firstElement.equals("*") || firstElement.equals("/")) {
            this.signal = firstElement;
            // fila.push(new Item("("));
            return recu(pilha, firstElement);
        } else if (pilha.topElement != null) {
            return null;
        } else {
            fila.push(new Item(firstElement));
            fila.push(new Item(this.signal));
            return recu(pilha, sinal);
        }
    }
}
