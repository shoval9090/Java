package HW_shoval;

public class Node <T> {

    public T data;
    public Node <T> next;
    public Node prev;
    public int index;


    public Node ( T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node(T data,int index ){
        this.data = data;
        this.index = index;
        this.prev = null;
        this.next = null;
    }

    public String toString(){
        String str = next == null ? "": next.toString();
        String result = data.toString() + " , " + str;
        return result;
    }
}
