

package TDAs;

/**
 *
 * @author gabri
 */
 
public class CircularLinkedList<Integer> implements list<Integer> {
    
    private CircularNode last;
    
    //Constructores

    public CircularLinkedList() {
        
    }
    
    private CircularNode<Integer> tail = null;
    private int size = 0;
    
    @Override
    public void addFirst(Integer e) {
        CircularNode<Integer> nuevo = new CircularNode(e);
        if (isEmpty()) {
            tail = nuevo;
            tail.setNext(nuevo);
            tail.setPrev(nuevo);
        } else {
            tail.getPrev().setNext(nuevo);
            nuevo.setNext(tail);
            nuevo.setPrev(tail.getPrev());
            //tail = nuevo;
        }
        size++;
    }

    @Override
    public void addLast(Integer e) {
        CircularNode<Integer> nuevo = new CircularNode(e);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            nuevo.setPrev(nuevo);
            tail = nuevo;
        }else {
            nuevo.setPrev(tail);
            tail.setNext(nuevo);
            tail.getNext().setPrev(nuevo);
            nuevo.setNext(tail.getNext());
            tail = nuevo;
        }
        size++;
    }

    @Override
    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E primero = tail.getNext().getContent();// corregir
        tail.setNext(tail.getNext().getNext());
        tail.getNext().getNext().setPrev(tail);
        size--;
        if (size == 1) {
            tail = null;
        }
        return primero;
    }

    @Override
    public Integer removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            Integer temp = tail.getContent();
            tail = null;
            size--;
            return temp;
        }
        CircularNode<Integer> newtail = tail.getPrev();
        Integer temp = tail.getContent();
        newtail.setNext(tail.getNext());
        tail.getNext().setPrev(newtail);
        tail = newtail;
        size--;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
//falta el clear
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(int index, Integer element) {
        if (index == 0) {
            addFirst(element);
        } else if (index > size || index < 0) {
            return false;
        } else if (index == size - 1) {
            addLast(element);
        } else {
            int pos = 0;
            for (CircularNode<Integer> e = tail.getNext(); e != tail; e = e.getNext()) {
                if (pos == index) {
                    size++;
                    CircularNode<Integer> temp = e.getNext();
                    CircularNode<Integer> nuevo = new CircularNode(element);
                    e.getPrev().setNext(nuevo);
                    nuevo.setNext(e);
                    nuevo.setPrev(e.getPrev());
                    e.setPrev(nuevo);
                    return true;
                }
                pos++;
            }
        }
        return false;
    }

    @Override
    public Integer remove(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index > size || index < 0) {
            return null;
        }
        if (index == size - 1) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int pos = 0;
        for (CircularNode<Integer> e = tail.getNext(); e.getNext() != tail; e = e.getNext()) {
            if (pos == index) {
                e.getPrev().setNext(e.getNext());
                e.getNext().setPrev(e.getPrev());
                size--;
                return e.getContent();
            }
            pos++;
        }
        return null;
    }
// faltan estos dos
    @Override
    public Integer get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer set(int index, Integer element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
