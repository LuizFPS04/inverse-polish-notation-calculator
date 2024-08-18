/**
 * Classe responsável por processar operações aritméticas em notação polonesa
 * inversa e armazenar
 * os resultados na pilha.
 */
public class Result {
    private Stack resultStack;

    /**
     * Construtor da classe {@link Result}.
     * Inicializa a pilha onde os resultados das operações serão armazenados.
     */
    public Result() {
        this.resultStack = new Stack();
    }

    /**
     * Processa uma instrução aritmética e atualiza a pilha de resultados com o
     * resultado da operação.
     * 
     * @param instruction A instrução a ser processada, que pode ser um operador
     *                    aritmético (+, -, *, /) ou um operando.
     * @throws ArithmeticException Se a instrução for uma divisão por zero.
     */
    public void proccessInstrucion(String instruction) {
        if (instruction.equals("+")) {
            int num2 = Integer.parseInt(resultStack.unstack().getValue());
            int num1 = Integer.parseInt(resultStack.unstack().getValue());
            String result = Integer.toString(num1 + num2);
            resultStack.stackUp(result);
        } else if (instruction.equals("-")) {
            int num2 = Integer.parseInt(resultStack.unstack().getValue());
            int num1 = Integer.parseInt(resultStack.unstack().getValue());
            String result = Integer.toString(num1 - num2);
            resultStack.stackUp(result);
        } else if (instruction.equals("*")) {
            int num2 = Integer.parseInt(resultStack.unstack().getValue());
            int num1 = Integer.parseInt(resultStack.unstack().getValue());
            String result = Integer.toString(num1 * num2);
            resultStack.stackUp(result);
        } else if (instruction.equals("/")) {
            int num2 = Integer.parseInt(resultStack.unstack().getValue());
            int num1 = Integer.parseInt(resultStack.unstack().getValue());
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero not allowed");
            }
            String result = Integer.toString(num1 / num2);
            resultStack.stackUp(result);
        } else {
            resultStack.stackUp(instruction);
        }
    }

    /**
     * Retorna o resultado da pilha de resultados.
     * 
     * @return O resultado da operação armazenado na pilha.
     */
    public String printResult() {
        return resultStack.unstack().getValue();
    }
}