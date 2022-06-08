package model.utilitarios;

import java.util.ArrayList;
import java.util.List;

public class ListBuilder<T> {

   private List<T> list;

    public ListBuilder() {
        list = new ArrayList<T>();
    }

    public ListBuilder<T> add(T element) {
        list.add(element);
        return this;
    }

    public List<T> build() {
        return list;
    }

}
