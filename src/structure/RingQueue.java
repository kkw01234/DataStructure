package structure;


import java.io.Serializable;
import java.lang.reflect.Array;

public class RingQueue<E> implements InQueue<E>{
    private int max; // Queue 용량
    private int front; //첫번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터의 수
    private E[] que;
    /*
    public class EmptyQueueException extends RuntimeException{
        public EmptyQueueException(){
            System.err.println("큐가 비어있음");
        }
    }
    public class OverflowQueueException extends  RuntimeException{
        public OverflowQueueException(){
            System.err.println("큐가 가득 참");
        }
    }
    */
    public RingQueue(Class<E> clazz,int capacity){ //Queue 의 생성자
        num = front = rear = 0;
        max = capacity;
        try{
            que = (E[]) Array.newInstance(clazz, capacity);
        }catch(OutOfMemoryError e){
            e.printStackTrace();
        }
    }

    public E enqueue(E e){ //큐의 뒤에 요소 추가
        if(is_full()){
            System.err.println("큐가 가득참");
            return null;
        }

        que[rear++] = e;
        num++;
        if(rear == max){
            rear = 0;
        }
        return e;
    }

    public E dequeue(){ // 큐 맨 앞의 요소 반환 후 삭제
        if(is_empty()){
            System.err.println("큐가 비어있음");
            return null;
        }
        E e = que[front++];
        num--;
        if(front == max){
            front = 0;
        }
        return e;
    }

    public boolean is_empty(){ //큐가 비어있는지 확인

        if(num <= 0)
            return true;
        else
            return false;
    }
    public boolean is_full(){ // 큐가 가득 차있는지 확인

        if(num == max)
            return true;
        else
            return  false;
    }
    public E peek(){ //Queue 에서 삭제하지 않고 앞에 있는 요소 반환
        if(is_empty()){
            System.err.println("큐가 비어있음");
            return null;
        }
        return que[front];
    }


}
