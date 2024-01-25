/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        List<Object> result=new ArrayList<>();
        Deque<Node> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentQueueLength=queue.size();
            List<Object> currentQueueLevel=new ArrayList<>();
            for(int i=0;i<currentQueueLength;i++){
                Node currentNode=queue.poll();
                Node nextNode;
                boolean nullChecker;
                if(currentQueueLength-i==1){//edge case
                    nextNode=null;
                    nullChecker=true;
                }else{
                    nextNode=queue.peekFirst();
                    nullChecker=false;
                }
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                currentNode.next=nextNode;
                currentQueueLevel.add(currentNode.val);
                if(nullChecker){
                    currentQueueLevel.add('#');
                }
            }
            result.addAll(currentQueueLevel);
        }
        
        return root;
        
        
    }
}