package com.purva.she;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Dell on 04/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private  static DatabaseHelper mydb;
    public static final String DATABASE_NAME = "my.db";
    public static final String TABLE_NAME = "me";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "F_NAME";
    public static final String COL_3 = "L_NAME";
    public static final String COL_4 = "START";
    public static final String COL_5 = "END";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static synchronized DatabaseHelper getInstance (Context context){
        if(mydb==null)
        {
            mydb = new DatabaseHelper(context.getApplicationContext());
        }
        return mydb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" (F_NAME TEXT,L_NAME TEXT,START INTEGER,END INTEGER)");
        db.execSQL("INSERT INTO me (F_NAME,L_NAME,START,END) VALUES ('prs','kh',3,7) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname,String lname,int start,int end) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,start);
        contentValues.put(COL_5,end);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
         Cursor res = db.rawQuery("select * from "+TABLE_NAME , null);
        return res;
    }

    public boolean updateData(String fname,String lname,String start,String end) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,start);
        contentValues.put(COL_5,end);
        db.update(TABLE_NAME, contentValues, "F_NAME=?",new String[] { fname });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
