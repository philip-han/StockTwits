package code.challenge.stocktwits.model.entity;

import java.util.List;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Trending {
  private List<Symbol> symbols;

  public List<Symbol> getSymbols() {
    return symbols;
  }

  public void setSymbols(List<Symbol> symbols) {
    this.symbols = symbols;
  }
}
