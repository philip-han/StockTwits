package code.challenge.stocktwits.model;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import code.challenge.stocktwits.model.entity.SymbolStream;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class SymbolStreamLiveData extends LiveData<SymbolStream> {

  private static final String TAG = SymbolStreamLiveData.class.getSimpleName();
  private StockTwitsModel model;
  private String symbol;

  SymbolStreamLiveData(StockTwitsModel model, String symbol) {
    this.model = model;
    this.symbol = symbol;
    load();
  }

  private void load() {
    //if (symbol == null || symbol.length() == 0) return;
    model.getSymbolStream(symbol).enqueue(new Callback<SymbolStream>() {
      @Override
      public void onResponse(Call<SymbolStream> call, Response<SymbolStream> response) {
        setValue(response.body());
      }

      @Override
      public void onFailure(Call<SymbolStream> call, Throwable t) {
        // TODO: 2/20/18 omplement
        Log.i(TAG, "onFailure: " + t.getMessage());
      }
    });
  }
}
