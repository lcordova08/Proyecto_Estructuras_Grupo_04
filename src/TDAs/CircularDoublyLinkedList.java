/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author grupo_4
 */

    public class CircularDoublyLinkedList<E> implements List<E> {
    private Node<E> last;
    private int current;

    public CircularDoublyLinkedList() {
        current=0;
        last=null;
    }
    
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;
        
        public Node(E data){
            this.data=data;
            this.next=null;
            this.previous=null;
        }        
    }
    
    @Override
    public boolean contains(E element) {
        if(isEmpty()||element==null){
            return false;
        }else{
            int i=0;
            for(Node<E> q=last.next;i<current;q=q.next){
                if(q.data.equals(element)){
                    return true;
                }
                i++;                
            }
        }
        return false;
    }

    @Override
    public int size() {
        return current;
    }

    
    @Override
    public boolean addLast(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
            last.previous=last;
        }
        else{
            n.next = last.next;
            last.next.previous=n;
            last.next = n;
            n.previous=last;
            last = n;
        }
        current++;
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        Node<E> n=new Node<>(e);
        if(isEmpty()){ 
            last= n;
            last.next=last;
            last.previous=last;
        }else{
            Node<E> first=last.next;
            last.next=n;
            n.next=first;
            first.previous=n;
            n.previous=last;            
        }
        current++;
        return true;
            
    }
    @Override
    public boolean removeLast() throws NullPointerException{
        if(isEmpty()) throw  new NullPointerException();
        else if(current==1){
            last.data=null;
            last.next=last.previous=null;                        
        }else{
            Node<E> n=last.previous;
            n.next=last.next;
            last.next.previous=n;
            last.data=null;
            last.next=last.previous=null;            
            last=n;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeFirst(){
        if(isEmpty()) return false;
        if(current==1){
            last.next.data=null;
            last.next=last=null;
        }else{
            last.next.data=null;
            Node<E> tmp= last.next.next;            
            last.next.next=null;                      
            tmp.previous=null;
            last.next=tmp;
        }
        current--;
        return true;
    }

    @Override
    public E getFirst(){
        if(isEmpty()) return null;        
        else{
            return last.next.data;
        }
    }

    @Override
    public E getLast(){
        if(isEmpty()) return null;        
        else{
            return last.data;
        }
        
    }
    
    
    private Node<E> getNode(int index){
        if(isEmpty()|| (index<0 || index>=current)){ return null;           
        }else{
            int i=0;
            for(Node<E> q=last.next; i<current;q=q.next){
                if(i==index){
                    return q;
                }
                i++;
            }
            return null;
        }                
    }
        
    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public boolean isEmpty() {
         return current==0;
    }

    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(Node<E> p=last.next; p!=last;p=p.next){
            sb.append(p.data);
            sb.append(", ");            
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
        
    }
}
