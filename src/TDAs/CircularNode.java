

package TDAs;

/**
 *
 * @author gabri
 * 
 */
public class CircularNode<Integer> {
    private Integer content;
    private CircularNode next;
    private CircularNode prev;
    
    //constructores
    public CircularNode(Integer content, CircularNode next, CircularNode prev) {
        this.content = content;
        this.next = next;
        this.prev = prev;
    }

    public CircularNode(Integer content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }

    //Getters & setters
    
    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }

    public CircularNode getPrev() {
        return prev;
    }

    public void setPrev(CircularNode prev) {
        this.prev = prev;
    }

    
}
