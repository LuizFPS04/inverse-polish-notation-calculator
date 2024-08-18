/**
 * Classe responsável por converter uma expressão em notação polonesa inversa
 * para uma expressão
 * convencional usando uma pilha e uma fila.
 */
public class Converter {
    private Stack convertedStack;
    private Queue convertedQueue;

    /**
     * Construtor da classe {@link Converter}.
     * 
     * @param enterStack A pilha contendo a expressão em notação polonesa inversa a
     *                   ser convertida.
     */
    public Converter() {
        this.convertedStack = new Stack();
        this.convertedQueue = new Queue();
    }

    /**
     * Converte a expressão da pilha fornecida para uma expressão infixa usando
     * recursão.
     * 
     * @param enterStack A pilha contendo a expressão a ser convertida.
     */
    public void unstackAndStackUp(Stack enterStack) {
        if (!enterStack.isEmpty()) {
            String unstackElement = enterStack.unstack().getValue();

            if (unstackElement.equals("+") ||
                    unstackElement.equals("-") ||
                    unstackElement.equals("*") ||
                    unstackElement.equals("/")) {
                convertedStack.stackUp(")");
                unstackAndStackUp(enterStack);
                convertedStack.stackUp(unstackElement);
                unstackAndStackUp(enterStack);
                convertedStack.stackUp("(");
            } else {
                convertedStack.stackUp(unstackElement);
            }
        }
    }

    /**
     * Remove os elementos da pilha convertida e os insere na fila.
     */
    public void unstackPushQueue() {
        if (!this.convertedStack.isEmpty()) {
            String unstackElement = this.convertedStack.unstack().getValue();
            convertedQueue.push(new Item(unstackElement));
            unstackPushQueue();
        }
    }

    /**
     * Imprime a expressão convertida e o resultado da conversão.
     * 
     * @param result O resultado do cálculo da conversão da expressão.
     */
    public void printExpression(String result) {
        String expression = "";
        while (!this.convertedQueue.isEmpty()) {
            String value = this.convertedQueue.pop().getValue();
            expression += value;
        }
        System.out.println(expression + " = " + result);
    }
}