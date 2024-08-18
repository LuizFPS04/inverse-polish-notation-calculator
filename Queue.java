/**
 * Classe que representa uma fila.
 */
public class Queue {
    private Item frontItem;
    private Item behindItem;

    /**
     * Construtor da classe {@link Queue}.
     * Inicializa a fila com um item (-1) como o item da frente e define o item de
     * trás como o mesmo item.
     * O item da frente não aponta para nenhum item.
     */
    Queue() {
        this.frontItem = new Item("-1");
        this.behindItem = this.frontItem;
        this.frontItem.setNext(null);
    }

    /**
     * Verifica se a fila está vazia.
     * 
     * @return {@code true} se a fila estiver vazia; {@code false} caso contrário.
     */
    public boolean isEmpty() {
        return this.frontItem == this.behindItem;
    }

    /**
     * Insere um item no final da fila.
     * 
     * @param item O item a ser inserido na fila.
     */
    public void push(Item item) {
        this.behindItem.setNext(item);
        this.behindItem = this.behindItem.getNext();
        this.behindItem.setNext(null);
    }

    /**
     * Remove e retorna o item do início da fila.
     * 
     * @return O item removido da frente da fila; {@code null} se a fila estiver
     *         vazia.
     */
    public Item pop() {
        if (isEmpty()) {
            System.out.println("Error - Queue is empty.");
            return null;
        }

        Item itemAux = this.frontItem.getNext();

        // Move o frontItem para o próximo na fila
        this.frontItem.setNext(itemAux.getNext());

        // Se o behindItem era o mesmo que itemAux, precisamos ajustar
        if (this.behindItem == itemAux) {
            this.behindItem = this.frontItem;
        }

        return itemAux;
    }

    /**
     * Imprime todos os itens na fila, do início ao fim.
     * Se a fila estiver vazia, exibe uma mensagem informando que não há elementos.
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("There are no elements in the queue");
        } else {
            Item queueAux = frontItem.getNext();
            while (queueAux != null) {
                System.out.print(queueAux.getValue() + " ");
                queueAux = queueAux.getNext();
            }
            System.out.println(); // Adiciona uma nova linha após imprimir a fila
        }
    }

    /**
     * Retorna o item que está no final da fila.
     * 
     * @return O item que está no final da fila.
     */
    public Item getBehindItem() {
        return behindItem;
    }
}