package algorithms;

import algorithms.exceptions.ArrayIsFullException;
import algorithms.exceptions.ElementNotFoundException;
import algorithms.exceptions.InvalidIndexException;
import algorithms.exceptions.NullElementException;

import java.util.Arrays;

public class StringListIml implements StringList {
    public final String[] array;
    private int size;

    public StringListIml() {
        array = new String[10];
    }

    public StringListIml(int size) {
        array = new String[size];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateElement(item);
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateElement(item);
        validateIndex(index);
        if (index == size) {
            array[index] = item;
            size++;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateElement(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateElement(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return  remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = array[index];
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = array[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String s = array[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateElement(String element) {
        if (element == null) {
            throw new NullElementException();
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);

    }

}
