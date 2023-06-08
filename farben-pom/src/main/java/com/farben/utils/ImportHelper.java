package com.farben.utils;

import java.util.Iterator;
import java.util.List;

public abstract class ImportHelper<T> implements Iterator<T> {

    public abstract int getTotalRowsNum();

    public abstract List<T> getRows();

    public abstract void close();

}