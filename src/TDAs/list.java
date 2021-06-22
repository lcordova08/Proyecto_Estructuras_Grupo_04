package TDAs;

/**
 *
 * @author gabri
 */
public interface list<E> {
    public boolean addFirst(E e); 

    public boolean addLast(E e); 

    public E removeFirst(); 

    public E removeLast(); 

    public int size();

    public boolean isEmpty();

    public void clear();
    
    public void add(int index, E element); 

    public E remove(int index); 

    public E get(int index); 

    public E set(int index, E element); 
    
    @Override
    public String toString(); 

}