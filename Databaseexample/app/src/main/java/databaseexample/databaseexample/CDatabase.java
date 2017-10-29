package databaseexample.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlpElwin on 29.10.2017.
 */

public class CDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CDatabase";
    private static final int DATABASE_VERSION = 1;

    private String TALEPLER_TABLE = "TALEPLER";

    public final String ROW_ID = "ID";
    public final String ROW_SUBJECT = "KONU";
    public final String ROW_SUMMARY = "ACIKLAMA";


    public CDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TALEPLER_TABLE + "("+ ROW_ID +" INTEGER PRIMARY KEY, "+ ROW_SUBJECT + " TEXT NOT NULL,"+ ROW_SUMMARY + " TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TALEPLER_TABLE);
        onCreate(db);
    }

    public void VeriEkle(String KONU, String ACIKLAMA)
    {

    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_SUBJECT, KONU.trim());
        cv.put(ROW_SUMMARY, ACIKLAMA.trim());
        db.insert(TALEPLER_TABLE, null, cv);
        db.close();
    }

    public List<String> VeriListele()
    {

    List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
    String[] sutunlar = {ROW_ID, ROW_SUBJECT, ROW_SUMMARY};
        Cursor cursor = db.query(TALEPLER_TABLE, sutunlar, null, null, null, null, null, null);


        while (cursor.moveToNext())
        {

            veriler.add(cursor.getInt(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2));

         }
        return veriler;
    }
}
