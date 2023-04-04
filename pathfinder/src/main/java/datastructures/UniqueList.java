package datastructures;

import java.util.ArrayList;

public class UniqueList<E> extends ArrayList<E> {
    /**
     * Keep order while insuring uniqueness of each element
     * @param t The {@link E} to add
     * @return Has the segment been added?
     */
    @Override
    public boolean add(E t) {
        if(!super.contains(t)) {
            return super.add(t);
        }
        return false;
    }
}

