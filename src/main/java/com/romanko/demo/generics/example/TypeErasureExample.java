package com.romanko.demo.generics.example;

/**
 * 2.4 Type erasure
 * */
public class TypeErasureExample {

    //before erasure
    public static  <E> boolean containsElement(E[] elements, E element){
        for (E e : elements){
            if(e.equals(element)){
                return true;
            }
        }
        return false;
    }

    //after erasure
//    public static  boolean containsElement(Object [] elements, Object element){
//        for (Object e : elements){
//            if(e.equals(element)){
//                return true;
//            }
//        }
//        return false;
//    }
    class BeforeTypeErasure {
        //Before class type erasure
        class Stack<E> {
            private E[] stackContent;

            public Stack(int capacity) {
                this.stackContent = (E[]) new Object[capacity];
            }

            public void push(E data) {
                // ..
            }

            public E pop() {
                // ..
                throw new UnsupportedOperationException();
            }
        }
        //Before bounded class type erasure
        public class BoundStack<E extends Comparable<E>> {
            private E[] stackContent;

            public BoundStack(int capacity) {
                this.stackContent = (E[]) new Object[capacity];
            }

            public void push(E data) {
                // ..
            }

            public E pop() {
                // ..
                throw new UnsupportedOperationException();
            }
        }
    }
    class AfterTypeErasure {
        //After class type erasure
        class Stack {
            private Object[] stackContent;

            public Stack(int capacity) {
                this.stackContent = (Object[]) new Object[capacity];
            }

            public void push(Object data) {
                // ..
            }

            public Object pop() {
                // ..
                throw new UnsupportedOperationException();
            }
        }
        //After bounded class type erasure
        class BoundStack {
            private Comparable [] stackContent;

            public BoundStack(int capacity) {
                this.stackContent = (Comparable[]) new Object[capacity];
            }

            public void push(Comparable data) {
                // ..
            }

            public Comparable pop() {
                // ..
                throw new UnsupportedOperationException();
            }
        }
    }
}

