public class LinkedListDeque<T> {
    public int size=0;
    private class IntNode {
        public T first;
        public IntNode next;
        public IntNode prev;
       /* public IntNode() {
            first = null;
            next = null;
        }*/
        public IntNode(T item, IntNode p, IntNode n) {
            first=item;
            next=p;
            prev=n;
        }
    }
    public IntNode sentinel ;
    //构造函数不可以带void
    public  LinkedListDeque(){
        sentinel=new IntNode(null, null, null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;

    }


    public void addFirst(T t) {
            IntNode s=new IntNode(t,sentinel.next,sentinel);
            sentinel.next.prev=s;
            sentinel.next = s;
            size+=1;
        }
    public void addLast(T t) {
            IntNode s=new IntNode(t,sentinel,sentinel.prev);
            sentinel.prev.next=s;
            sentinel.prev = s;
            size+=1;
        }
    public boolean isEmpty() {
        return size==0;
    }

    public int size(){
        return size;
    }
    public void printDeque() {
        IntNode p = sentinel;
        while(p.next!=sentinel){
            p=p.next;
            System.out.print(p.first+" ");
        }
    }
    public T    removeFirst() {
        if(sentinel==sentinel.next) {
            return null;
        }else {T x = sentinel.next.first;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size-=1;
            return x;
        }
    }
    public T    removeLast() {
        if(sentinel==sentinel.prev) {
            return null;
        }else {T x = sentinel.prev.first;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev=sentinel.prev.prev;
        size-=1;
        return x;}
    }
    public T get(int index) {
        if(size<=index) {
            return null;
        }else{
            IntNode p=sentinel.next;
            int num=0;
            while(num!=index){
                p=p.next;
                num++;
            }
            return p.first;

        }
    }


    public static void main (String[] args) {
        LinkedListDeque <Integer>list = new LinkedListDeque();
        list.addFirst(4);
        list.addLast(3);
        System.out.println(list.get(1));
    }
}
