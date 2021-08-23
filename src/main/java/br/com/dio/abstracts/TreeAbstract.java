package br.com.dio.abstracts;

public abstract class TreeAbstract<T> implements Comparable<T> {
    public abstract int compareTo(T outro);
    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract String toString();
}
