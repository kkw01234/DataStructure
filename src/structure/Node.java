package structure;

public class Node<E> {
    private E data; //데이터
    private Node<E> next; //뒤쪽 포인터

    public Node(E e, Node<E> next){
        this.data = e;
        this.next = next;
    }


    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
