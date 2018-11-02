

package my.algo.solution;


import java.util.ArrayList;
import java.util.List;


public class BSTSort {
    public void BSTSort(int array[]) {

        Node rootNode = createBST(array);
        List<Integer> sortedList = new ArrayList<Integer>();
        inOrderTraversal(sortedList, rootNode);
        System.out.println("BST Sorted Array : " + sortedList);
    }

    public void inOrderTraversal(List<Integer> list, Node node) {

        if (node == null) {
            return;
        }
        inOrderTraversal(list, node.left);
        list.add(node.key);
        inOrderTraversal(list, node.right);
    }

    public Node createBST(int array[]) {
        Node rootNode = null;
        if (array.length > 0) {
            rootNode = new Node(array[0]);
            for (int i = 1; i < array.length; i++) {
                addNode(rootNode, array[i]);
            }
        }
        return rootNode;
    }

    public Node addNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key <= node.key) {
            node.left = addNode(node.left, key);
        }
        else if (key > node.key) {
            node.right = addNode(node.right, key);
        }
        return node;
    }
    
    public static void main(String ...args) {
        int array[] = getArray(10);
        new BSTSort().BSTSort(array);        
    }
}


class Node {
    int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
    }
}

