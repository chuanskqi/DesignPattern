package argorithm.list;

import lombok.Data;

@Data
public class Node<T> {
    private T body;
    private Node next;
}
