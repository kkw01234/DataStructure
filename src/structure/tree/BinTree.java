package structure.tree;


import java.util.Comparator;
import java.lang.Comparable;

public class BinTree<K, V> { //이진트리
    private TreeNode<K,V> root;
    private Comparator<? super K> comparator = null;
    private int count=0 ;
    public BinTree(){
        root = null;
    }
    public BinTree(Comparator<? super K> c){
        this();
        this.comparator = c;
    }

    public int comp(K key1, K key2) {
        return (comparator != null) ? comparator.compare(key1, key2) :
                ((Comparable<K>) key1).compareTo(key2);
    }
    public int getCount(){
        return count;
    }


    public V search(K key) { //트리 탐색
        TreeNode<K, V> t = root;
        while (true) {
            if (t == null) {
                return null;
            }
            int cond = comp(key, t.getKey());
            if (cond == 0) {
                return t.getValue();
            } else if (cond < 0) {
                t = t.getLeft();
            } else
                t = t.getRight();
        }
    }
    private void addNode(TreeNode<K, V> node, K key, V value){ //트리 추가
            //1.root 부터 value 비교
        int cond = comp(key, node.getKey());
        if(cond == 0){
            //같을경우 삽입하지 않음
            return;
        }else if(cond < 0){
            //작을 경우
            if(node.getLeft() == null){
                node.setLeft(new TreeNode<>(key,value,null,null));
                count++;
            }else{
                addNode(node.getLeft(),key,value);
            }
        }else {//cond > 0
            //클 경우
            if(node.getRight() == null){
                node.setRight(new TreeNode<>(key,value,null,null));
                count++;
            }else{
                addNode(node.getRight(),key,value);
            }
        }
    }
    public void add(K key, V value){
        if(root == null){
            root = new TreeNode<>(key, value, null, null);
        }else
            addNode(root, key, value);
    }

    public boolean remove(K key){
        //1. 자식노드가 없을 경우 2. 자식노드가 1개일 경우 3. 자식노드가 2개일 경우
        TreeNode<K, V> t = root;
        TreeNode<K, V> parent = null;
        while(true){ //탐색과정
            if(t == null)
                return false;
            int cond = comp(key, t.getKey());
            if(cond == 0){
                break;
            }else{
                parent = t;
                if(cond < 0){
                    t = t.getLeft();
                }else
                    t = t.getRight();
            }
        }

        if(t.getLeft() == null && t.getRight() == null){//모두 없는경우
            if(parent != null){
                if(parent.getLeft() == t){
                    parent.setLeft(null);
                }else
                    parent.setRight(null);
            }else
                root = null;
        }else if(t.getLeft() ==null || t.getRight() == null){//하나의 자식만 가지는 경우
            TreeNode<K, V> child = t.getLeft() ==null ? t.getLeft(): t.getRight();
            if(parent != null){
                if(parent.getLeft() == t){
                    parent.setLeft(child);
                }else
                    parent.setRight(child);
            }else
                root = null;
            return true;
        }else{ // 두명의 자식을 가지는 경우 (오른쪽에서 최솟값 찾기 시행)
            TreeNode<K, V> p = t;
            TreeNode<K, V> succ = t.getRight();
            while(succ.getLeft() != null){
                p = succ;
                succ = succ.getLeft();
            }
            if(p.getLeft() == succ){
                p.setLeft(p.getRight());
            }else
                p.setRight(p.getRight());
            t.setKey(succ.getKey());
            t = succ;

            return true;
        }

       return false;
    }

    public void print(){
        printSubTree(root);
    }
    private void printSubTree(TreeNode node){
        if(node != null){
            printSubTree(node.getLeft());
            System.out.println("KEY : "+node.getKey()+" Value :"+node.getValue());
            printSubTree(node.getRight());
        }
    }
}


//Comparable => 정렬 수행 시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의하는 인터페이스
//COmparator => 정렬 가능한 클래스들의 기본 정렬 기준과 다르게 정렬하기 싶을 때 사용