package org.devcloud.highlight;

import java.util.Date;

/**
 * Class for storing messages.
 */
public class HighlightMessage {
  String text;
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
}
