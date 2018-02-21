package code.challenge.stocktwits.model;

import code.challenge.stocktwits.model.entity.SymbolStream;
import code.challenge.stocktwits.model.entity.Trending;
import retrofit2.Call;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class StockTwitsModel {

  private StockTwitsAPI stockTwitsAPI;
  private final static String TOKEN = "1702226a6188b6f9411d6dd0f96f1a717df5a9bb";

  public StockTwitsModel(StockTwitsAPI stockTwitsAPI) {
    this.stockTwitsAPI = stockTwitsAPI;
  }

  Call<Trending> getTrending() {
    return stockTwitsAPI.getTrending(TOKEN);
  }

  Call<SymbolStream> getSymbolStream(String symbol) {
    return stockTwitsAPI.getSymbolStream(symbol, TOKEN);
  }

  public TrendingLiveData getTrendingLiveData() {
    return new TrendingLiveData(this);
  }

  public SymbolStreamLiveData getSymbolStreamLiveData(String symbol) {
    return new SymbolStreamLiveData(this, symbol);
  }

}
