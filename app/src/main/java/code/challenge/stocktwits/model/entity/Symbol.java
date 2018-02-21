package code.challenge.stocktwits.model.entity;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Symbol {
  private long id;
  private String symbol;
  private String title;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
