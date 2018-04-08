class Node
{
  // instance variables
  protected int num;
  protected Node left, right;

  // constructor
  public Node(int num)
  {
    this.num = num;
    right = null;
    left = null;
  }

  // setter and getter for num of node
  public void setNum(int num) { this.num = num; }
  public int getNum() { return num; }

  // setter and getter for left of node
  public void setLeft(Node left) { this.left = left; }
  public Node getLeft() { return left; }

  // setter and getter for right of node
  public void setRight(Node right) { this.right = right; }
  public Node getRight() { return right; }

  /*
   * purpose: insert a number
   * input: n - number to insert
   * return: true if number was inserted, false otherwise
   */
  public boolean insert(int n)
  {
    if (n == num)
      return true;

    if (n < num)
    {
      if (left == null)
        left = new Node(n);
      else
        return left.insert(n);
    }
    else
    {
      if (right == null)
        right = new Node(n);
      else
        return right.insert(n);
    }
     
    return false;
  }

  public String preorder() { return " " + num + " "; }
  public String inorder() { return " " + num + " "; }
  public String postorder() { return " " + num + " "; }

}

class BinaryTree
{
  protected Node root;
  protected BinaryTree left;
  protected BinaryTree right;

  // constructor
  public BinaryTree()
  { 
    root = null;
    left = right = null; 
  }

  public BinaryTree(Node n)
  {
    root = n;
  }

  /*
   * purpose: insert a number starting from root
   * input: n - number to insert
   * return: true if number was inserted, false otherwise
   */
  public boolean insert(int n)
  {
    if (root == null)
    {
      root = new Node(n);
      return true;
    }
    
    if (left == null)
    {
      left = new BinaryTree();
    }
    else
    {
      return left.insert(n);
    }

    if (right == null)
    {
      right = new BinaryTree();
    }
    else
    {
      return right.insert(n);
    }

    return false;
  }

  public String inorder()
  {
    return left.inorder() + root.getNum() 
           + right.inorder();
  }

  public String preorder()
  {
    return root.getNum() + left.preorder() 
           + right.preorder();
  }

  public String postorder()
  {
    return left.postorder() + right.postorder()
           + root.getNum();
  }

}

public class ArizzaTree
{ 
  /**
   * purpose: test code
   */
  public static void main(String[] args)
  {
    System.out.println("Binary Tree!");
    
    BinaryTree bt = new BinaryTree();
    
    bt.insert(7);
    bt.insert(1);
    bt.insert(9);
    bt.insert(0);
    bt.insert(3);
    bt.insert(8);
    bt.insert(10);
    bt.insert(2);
    bt.insert(5);
    bt.insert(4);
    bt.insert(6);
  
    System.out.println("Inorder: ");
    System.out.println(bt.inorder());
    System.out.println("Preorder: ");
    System.out.println(bt.preorder());
    System.out.println("Postorder: ");
    System.out.println(bt.postorder());
  }

}
