package my.algo.solution;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    public static int[] getArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        printArray(array);
        return array;
    }

    public static void printArray(int array[]) {
        for (int e : array) {
            System.out.print(e + ",");
        }
        System.out.println("");
        System.out.println("=============");
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
