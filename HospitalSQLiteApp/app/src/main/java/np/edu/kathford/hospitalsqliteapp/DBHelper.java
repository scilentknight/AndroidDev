package np.edu.kathford.hospitalsqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Hospital.db";
    public static final String TABLE_NAME = "Doctor";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                "(Did INTEGER PRIMARY KEY, " +
                "DName TEXT, " +
                "Experience REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert Doctor
    public void insertDoctor(int id, String name, double exp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Did", id);
        cv.put("DName", name);
        cv.put("Experience", exp);
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    // Get Doctors with Experience < 5.5
    public Cursor getJuniorDoctors() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT * FROM Doctor WHERE Experience < 5.5", null);
    }
}

