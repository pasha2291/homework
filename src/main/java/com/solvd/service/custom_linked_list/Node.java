package com.solvd.service.custom_linked_list;

class Node<T> {
    T current;
    Node<T> next;

    Node(T current) {
        this.current = current;
        this.next = null;
    }
}