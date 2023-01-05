package com.prodius.container;

import com.prodius.model.Car;
import lombok.Getter;

import java.util.Iterator;

public class CarList<E extends Car> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    @Getter
    private int size;

    public void addFirst(E value){
        if(head == null){
            Node<E> node = new Node<>(value, null, null);
            head = node;
            tail = node;
        }else{
            Node<E> node = new Node<>(value, null, head);
            head.previous = node;
            head = node;
        }
        size++;
    }
    public void addLast(E value){
        if(tail == null){
            Node<E> node = new Node<>(value, null, null);
            tail = node;
            head = node;
        }else{
            Node<E> node = new Node<>(value, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void insert( E value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }
        Node<E> node = getIndex(index);
        Node<E> tempNode = node.previous;
        Node<E> newNode = new Node<>(value, tempNode, node);
        tempNode.next = newNode;
        node.previous = newNode;

        size++;
    }
    public int findByValue(final E car) {
        int i = 0;
        for (E value : this) {
            if (value.getId().equals(car.getId())) {
                break;
            }
            i++;
        }
        return i;
    }
    public void delete(final int index) {

        Node<E> node = getIndex(index);
        Node<E> prevNode = node.previous;
        Node<E> nextNode = node.next;

        if (size == 1) {
            head.next = tail;
            tail.previous = head;
            size--;
        } else if (index == 0) {
            head.next = nextNode;
            nextNode.previous = null;
            node.next = null;
            size--;
        } else if (index == getSize() - 1) {
            tail.previous = prevNode;
            prevNode.next = null;
            node.previous = null;
            size--;
        } else {
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            node.next = null;
            node.previous = null;
            size--;
        }
    }
    public Node<E> getIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head.next;
        while (index -- > 1) {
            node = node.next;
        }
        return node;
    }
    public int totalCount() {
        Node<E> current = head;
        int count = 0;
        while (current.next != null) {
            count += current.getValue().getCount();
            current = current.next;
        }
        return count;
    }
    public class CarListIterator implements Iterator<E> {
        Node<E> current = head;

        @Override
        public E next(){
            E lastReturnNode = current.value;
            current = current.next;
            return lastReturnNode;
        }
        @Override
        public boolean hasNext(){
            return current != null;
        }
    }
    @Override
    public Iterator<E> iterator(){
        return new CarListIterator();
    }
    private class Node<E> {

        private E value;
        private Node<E> previous;
        private Node<E> next;

        Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
        public E getValue(){
            return value;
        }
    }
}