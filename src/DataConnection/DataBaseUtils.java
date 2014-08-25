package DataConnection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseUtils {
	/***
	 * Function to create an instance of the DB helper class
	 */
	public static FeedReaderHelper helperret(Context context)
	{
		FeedReaderHelper dbhelper= new FeedReaderHelper(context);
		return dbhelper;
	}
	
	public static SQLiteDatabase write(FeedReaderHelper helper)
	{
		SQLiteDatabase db=helper.getWritableDatabase();
		return db;
	} 
	
}
