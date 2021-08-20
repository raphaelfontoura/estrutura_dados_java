package br.com.dio.model;

public class No<T> {
    private T content;
    private No<T> nextNo;

    public No(T content) {
        this.content = content;
    }

    public void setNextNo(No<T> nextNo) {
        this.nextNo = nextNo;
    }

    public No<T> getNextNo() {
        return nextNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "content=" + content +
                '}';
    }

    public T getData() {
        return content;
    }
}
