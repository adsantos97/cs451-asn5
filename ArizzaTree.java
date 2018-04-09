class Node
{
  // instance variables
  protected int num;
  protected BinaryTree left, right;

  // constructor
  public Node(int num)
  {
    this.num = num;
    right = new BinaryTree();
    left = new BinaryTree();
  }

  // setter and getter for num of node
  public void setNum(int num) { this.num = num; }
  public int getNum() { return num; }

  // setter and getter for left of node
  public void setLeftChild(BinaryTree l) { left = l; }
  public BinaryTree getLeftChild() { return left; }

  // setter and getter for right of node
  public void setRightChild(BinaryTree r) { right = r; }
  public BinaryTree getRightChild() { return right; }

  /*
   * purpose: insert a number
   * input: n - number to insert
   * return: true if number was inserted, false otherwise
   */
/*  public boolean insert(int n)
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
*/
/*
  public String preorder() { return " " + num + " "; }
  public String inorder() { return " " + num + " "; }
  public String postorder() { return " " + num + " "; }
*/
  public String toString()
  {
    return " " + num;
  }
}

class BinaryTree
{
  protected Node root;
  //protected BinaryTree left;
  //protected BinaryTree right;

  // constructor
  public BinaryTree()
  { 
    root = null;
    //left = right = null; 
  }
  
  // parameterized constructor
  public BinaryTree(Node n)
  {
    root = n;
  }

  public Node getRoot()
  {
    return root;
  }

  public BinaryTree getLeft()
  {
    BinaryTree t = root.getLeftChild();
    return t;
  }

  public BinaryTree getRight()
  {
    BinaryTree t = root.getRightChild();
    return t;
  }

  public boolean emptyTree()
  {
    return (root == null);
  }

  /*
   * purpose: insert a number starting from root
   * input: n - number to insert
   * return: true if number was inserted, false otherwise
   */
  public boolean insert(int n)
  {
    Node nd = new Node(n);
    if (root == null)
    {
      root = nd;
      return true;
    }  
    else if (n < root.getNum())
    {
      if (root.getLeftChild().emptyTree())
      {
        root.setLeftChild(new BinaryTree(nd));
      }
      else
      {
        return root.getLeftChild().insert(n);
      }
    }
    else
    {
      if (root.getRightChild().emptyTree())
      {
        root.setRightChild(new BinaryTree(nd));
      }
      else
      {
        return root.getRightChild().insert(n);
      }
    }

    return false;  
  }

  public String toString()
  {
    if (root == null)
      return " ";
    else
      return root.getNum() + " ";//+ " ( " + getLeft().toString() + " ) ( " 
             //+ getRight().toString() + " )";
  }

  public String inorder()
  {
    return getLeft().inorder().toString() + " " + root.getNum();
  }

/*
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
*/
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
/*    bt.insert(2);
    bt.insert(5);
    bt.insert(4);
    bt.insert(6);
*/  
    System.out.println("Inorder: ");
    System.out.println(bt.inorder());
/*
    System.out.println("Preorder: ");
    System.out.println(bt.preorder());
    System.out.println("Postorder: ");
    System.out.println(bt.postorder());
*/
  }

}
