package org.devcloud.highlight;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Class for storing messages.
 */
public class HighlightMessage {
  public final String TABLE_NAME = "messages";

  public final String COLUMN_NAME_TEXT = "text";
  public final String COLUMN_TYPE_TEXT = "text";

  private String text;

  public final String COLUMN_NAME_DATE = "created";
  public final String COLUMN_TYPE_DATE = "datetime";

  private Date created;

  public HighlightMessage(String msg) {
    this.setText(msg);
    this.setCreated(new Date());
  }

  public String getText() {
    return text;
  }

  public Date getCreated() {
    return created;
  }

  private void setText(String text) {
    this.text = text;
  }

  private void setCreated(Date created) {
    this.created = created;
  }

  public long save(Context context) throws Exception {
    DbHelper mDbHelper = new DbHelper(context);
    // Gets the data repository in write mode
    SQLiteDatabase db = mDbHelper.getWritableDatabase();
    if (db == null) {
      throw new Exception("Database not writable.");
    }

    // Create a new map of values, where column names are the keys
    ContentValues values = new ContentValues();
    values.put(this.COLUMN_NAME_TEXT, this.getText());
    // TODO: Figure out how to store date correctly.
    values.put(this.COLUMN_NAME_DATE, this.getCreated().toString());

    // Insert the new row, returning the primary key value of the new row
    return db.insert(this.TABLE_NAME, "", values);
  }
}
