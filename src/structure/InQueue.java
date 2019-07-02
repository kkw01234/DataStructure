package structure;

public interface InQueue<E> {
    public E enqueue(E e);
    public E dequeue();
    public boolean is_empty();
    public boolean is_full();
    public E peek();

}
