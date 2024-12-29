package rlp.footrix.framework.utils;

public interface CuatriFunction<T, U, V, W, R> {
    R apply(T t, U u, V v, W w);
}
