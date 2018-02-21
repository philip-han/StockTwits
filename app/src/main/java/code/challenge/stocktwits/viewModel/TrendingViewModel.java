package code.challenge.stocktwits.viewModel;

import android.arch.lifecycle.ViewModel;

import code.challenge.stocktwits.model.StockTwitsModel;
import code.challenge.stocktwits.model.TrendingLiveData;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class TrendingViewModel extends ViewModel {

  private StockTwitsModel model;
  private TrendingLiveData trendingLiveData;

  public void setModel(StockTwitsModel model) {
    this.model = model;
  }

  public TrendingLiveData getTrendingLiveData() {
    return trendingLiveData == null ? trendingLiveData = model.getTrendingLiveData() : trendingLiveData;
  }

}
