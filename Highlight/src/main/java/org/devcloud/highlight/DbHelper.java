package org.devcloud.highlight;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * For doing work to the Database.
 */
public class DbHelper extends SQLiteOpenHelper {

  // If you change the database schema, you must increment the database version.
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "Highlight.db";

  public DbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + HighlightMessage.TABLE_NAME + " (id INTEGER PRIMARY KEY," +
        HighlightMessage.COLUMN_NAME_TEXT + " " + HighlightMessage.COLUMN_TYPE_TEXT + " NOT NULL, " +
        HighlightMessage.COLUMN_NAME_DATE + " " + HighlightMessage.COLUMN_TYPE_DATE + " NOT NULL, " +
        ")");
  }

  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // This database is only a cache for online data, so its upgrade policy is
    // to simply to discard the data and start over
    db.execSQL("DROP TABLE IF EXISTS " + HighlightMessage.TABLE_NAME);
    onCreate(db);
  }

  public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    onUpgrade(db, oldVersion, newVersion);
  }
}
