package org.example.myArrayList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E> implements List<E> {

    public Object[] values;

    public int size;

    public int indexForSomething = 0;

    public final static int defaultSize = 10;

    public int arraySize = defaultSize ;

    public MyArrayList() {
        values = new Object[defaultSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < size; i++){
            if(values[i] != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if(values[i] == o){
                return true;
            }
        }
        return false;
    }

    //I don't understand how iterator works
    @Override
    public Iterator<E> iterator()  {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        List.super.forEach(action);
    }

    @Override
    public Object[] toArray() {
        Object[] subArray = new Object[size];
        for(int i =0; i < size; i++){
            subArray[i] = values[i];
        }
        return subArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < size){
            for (int i = 0; i < a.length; i++) {
                a[i] = (T) values[i];
            }
            return a;
        }
        System.arraycopy(values, 0, a, 0, size);

        if (a.length > size){
            a[size] = null;
        }
        return a;
    }

    //?
    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator);
    }


    @Override
    public boolean add(E e) {
        values[indexForSomething] = e;
        indexForSomething++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < size; i++){
            if(values[i] == o){
                values[i] = null;
            }
        }
        return true;
    }

    //??
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object myArrayList : c){
            if(!contains(values))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int k = 0;
        if(a.length == 0){
            return false;
        }
        for(int i = size; i < size + a.length; i++){
            values[i] = a[k];
            k++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] a = c.toArray();
        Object[] valuesCopy = values;
        if(a.length == 0){
            return false;
        }
        for(int i = index; i < a.length + index; i++){
            values[i] = a[i];
        }
        for(int i = a.length + index; i < size; i++){
            values[i] = valuesCopy[index];
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] a = c.toArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < size; j++) {
                if(a[i] == values[i]){
                    values[i] = null;
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] a = c.toArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < size; j++) {
                if(values[i] != a[i]){
                    values[i] = null;
                }
            }
        }
        return true;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            values[i] = null;
        }
    }

    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        values[index] = element;
        //return element;
        return null;
    }

    //?
    @Override
    public void add(int index, E element) {

    }

    //?
    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for(int i =0; i < size; i++){
            if(values[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size; i > 0; i--){
            if(values[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return List.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return List.super.parallelStream();
    }

    public class MyIterator implements Iterator<E>{
        public int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E) values[index++];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
