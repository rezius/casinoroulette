package casino.roulette.game;

import  casino.roulette.game.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_GAME = "game";
    public static final String KEY_SCORE = "score";
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "game";
    private static final String DATABASE_TABLE = "test";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table test (_id integer primary key autoincrement, "
        + "name text not null, surname text not null, " 
        + "username text not null, password text not null, "
        + "email text not null, game integer, "
        + "score integer);";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert information into the database---
    public long insertPlayer(String name, String surname, String username, String password, String email, int game, int score) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_SURNAME, surname);
        initialValues.put(KEY_USERNAME, username);
        initialValues.put(KEY_PASSWORD, password);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_GAME, game);
        initialValues.put(KEY_SCORE, score);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular player---
    public boolean deletePlayer(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
        		"=" + rowId, null) > 0;
    }

    //---retrieves player information---
    public Cursor getAllPlayers() 
    {
       return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_NAME,
        		KEY_SURNAME,
                KEY_USERNAME,
                KEY_PASSWORD,
                KEY_EMAIL,
                KEY_GAME,
                KEY_SCORE}, 
                null, 
                null, 
                null, 
                null,
                null);
	
    }

    //---retrieves a particular player---
    public Cursor getPlayer(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_NAME, 
                		KEY_SURNAME,
                		KEY_USERNAME,
                		KEY_PASSWORD,
                        KEY_EMAIL,
                        KEY_GAME,
                        KEY_SCORE}, 
                		KEY_ROWID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---retrieves a particular player---
    public Cursor getPlayer(String username) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_NAME, 
                		KEY_SURNAME,
                		KEY_USERNAME,
                		KEY_PASSWORD,
                        KEY_EMAIL,
                        KEY_GAME,
                        KEY_SCORE}, 
                        KEY_USERNAME + "=" + "'"+username+"'", 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    //---retrieves a particular player---
    public Cursor getScores(String username) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_NAME, 
                		KEY_SURNAME,
                		KEY_USERNAME,
                		KEY_PASSWORD,
                        KEY_EMAIL,
                        KEY_GAME,
                        KEY_SCORE}, 
                        KEY_NAME + "=" + "'"+username+"'", 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }    
    
    //---updates player information---
    public boolean updatePlayer(long rowId, String name, 
    String surname, String username, String password, String email, int game, int score) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_SURNAME, surname);
        args.put(KEY_USERNAME, username);
        args.put(KEY_PASSWORD, password);
        args.put(KEY_EMAIL, email);
        args.put(KEY_GAME, game);
        args.put(KEY_SCORE, score);        
        return db.update(DATABASE_TABLE, args, 
                         KEY_ROWID + "=" + rowId, null) > 0;
    }
}