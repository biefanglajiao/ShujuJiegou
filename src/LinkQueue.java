/***
 * 使用链表实现队列（循坏链表）
 * 🕐question：固定长度链表  size固定？
 *
 * @param <E>
 */
public class LinkQueue<E> extends AbstractQueue<E> {
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

    private Node<E> header = new Node<>(null);//初始化链表
    private int size = 3;//定义链表的长度;因为第一个为空 所以只能装两个

    private int head = 0, tail = 0;//队首，队尾下标

    /*****
     * 循环链表  ☠️关键是用好循坏的条件！！！！
     * @param e 元素
     */
    @Override
    public void offer(E e) {
        Node<E> node = header;
        if ((tail + 1) % size == 0) {
            for (int i = 0; i == size; i++) header = node.next;//使链表循坏
        }
        if (head == (tail + 1) % size) return;
        for (int i = 0; i < tail % size; i++) node = node.next;//找到插入位置
        node.next = new Node<>(e);
        tail = (tail + 1) % size;

    }

    @Override
    public E poll() {
        Node<E> node = header;
        for (int i = 0; i < head; i++) node = node.next;//找到出队位置
        E e = (E) node.e;
        head = (head + 1) % size;
        return e;
    }
}
