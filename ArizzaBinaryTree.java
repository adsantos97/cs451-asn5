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

class BinaryTree
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

    return current;
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
   * purpose: inorder traversal of the tree
   * input: node
   * return: nothing - prints out inorder
   */
  public void inorder(Node node)
  {
    if (node != null)
    {
      inorder(node.left);
      System.out.print(" " + node.num);
      inorder(node.right);
    }
  }

  // runs inorder() with root node
  public void printInorder()
  {
    inorder(root);
  }

  /*
   * purpose: preorder traversal of the tree
   * input: node
   * return: nothing - prints out preorder
   */
  public void preorder(Node node)
  {
    if (node != null)
    {
      System.out.print(" " + node.num);
      preorder(node.left);
      preorder(node.right);
    }
  }

  // runs preorder() with root node
  public void printPreorder()
  {
    preorder(root);
  }

  /*
   * purpose: postorder traversal of the tree
   * input: node
   * return: nothing - prints out postorder
   */
  public void postorder(Node node)
  {
    if (node != null)
    {
      postorder(node.left);
      postorder(node.right);
      System.out.print(" " + node.num);
    }
  }

  // runs postorder() with root node
  public void printPostorder()
  {
    postorder(root);
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
    bt.printInorder();
    System.out.println();
    System.out.println("Preorder: ");
    bt.printPreorder();
    System.out.println();
    System.out.println("Postorder: ");
    bt.printPostorder();
    System.out.println();
  }

}
