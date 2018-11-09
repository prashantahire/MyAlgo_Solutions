

package my.algo.greedymethod;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;


public class HuffmanCoding {
    
    public static void main(String ...args) {
        
        String input = "B C C C A B B B A D D D D D";
        HuffmanCoding hf = new HuffmanCoding();
        HNode root = hf.createHuffmanTree(input);
        hf.printHuffmanCode(root, "");
    }

    public HNode createHuffmanTree(String input) {

        Map<String, Integer> wordCount = getFrequencyCount(input);

        // Build min heap of leaf nodes using priority queue
        PriorityQueue<HNode> pq = new PriorityQueue<>(wordCount.size(), (e1, e2) -> {
            return e1.count - e2.count;
        });

        Set<Entry<String, Integer>> wordCountSet = wordCount.entrySet();
        for (Entry<String, Integer> entry : wordCountSet) {

            // create node
            HNode node = new HNode();
            node.value = entry.getKey();
            node.count = entry.getValue();

            // add into PQ
            pq.add(node);
        }

        HNode root = null;
        while (pq.size() > 1) {
            
            //Extract first min node from mean-heap and min-heapify again
            HNode node1 = pq.poll();
            
           //Extract second min node from mean-heap and min-heapify again
            HNode node2 = pq.poll();
           
            //Create third node from first 2
            HNode hn = new HNode();
            hn.value = "-";
            hn.count = node1.count + node2.count;

            hn.left = node1;
            hn.right = node2;

            root = hn;
            
            //Add to min heap and min-heapify again
            pq.add(hn);

        }
        return root;
    }

    public void printHuffmanCode(HNode node, String s) {

        if (node.left == null && node.right == null) {
            System.out.println(node.value + " : " + s);
            return;
        }
        printHuffmanCode(node.left, s + "0");
        printHuffmanCode(node.right, s + "1");
    }

    private Map<String, Integer> getFrequencyCount(String input) {
        String words[] = input.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int temp = wordCount.get(word);
                wordCount.put(word, temp + 1);
            }
            else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }
}


class HNode {
    String value;
    int count;
    HNode left;
    HNode right;
}
