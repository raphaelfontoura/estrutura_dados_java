package br.com.dio.model;

import br.com.dio.abstracts.TreeAbstract;

import java.util.Objects;

public class TreeObj extends TreeAbstract<TreeObj> {

    Integer myValue;

    public TreeObj(Integer myValue) {
        this.myValue = myValue;
    }

    @Override
    public int compareTo(TreeObj outro) {
        int i = 0;
        if (this.myValue > outro.myValue) {
            i = 1;
        } else if (this.myValue < outro.myValue) {
            i = -1;
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeObj treeObj = (TreeObj) o;
        return Objects.equals(myValue, treeObj.myValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myValue);
    }

    @Override
    public String toString() {
        return myValue.toString();
    }
}
