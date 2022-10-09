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
    }

}