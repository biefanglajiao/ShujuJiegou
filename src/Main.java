public class Main {
    public static void main(String[] args){
        /****
         * 顺序表
         */
        ArrayList<String> list =new ArrayList<>();
        list.add("a" ,0);
        list.add("b",0);
        list.remove(0);

        /*****
         * 链表
         */
        LinkedList<String>linkedList=new LinkedList<>();
        linkedList.add("A",0);
        linkedList.add("B",1);
        linkedList.add("C",2);
        linkedList.add("D",1);
        linkedList.remove(1);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.size());
        /****
         *
         *顺序表优缺点：
         *
         * * 访问速度快，随机访问性能高
         * * 插入和删除的效率低下，极端情况下需要变更整个表
         * * 不易扩充，需要复制并重新创建数组
         *
         * 链表优缺点：
         *
         * * 插入和删除效率高，只需要改变连接点的指向即可
         * * 动态扩充容量，无需担心容量问题
         * * 访问元素需要依次寻找，随机访问元素效率低下
         */
    }

}