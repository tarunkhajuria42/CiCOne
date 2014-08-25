package DataConnection;

import android.provider.BaseColumns;

public final class FeedReaderContract {
	// To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME_Notifications = "Buffer_Notifications";
        public static final String ID_Notifications = "SNo";
        public static final String Title_Notifications = "PostName";
        public static final String Text_Notifications = "PostText";
        public static final String TABLE_NAME_DATA="Data";
        public static final String TAG_DATA="Tag";
        public static final String VALUE1_DATA="Textval";
        public static final String VALUE2_DATA="Number";
    }
    
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + FeedEntry.TABLE_NAME_Notifications + " (" +
        FeedEntry.ID_Notifications + " INTEGER PRIMARY KEY," +
        FeedEntry.Title_Notifications + TEXT_TYPE + COMMA_SEP +
        FeedEntry.Text_Notifications + TEXT_TYPE +
        // Any other options for the CREATE command
        " ); CREATE TABLE"+FeedEntry.TABLE_NAME_DATA+"("+FeedEntry.TAG_DATA+COMMA_SEP+"TEXT PRIMARY KEY,"+FeedEntry.TAG_DATA+"TEXT,"+FeedEntry.VALUE1_DATA+"TEXT,"+FeedEntry.VALUE2_DATA+"INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME_Notifications+";DROP TABLE IF EXISTS"+FeedEntry.TABLE_NAME_DATA;
}
