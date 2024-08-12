public class Recursao {
    Stack pilha;
    Queue fila;
    String signal;

    public Recursao(Stack pilha) {
        this.pilha = pilha;
        this.fila = new Queue();
        this.signal = null;
    }

    public void unstackPushQueue(Stack pilha) {
        if (!pilha.isEmpty()) {
            String firstElement = pilha.unstack().getValue();

            if (firstElement.equals("+") ||
                    firstElement.equals("-") ||
                    firstElement.equals("*") ||
                    firstElement.equals("/")) {

                fila.push(new Item("("));
                unstackPushQueue(pilha);
                fila.push(new Item(firstElement));
                unstackPushQueue(pilha);

            }else{
                if(fila.getBehindItem().getValue().equals("+") ||
                fila.getBehindItem().getValue().equals("-") ||
                fila.getBehindItem().getValue().equals("*") ||
                fila.getBehindItem().getValue().equals("/")){
                    fila.push(new Item(firstElement));
                    fila.push(new Item(")"));
                }else{
                    fila.push(new Item(firstElement));
                }   
               
            }

        }
    }
}

//5*((9+3)*4*2+7)=515