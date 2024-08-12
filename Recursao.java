public class Recursao {
    Stack enterStack;
    Stack convertedStack;
    Queue convertedQueue;
    String signal;

    public Recursao(Stack enterStack) {
        this.enterStack = enterStack;
        this.convertedStack = new Stack();
        this.signal = null;
    }

    public Recursao unstackPushQueue(Stack pilha) {
        if (pilha.isEmpty()) {
            return null;
        }

        String firstElement = pilha.unstack().getValue();

        if (
            firstElement.equals("+") || 
            firstElement.equals("-") || 
            firstElement.equals("*") || 
            firstElement.equals("/")
        ) {

            this.lastSignal = this.signalAux;

            if (this.signal == null) {
                this.signal = firstElement;
            }

            this.signalAux = firstElement;
            return unstackPushQueue(pilha);
        } else {
            fila.push(new Item(firstElement));
            
            if (this.signal != null) {

                if (pilha.isEmpty()) {
                    return null;
                } else {
                    if (this.lastSignal != null && !this.lastSignal.equals(this.signalAux)) {

                        System.out.println("A " + firstElement + " " + this.signalAux);
                        fila.push(new Item(this.signalAux));
                        fila.push(new Item(")")); 
                        
                        this.signalAux = this.lastSignal;
                        this.signal = null;

                    } else {
                        System.out.println("B " + firstElement + " " + this.signalAux);
                        fila.push(new Item(this.signalAux));
                        this.signalAux = this.signal;
                        this.signal = null;
                    }
                }
            } else {
                if (pilha.isEmpty()) {
                    return null;
                } else {
                    System.out.println("C " + firstElement + " " + this.signalAux);
                    fila.push(new Item("(")); 
                    fila.push(new Item(this.signalAux));   
                }
            }

            return unstackPushQueue(pilha);
        }
    }
}
