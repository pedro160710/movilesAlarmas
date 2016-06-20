package ec.edu.epn.alarmas.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christian on 30/5/2016.
 */
public class TimeControlAppOpenHelper extends SQLiteOpenHelper {
    private static final int version=1;
    private static final String base_datos="timeControl.db";

    //
    public TimeControlAppOpenHelper(Context context) {
        super(context, base_datos, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*colocar la logia especifica dependiendo de la version*/
        db.execSQL(TimeControlAppContract.CREAR_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion){
            db.execSQL(TimeControlAppContract.ELIMINA_TABLAS);
            db.execSQL(TimeControlAppContract.CREAR_TABLA);
        }

    }
}
