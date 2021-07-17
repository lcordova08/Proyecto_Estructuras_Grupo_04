package TDAs;

/**
 *
 * @author gabri
 */
    public interface List<E> {
    boolean addFirst(E element);

    boolean addLast(E element);

    E get(int index);

    int size();

    boolean isEmpty();


    boolean contains(E element);

    boolean removeFirst();

    boolean removeLast();

    E getFirst();

    E getLast();
    
    @Override
    public String toString(); 

}