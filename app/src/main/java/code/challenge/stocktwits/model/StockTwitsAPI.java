package code.challenge.stocktwits.model;

import code.challenge.stocktwits.model.entity.SymbolStream;
import code.challenge.stocktwits.model.entity.Trending;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public interface StockTwitsAPI {

  @GET("trending/symbols.json")
  Call<Trending> getTrending(@Query("access_token") String token);

  @GET("streams/symbol/{symbol}.json")
  Call<SymbolStream> getSymbolStream(@Path("symbol") String symbol, @Query("access_token") String token);

}
