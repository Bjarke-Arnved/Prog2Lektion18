package opgave01.models;

import java.util.NoSuchElementException;

public class QueueList<E> implements Queue<E> {
    int size;
    Node<E> head;
    Node<E> tail;
    public QueueList() {
        head = new Node<E>(null, null);
        tail = new Node<E>(null, head);
        size = 0;
    }
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<E>(element, null);
        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        size++;
    }

    @Override
    public E remove() {
        // The first person is not beeing removed.
        if(size == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
        else {
            Node<E> node = tail;
            Node<E> priorNode = null;
            while(node.getNext().getElement() != null) {
                priorNode = node;
                node = node.getNext();
            }
            priorNode.setNext(head);
            size--;
        }
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
    public class Node<E> {
        public E element;
        public Node next;
        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node n) {
            next = n;
        }
        public E getElement() {
            return element;
        }
        public void setElement(E e) {
            element = e;
        }

    }
}
