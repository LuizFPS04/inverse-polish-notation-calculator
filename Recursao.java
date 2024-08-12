public class Recursao {
    Stack enterStack;
    Stack convertedStack;
    Queue fila;
    String signal;

    public Recursao(Stack enterStack) {
        this.enterStack = enterStack;
        this.fila = new Queue();
        this.signal = null;
    }

    public void unstackPushQueue(Stack pilha) { // 5 9 3 + 4 2 * * 7 + *
        if (!pilha.isEmpty()) { // 5*((9+3)*4*2+7)
                                // ( ( 7 + ( ( 2 * 4 ) * ( 3 + 9 ) * 5 )
            String firstElement = pilha.unstack().getValue();

            if (firstElement.equals("+") ||
                    firstElement.equals("-") ||
                    firstElement.equals("*") ||
                    firstElement.equals("/")) {

                fila.push(new Item("("));
                unstackPushQueue(pilha);
                fila.push(new Item(firstElement));
                unstackPushQueue(pilha);
                fila.push(new Item(")"));
            } else {

                fila.push(new Item(firstElement));

            }

        }
    }
}
