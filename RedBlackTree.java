

class node {

  node left, right;
  int data;

  boolean color;

  node(int data) {
    this.data = data;
    left = null;
    right = null;

    color = true;
  }
}

public class RedBlackTree {

  node turnLeft(node myNode) {
    System.out.printf("поворот влево!!\n");
    node child = myNode.right;
    node childLeft = child.left;

    child.left = myNode;
    myNode.right = childLeft;

    return child;
  }

  
  node turnRight(node myNode) {
    System.out.printf("поворот вправо\n");
    node child = myNode.left;
    node childRight = child.right;

    child.right = myNode;
    myNode.left = childRight;

    return child;
  }

  boolean isRed(node myNode) {
    if (myNode == null) {
      return false;
    }
    return (myNode.color == true);
  }

  void swapColors(node node1, node node2) {
    boolean temp = node1.color;
    node1.color = node2.color;
    node2.color = temp;
  }

  node insert(node myNode, int data) {
    if (myNode == null) {
      return new node(data);
    }
    if (data < myNode.data) {
      myNode.left = insert(myNode.left, data);
    } else if (data > myNode.data) {
      myNode.right = insert(myNode.right, data);
    } else {
      return myNode;
    }

    if (isRed(myNode.right) && !isRed(myNode.left)) {
      myNode = turnLeft(myNode);
      swapColors(myNode, myNode.left);
    }

    if (isRed(myNode.left) && isRed(myNode.left.left)) {
      myNode = turnRight(myNode);
      swapColors(myNode, myNode.right);
    }

    if (isRed(myNode.left) && isRed(myNode.right)) {
      myNode.color = !myNode.color;

      myNode.left.color = false;
      myNode.right.color = false;
    }
    return myNode;
  }

  void inorder(node node) {
    if (node != null)
    {
      inorder(node.left);
      char c = '●';
      if (node.color == false)
        c = '◯';
      System.out.print(node.data + ""+c+" ");
      inorder(node.right);
    }
  }
}