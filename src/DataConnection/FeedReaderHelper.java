package DataConnection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//SqliteOpenHelper
public class FeedReaderHelper extends SQLiteOpenHelper {
  // If you change the database schema, you must increment the database version.
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "Local.db";
  public FeedReaderHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
  
  public void onCreate(SQLiteDatabase db) {
      db.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES);
      Log.d("Tarun","Creating Database");
  }
  
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // This database is only a cache for online data, so its upgrade policy is
      // to simply to discard the data and start over
      db.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES);
      onCreate(db);
  }
  public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      onUpgrade(db, oldVersion, newVersion);
  }
}