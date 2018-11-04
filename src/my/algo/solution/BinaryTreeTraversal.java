

package my.algo.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeTraversal {

    public BTNode addBTreeNode(BTNode currentNode, int value) {

        if (currentNode == null) {
            currentNode = new BTNode(value);
        }
        if (value < currentNode.value) {
            currentNode.left = addBTreeNode(currentNode.left, value);
        }
        else if (value > currentNode.value) {
            currentNode.right = addBTreeNode(currentNode.right, value);
        }
        else {
            return currentNode;
        }
        return currentNode;
    }
    
    public BTNode createBTree() {
        
        BTNode root = new BTNode(6);
        Arrays.stream(new int[]{3,8,2,4,7,9,1,5}).forEach(  val -> {
            addBTreeNode(root, val);
        });
        return root;        
    }
    
    public static void main(String ...args) {
        
        BTNode root = new BinaryTreeTraversal().createBTree();
        System.out.println("BT created");
        List<Integer> preOrderTraversalList = new ArrayList<>();
        preOrderTraversal(preOrderTraversalList, root);
        System.out.println("Pre-Order Traversal :- " + preOrderTraversalList);
        
        List<Integer> inOrderTraversalList = new ArrayList<>();
        inOrderTraversal(inOrderTraversalList, root);
        System.out.println("In-Order Traversal :- " + inOrderTraversalList);
        
        List<Integer> postOrderTraversal = new ArrayList<>();
        postOrderTraversal(postOrderTraversal, root);
        System.out.println("Post-Order Traversal : - "+postOrderTraversal);
    }
    
    /**
     *  Root -> Left -> Right
     * @param list
     * @param node
     */
    public static void preOrderTraversal(List<Integer> list, BTNode node) {
        
        if(node == null) {
            return;
        }
        list.add(node.value);
        preOrderTraversal(list, node.left);
        preOrderTraversal(list, node.right);
    }
    
    /**
     * Left -> Root -> Right
     * @param list
     * @param node
     */
    public static void inOrderTraversal(List<Integer> list, BTNode node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(list, node.left);
        list.add(node.value);
        inOrderTraversal(list, node.right);
    }
    
    /**
     * Left -> Right -> Root
     * @param list
     * @param node
     */
    public static void postOrderTraversal(List<Integer> list, BTNode node) {
        if(node == null) {
            return;
        }
        postOrderTraversal(list, node.left);
        postOrderTraversal(list, node.right);
        list.add(node.value);
    }
}
