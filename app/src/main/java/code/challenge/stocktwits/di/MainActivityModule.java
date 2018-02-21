package code.challenge.stocktwits.di;

import android.arch.lifecycle.ViewModelProviders;

import code.challenge.stocktwits.MainActivity;
import code.challenge.stocktwits.model.StockTwitsAPI;
import code.challenge.stocktwits.model.StockTwitsModel;
import code.challenge.stocktwits.viewModel.TrendingViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Module
public class MainActivityModule {

  @Provides
  StockTwitsModel provideStockTwitsModel(StockTwitsAPI stockTwitsAPI) {
    return new StockTwitsModel(stockTwitsAPI);
  }

  @Provides
  TrendingViewModel provideTrendingViewModel(MainActivity activity, StockTwitsModel model){
    TrendingViewModel viewModel = ViewModelProviders.of(activity).get(TrendingViewModel.class);
    viewModel.setModel(model);
    return viewModel;
  }

}
