package org.devcloud.highlight;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Class for storing messages.
 */
public class HighlightMessage {
  private final 

  private final String COLUMN_NAME_TEXT = "text";
  private final String COLUMN_TYPE_TEXT = "text";

  String text;

  private final String COLUMN_NAME_DATE = "created";
  private final String COLUMN_TYPE_DATE = "datetime";

  Date created;

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

  public long save(Context context) {
    DbHelper mDbHelper = new DbHelper(context);
// Gets the data repository in write mode
    SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
    ContentValues values = new ContentValues();
    values.put(this.COLUMN_NAME_TEXT, this.getText());
    values.put(this.COLUMN_NAME_DATE, this.getCreated());

// Insert the new row, returning the primary key value of the new row
    return db.insert(this.TABLE_NAME, this.COLUMN_NAME_NULLABLE, values);
  }
}
