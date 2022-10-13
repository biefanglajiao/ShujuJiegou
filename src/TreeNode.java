public class TreeNode<E> {
    public E e;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E e) {
        this.e = e;
    }

    //* **前序遍历**：从二叉树的根结点出发，到达结点时就直接输出结点数据，按照先向左在向右的方向访问。ABCDEF
    public void QianxuBianli(TreeNode<E> node){
        if (node==null)return;
        System.out.print(node.e);
        QianxuBianli(node.left);
        QianxuBianli(node.right);
    }
    //* **中序遍历**：从二叉树的根结点出发，优先输出左子树的节点的数据，再输出当前节点本身，最后才是右子树。CBDAEF
    public void ZhongxuBianli(TreeNode<E> node){
        if (node==null)return;
        ZhongxuBianli(node.left);
        System.out.print(node.e);
        ZhongxuBianli(node.right);
    }

    //* **后序遍历**：从二叉树的根结点出发，优先遍历其左子树，再遍历右子树，最后在输出当前节点本身。CDBFEA
    public void  HouxuBianli(TreeNode<E> node){
        if (node==null)return;
        HouxuBianli(node.left);
        HouxuBianli(node.right);
        System.out.print(node.e);
    }
}
