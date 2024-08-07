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
        Item itemAux = null;

        if (isEmpty()) {
            System.out.println("Error - Queue is empty.");
        }

        itemAux = this.frontItem.getNext();
        this.frontItem.setNext(this.frontItem.getNext());
        this.frontItem.setNext(null);

        if (this.behindItem == itemAux) {
            this.behindItem = this.frontItem;
        }

        return itemAux;
    }
}
