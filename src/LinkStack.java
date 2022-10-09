/***8
 * 用链表实现栈操作
 * @param <E>
 */
public class LinkStack <E>extends AbstractStack<E>{
    /***
     * 初始化定义链表结构
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
    public E pop() {
        Node<E>  node=head;//应用初始化的链表
        for (int i = 0; i < size; i++) node=node.next;//找到插入节点前驱的位置i<index
        size--;
        return node.e;
    }

    @Override
    public void push(E e) {
        Node<E>  node=head;//应用初始化的链表
        for (int i = 0; i < size; i++) node=node.next;//找到插入节点前驱的位置i<index
        node.next=new Node<>(e);
        size++;
    }
}
