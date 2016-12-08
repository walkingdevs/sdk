package walkingdevs.iter;

import walkingdevs.NULLSafe;

import java.util.ArrayList;

public interface Iter<T> extends Iterable<T>, NULLSafe {
    String join(String with);

    static <T> Iter<T> mk(Iterable<T> iterable) {
        if (iterable == null) {
            return mk();
        }
        return new IterImpl<>(iterable);
    }

    static <T> Iter<T> mk() {
        return mk(new ArrayList<T>());
    }

    static <T> Iter<T> mk(T... array) {
        ArrayList<T> iterable = new ArrayList<T>();
        for (T t : array) {
            iterable.add(t);
        }
        return mk(iterable);
    }
}