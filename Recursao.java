public class Recursao {
    Stack enterStack;
    Stack convertedStack;
    Queue convertedQueue;
    String signal;
    String signalAux;
    String lastSignal;

    public Recursao(Stack enterStack) {
        this.enterStack = enterStack;
        this.convertedStack = new Stack();
        this.signal = null;
        this.signalAux = null;
    }

    public void unstackAndStackUp(Stack enterStack) {
        if (!enterStack.isEmpty()) {

            String firstElement = enterStack.unstack().getValue();

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
                unstackAndStackUp(enterStack);
            } else {
                convertedStack.stackUp(firstElement);

                if (this.signal != null) {

                    if (!enterStack.isEmpty()) {

                        if (this.lastSignal != null && !this.lastSignal.equals(this.signalAux)) {
                            convertedStack.stackUp(this.signalAux);
                            this.signalAux = this.lastSignal;
                            this.signal = null;
                        } else {
                            convertedStack.stackUp(this.signalAux);
                            this.signalAux = this.signal;
                            this.signal = null;
                        }
                    }
                } else {
                    if (!enterStack.isEmpty()) {
                        convertedStack.stackUp(this.signalAux);
                    }
                }

                unstackAndStackUp(enterStack);
            }
        }
    }
}