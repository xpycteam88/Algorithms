package algorithms;

import algorithms.exceptions.ArrayIsFullException;
import algorithms.exceptions.ElementNotFoundException;
import algorithms.exceptions.InvalidIndexException;
import algorithms.exceptions.NullElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringListImlTest {
    StringList stringList = new StringListIml();

    @BeforeEach
    void setUp() {
        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        stringList.add("test4");
        stringList.add("test5");
        stringList.add("test6");
        stringList.add("test7");
        stringList.add("test8");
    }

    @Test
    void addTestOne() {
        assertThrows(NullElementException.class, () -> stringList.add(null));
        stringList.add("test9");
        assertEquals(9, stringList.size());
        assertEquals("test9", stringList.get(8));
        stringList.add("test10");
        assertThrows(ArrayIsFullException.class, () -> stringList.add("test11"));

    }

    @Test
    void addTestTwo() {
        assertThrows(InvalidIndexException.class, () -> stringList.add(100, "test8"));
        stringList.add(8, "test9");
        assertEquals("test9", stringList.get(8));
        stringList.add(5, "testtest");
        assertEquals("testtest", stringList.get(5));
    }

    @Test
    void setTest() {
        assertEquals("testnew5", stringList.set(4, "testnew5"));
    }

    @Test
    void removeTest(){
        assertThrows(ElementNotFoundException.class, () -> stringList.remove("test777"));
        stringList.remove("test2");
        assertThat(stringList.toArray()).contains(new String[]{
                "test1", "test3", "test4", "test5", "test6", "test7", "test8"});


    };

    @Test
    void isEmptyTest() {
        stringList.add("test");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void clearTest() {
        stringList.clear();
        assertEquals(0, stringList.size());
    }

    @Test
    void containsTest() {
        assertTrue(stringList.contains("test7"));
        assertFalse(stringList.contains("test777"));
    }

    @Test
    void indexOfTest() {
        assertEquals(2, stringList.indexOf("test3"));
        assertEquals(-1, stringList.indexOf("test777"));
        assertEquals(7, stringList.lastIndexOf("test8"));
        assertEquals(-1, stringList.lastIndexOf("test777"));
    }

    @Test
    void equalsTest() {
        StringList expected = new StringListIml(10);
        expected.add("test1");
        expected.add("test2");
        expected.add("test3");
        expected.add("test4");
        expected.add("test5");
        expected.add("test6");
        expected.add("test7");
        expected.add("test8");
        assertThat(stringList.equals(expected)).isTrue();
        assertArrayEquals(expected.toArray(), stringList.toArray());
        assertEquals(expected.toString(), stringList.toString());
    }


}