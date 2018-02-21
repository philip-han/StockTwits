package code.challenge.stocktwits.model.entity;

import com.squareup.moshi.Json;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Conversation {
  @Json(name = "parent_message_id")
  private Long parentMessageId;
  @Json(name = "in_reply_to_message_id")
  private Long inReplyToMessageId;
  private boolean parent;
  private Integer replies;

  public long getParentMessageId() {
    return parentMessageId;
  }

  public void setParentMessageId(long parentMessageId) {
    this.parentMessageId = parentMessageId;
  }

  public long getInReplyToMessageId() {
    return inReplyToMessageId;
  }

  public void setInReplyToMessageId(long inReplyToMessageId) {
    this.inReplyToMessageId = inReplyToMessageId;
  }

  public boolean isParent() {
    return parent;
  }

  public void setParent(boolean parent) {
    this.parent = parent;
  }

  public int getReplies() {
    return replies;
  }

  public void setReplies(int replies) {
    this.replies = replies;
  }
}
