package cn.edu.pku.unicorn.microsoft100.common;

/**
 *
 * Created by v_zhengkun on 2016/8/9.
 */
public class Pair<T> {
    public T v1;
    public T v2;

    public Pair() {

    }
    public Pair(T v1, T v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", v1, v2);
    }
}
