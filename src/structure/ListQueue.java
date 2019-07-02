package structure;

public class ListQueue<E> implements InQueue<E>{
    private int front; //첫번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터의 수

    private Node<E> head;
    private Node<E> crnt;


    public ListQueue(){
        head = crnt = null;
    }

    @Override
    public E enqueue(E e) {
        if(is_empty()){
            head = crnt = new Node<E>(e, head);

        }else{
            Node<E> ptr = head;
            while(ptr.getNext() != null){
                ptr = ptr.getNext();
            }
            
        }
        return null; //아직 작업중
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public boolean is_empty() {
        return false;
    }

    @Override
    public boolean is_full() { //가득차지 않음
        return false;
    }

    @Override
    public E peek() {
        return null;
    }





}

