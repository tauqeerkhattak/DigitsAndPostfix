package ahmed.tauqeer;

import java.util.EmptyStackException;

public class ArrayStack {
    private Object [] objects;
    private int size;

    public ArrayStack (int quantity) {
        objects = new Object[quantity];
    }

    public int size () {
        return this.size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyStackException();
        return objects[size - 1];
    }

    public Object pop () {
        if (isEmpty()) throw new EmptyStackException();
        Object object = objects[--size];
        objects[size] = null;
        return object;
    }

    public void push (Object object) {
        if (size == objects.length) resize ();
        objects[size++] = object;
    }

    private void resize () {
        Object [] aa = objects;
        objects = new Object[2 * aa.length];
        System.arraycopy(aa,0,objects,0,size);
    }
}
