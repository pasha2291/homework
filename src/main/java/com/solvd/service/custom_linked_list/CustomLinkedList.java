package com.solvd.service.custom_linked_list;

public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> nodeToBeInserted = new Node<>(data);
        Node<T> node = head;
        for(int i = 0; i < index -1; i++){
            node = node.next;
        }
        nodeToBeInserted.next = node.next;
        node.next = nodeToBeInserted;
    }

    public void set(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node<T> tempNode = head;
        while (i < index) {
            tempNode = tempNode.next;
            i++;
        }
        tempNode.current = data;
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.current.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null && !current.current.equals(data)) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
            size--;
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for(int i = 0; i< index -1; i++){
            node = node.next;
        }
        node.next = node.next.next;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;//
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node.current;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}