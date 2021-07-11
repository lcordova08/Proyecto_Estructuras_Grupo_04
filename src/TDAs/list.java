package TDAs;

/**
 *
 * @author gabri
 */
public interface list<E> {
    public void addFirst(E e); 

    public void addLast(E e); 

    public E removeFirst(); 

    public E removeLast(); 

    public int size();

    public boolean isEmpty();

    public void clear();
    
    public boolean add(int index, E element); 

    public E remove(int index); 

    public E get(int index); 

    public E set(int index, E element); 
    
    @Override
    public String toString(); 

}