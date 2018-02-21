package code.challenge.stocktwits.model;

import android.arch.lifecycle.LiveData;

import code.challenge.stocktwits.model.entity.Trending;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class TrendingLiveData extends LiveData<Trending> {

  private StockTwitsModel model;

  TrendingLiveData(StockTwitsModel model) {
    this.model = model;
    load();
  }

  private void load() {
    model.getTrending().enqueue(new Callback<Trending>() {
      @Override
      public void onResponse(Call<Trending> call, Response<Trending> response) {
        setValue(response.body());
      }

      @Override
      public void onFailure(Call<Trending> call, Throwable t) {
        // TODO: 2/20/18 implement
      }

    });
  }


}
