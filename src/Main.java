import structure.RingQueue;
import structure.tree.BinTree;
import sun.awt.image.IntegerComponentRaster;

import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Main main = new Main();
        System.out.println("1. RingQueueTest 2. ListQueueTest 3. BinaryTreeTest");
        int number = scanner.nextInt();
        switch (number){
            case 1:
                main.RingQueueTest();
                break;
            case 2:
                break;
            case 3:
                main.BinaryTreeTest();
                break;

        }

    }


    public void RingQueueTest(){
        RingQueue<Integer> ringQueue = new RingQueue<>(Integer.class, 10);
        while(true) {
            System.out.println("1. enQueue 2. Dequeue 3. peek 4.is_full 5. is_empty");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("값 넣기 :");
                    ringQueue.enqueue(scanner.nextInt());
                    break;
                case 2:
                    System.out.println(ringQueue.dequeue());
                    break;
                case 3:
                    System.out.println(ringQueue.peek());
                    break;
                case 4:
                    if (ringQueue.is_full()) {
                        System.out.println("가득 참");
                    } else {
                        System.out.println("아직 남음");
                    }
                    break;
                case 5:
                    if (ringQueue.is_empty()) {
                        System.out.println("비어있음");
                    } else {
                        System.out.println("");
                    }
                    break;
                default:
                    return;
            }
        }
    }

    public void BinaryTreeTest(){
        BinTree<Integer, String> tree = new BinTree<>();

        while(true){
            System.out.println("1. search 2. add 3. remove 4. print");
            int number = scanner.nextInt();
            switch (number){
                case 1:
                    System.out.println("탐색할 Key값");
                    try {
                        String result = tree.search(scanner.nextInt());
                        System.out.println(result);
                    }catch(Exception e){
                        System.out.println("NOT FOUND");
                    }

                    break;
                case 2:
                    System.out.println("Key Value 순서대로 입력");
                    tree.add(scanner.nextInt(), scanner.next());
                    break;
                case 3:
                    System.out.println("삭제할 키 입력");
                    tree.remove(scanner.nextInt());
                    break;
                case 4:
                    tree.print();
                    break;
                default:
                    return;
            }

        }
    }
}
