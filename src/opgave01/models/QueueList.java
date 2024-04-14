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
        Node<E> node = tail;
        Node<E> priorNode = null;

        if(size == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
        else {
            while(node.getNext().getElement() != null) {
                priorNode = node;
                node = node.getNext();
            }
            priorNode.setNext(head);
            size--;
        }
        return node.getElement();
    }

    @Override
    public E element() {
        Node<E> node = tail;
        while(node.getNext().getElement() != null) {
            node = node.getNext();
        }
        if(isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return node.getElement();
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
