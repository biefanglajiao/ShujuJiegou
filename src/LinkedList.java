/**
 * 线性表应用之一*链表
 */
public class LinkedList<E> extends AbstractList<E> {
    /*****
     * 就是每一个结点存放一个元素和一个指向下一个结点的引用（C语言里面是指针，Java中就是对象的引用，代表下一个结点对象）
     * 头节点为空
     * @param <E>
     */
    static class Node<E> {
        private E e;//元素  //楼层
        private Node<E> next;  //指向下一个结点的引用//楼梯

        private Node(E e) {//构造方法，给节点赋值
            this.e = e;
        }
    }

    private Node<E> head = new Node<>(null);//初始化链表
    private int size = 0;//定义链表的长度


    @Override
    public int size() {
        return size;
    }

    /*****
     * 安全检查
     * 直接接后继节点，串起来：插入节点前继接到前节点后继，插入节点后继接到后节点的前继
     * @param e     元素
     * @param index 要添加的位置(索引)
     *   ->Aa->Bb->Cc       Dd  ：->Aa->Dd->Bb->Cc
     *  node=A; temp=B;
     *  node.next =D;
     *  node.next,next=temp=B;
     */
    @Override
    public void add(E e, int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("超出顺序表长度");//安全检查
        Node<E> node = head, temp;//这里是创了两个链表，一个存中间值
        for (int i = 0; i < index; i++) node = node.next;//找到插入节点前驱的位置i<index
        temp = node.next;
        node.next = new Node<E>(e);
        node.next.next=temp;
        size++;
    }

    /****
     * 安全检查
     * 将被删除元素的前一节点的后继节点直接接到被删除元素后一节点
     * @param index 位置
     * @return删除的元素
     * ->Aa->Dd->Bb->Cc  Dd  ：->Aa->Bb->Cc
     * node=A; temp=d;
     * node.next=node.next.next=B;
     */
    @Override
    public E remove(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("超出顺序表长度");//安全检查
        Node<E> node = head, temp;//这里是创了两个链表，一个存中间值
        for (int i = 0; i < index; i++) node = node.next;//找到插入节点前驱的位置i<index
        temp=node.next;
        node.next=node.next.next;
        size--;
        return temp.e;
    }

    @Override
    public E get(int index) {
        if (index > size) throw new ArrayIndexOutOfBoundsException("超出顺序表长度");//安全检查
        Node<E> node = head;
        for (int i = 0; i <= index; i++) node = node.next;//找到插入节点前驱的位置i<=index
        return node.e;
    }
}
