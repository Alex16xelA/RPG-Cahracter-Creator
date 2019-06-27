package pl.wroc.pwr.a236139.rpgcharactercreator;

import android.content.Context;
import android.database.Cursor;

import java.util.List;

public interface InterfaceORM<T> {

    public T cursorToObject(Cursor cursor);
    public void add(Context context, T t);
    public void clearAll(Context context);
    public List<T> getAll(Context context);

}
