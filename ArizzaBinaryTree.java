//package asn5;

class Node
{
  protected int num;
  protected Node left, right;

  // constructor
  Node(int num)
  {
    this.num = num;
    right = null;
    left = null;
  }
}

public class BinaryTree
{
  protected Node root;

  /*
   * purpose: recursively add a new integer (new node) to the tree
   * input: current - the current node
   *        num - integer being added 
   * return: node
   */
  private Node insertRecursive(Node current, int num)
  {
    // check if root node doesn't exists
    if (current == null)
    {
      return new Node(num);
    }

    if (num < current.num)
    {
      current.left = insertRecursive(current.left, num);
    }
    else if (num > current.num)
    {
      current.right = insertRecursive(current.right, num);
    }
    else // num already exists in tree
    {
      return current;
    }
  }

  /*
   * purpose: starts recursion at node
   * input: num - integer being added
   * return: nothing - adds a num in the tree
   */
  public void insert(int num)
  {
    root = insertRecursive(root, num);
  }

  /*
   * purpose: print the tree in inorder
   * input: node
   * return: nothing - prints out inorder
   */
  public void printInorder()
  {
    if (root != null)
    {
      printInorder(root.left);
      System.out.print(" " + root.num);
      printInorder(root.right);
    }
  }

  /*
   * purpose: print the tree in preorder
   * input: node
   * return: nothing - prints out preorder
   */
  public void printPreorder()
  {
    if (root != null)
    {
      System.out.print(" " + root.num);
      printPreorder(root.left);
      printPreorder(root.right);
    }
  }

  /*
   * purpose: print the tree in postorder
   * input: node
   * return: nothing - prints out postorder
   */
  public void printPostorder()
  {
    if (root != null)
    {
      printPostorder(root.left);
      printPostorder(root.right);
      System.out.print(" " + root.num);
    }
  }

}

public class ArizzaBinaryTree
{ 
  /**
   * purpose: test code
   */
  public static void main(String[] args)
  {
    System.out.println("Binary Tree!");
    
    BinaryTree bt = new BinaryTree();
    
    bt.add(3);
    bt.add(2);
    bt.add(4);
    bt.add(1);
    bt.add(5);

    System.out.println("Inorder: ");
    bt.printInorder();
    System.out.println("Preorder: ");
    bt.printPreorder();
    System.out.println("Postorder: ");
    bt.printPostOrder();
  }

}
