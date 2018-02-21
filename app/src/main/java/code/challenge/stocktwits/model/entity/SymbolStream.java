package code.challenge.stocktwits.model.entity;

import java.util.List;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class SymbolStream {
  private Symbol symbol;
  private List<Message> messages;
  private Cursor cursor;

  public Symbol getSymbol() {
    return symbol;
  }

  public void setSymbol(Symbol symbol) {
    this.symbol = symbol;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public Cursor getCursor() {
    return cursor;
  }

  public void setCursor(Cursor cursor) {
    this.cursor = cursor;
  }
}
