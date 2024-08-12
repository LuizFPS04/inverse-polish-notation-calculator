public class Queue {
    private Item frontItem;
    private Item behindItem;

    Queue() {
        this.frontItem = new Item("-1");
        this.behindItem = this.frontItem;
        this.frontItem.setNext(null);
    }

    public boolean isEmpty() {
        return this.frontItem == this.behindItem;
    }

    public void push(Item item) {
        this.behindItem.setNext(item);
        this.behindItem = this.behindItem.getNext();
        this.behindItem.setNext(null);
    }

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

    public void print() {
        if (isEmpty()) {
            System.out.println("there are no elements in the stack");
        } else {
            Item queueAux = frontItem.getNext();
            while (queueAux != null) {
                System.out.print(queueAux.getValue() + " ");
                queueAux = queueAux.getNext();
            }
        }
    }

    public Item getBehindItem(){
        return behindItem;
    }
}