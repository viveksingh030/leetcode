import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer,ListNode> lruCacheMap;
    private int capacity;
    private ListNode head;
    private ListNode tail;
    class ListNode{
        private int key;
        private int value;
        private ListNode prev;
        private ListNode next;
        ListNode(int key,int val){
            this.key=key;
            this.value=val;
        }
        ListNode(){
        }
    }
    public LRUCache(int capacity) {
      lruCacheMap=new HashMap<>(capacity);
      this.capacity=capacity;
      this.head=new ListNode();
      this.tail=new ListNode();
      tail.prev=head;
      head.next=tail;
    }
/*
this is to add the node at end of the list
*/
    private void add(ListNode node){
        ListNode temp=tail.prev;
        temp.next=node;
        node.prev=temp;
        node.next=tail;
        tail.prev=node;
    }

    private void remove(ListNode node){
        ListNode next=node.next;
        ListNode prev=node.prev;
        prev.next=next;
        next.prev=prev;
    }
    
    public int get(int key) {
        if(lruCacheMap.containsKey(key)){
            ListNode node=lruCacheMap.get(key);
            remove(node);
            add(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
      ListNode node=new ListNode(key,value);
      if(lruCacheMap.containsKey(key)){
          remove(lruCacheMap.get(key));
      }
     add(node);
     lruCacheMap.put(key,node);
     if(lruCacheMap.size()>capacity){
         lruCacheMap.remove(head.next.key);
         remove(head.next);
     }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */