/**
 * Created by rellis on 6/5/17.
 */
import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {

    private Node nextToLast = null;
    private Node first = null;
    private Node last = null;

    private class Node{
        Item item;
        Node next;
    }

    public Deque(){
        first = last;
    }

    public boolean isEmpty(){
        return first.item == null;
    }

    public int size(){
        Node temp = first;
        int count = 1;
        while(temp.next != null) {
            count++;
        }

        return count;
    }

    public void addFirst(Item item){
        if(item == null){
            throw new java.lang.NullPointerException();
        }

        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public void addLast(Item item){
        if(item == null){
            throw new java.lang.NullPointerException();
        }

        nextToLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        nextToLast.next = last;
    }

    public Item removeFirst(){
        Item temp = first.item;
        Node tempNode = first.next;
        first = new Node();
        first = tempNode;

        return temp;
    }

    public Item removeLast(){
        Item temp = last.item;
        Node tempNode = first;
        while(tempNode.next.next != null){
            tempNode = tempNode.next;
        }

        last = tempNode;
        last.next = null;

        return temp;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}


