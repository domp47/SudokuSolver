import java.util.Arrays;

public class Vector<E> {
    private E[] items;
    private int itemCount;

    /**
     * Vector that holds type E, grows in size when needed.
     * initializes empty vector with a size of 10 by default
     */
    Vector(){
        itemCount = 0;
        items = (E[]) new Object[10];
    }

    /**
     * adds and item E to the end of the vector
     *
     * @param item the item to add to the end of the vector
     */
    void add(E item){
        if(itemCount>=items.length){
            //ensure that there is space in array to insert element
            ensureCapacity(itemCount+1);
        }
        items[itemCount++] = item;
    }

    /**
     * Searches vector for instance of Item and returns true if it is found.
     * It returns false if the item was not found.
     *
     * @param item the item to search for.
     * @return True if item is found, False otherwise
     */
    boolean containsItem(E item){
        for(int i = 0; i < itemCount; i++){
            if(items[i].equals(item))
                return true;
        }
        return false;
    }

    /**
     * Removes all elements from the Vector.  Note that this does not
     * resize the data array.
     */
    void clear(){
        Arrays.fill(items,0);
        itemCount = 0;
    }

    /**
     * Ensures that the minCapacity number of elements can fit inside the vector.
     * If there is not enough space we double the space allocated to the vector.
     *
     * @param minCapacity the minimum number of elements that has to be able to
     *                    fit inside this vector.
     */
    private void ensureCapacity(int minCapacity){
        if(items.length >= minCapacity)
            return;

        int newCapacity = items.length * 2;

        E[] newArray = (E[]) new Object[newCapacity];

        System.arraycopy(items, 0, newArray, 0, itemCount);
        items = newArray;
    }
}
