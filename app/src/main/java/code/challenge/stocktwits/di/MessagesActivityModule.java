package code.challenge.stocktwits.di;

import android.arch.lifecycle.ViewModelProviders;

import code.challenge.stocktwits.MessagesActivity;
import code.challenge.stocktwits.model.StockTwitsAPI;
import code.challenge.stocktwits.model.StockTwitsModel;
import code.challenge.stocktwits.viewModel.SymbolStreamViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Module
public class MessagesActivityModule {

  @Provides
  StockTwitsModel provideStockTwitsModel(StockTwitsAPI stockTwitsAPI) {
    return new StockTwitsModel(stockTwitsAPI);
  }

  @Provides
  SymbolStreamViewModel provideSymbolStreamViewModel(MessagesActivity activity, StockTwitsModel model){
    SymbolStreamViewModel viewModel = ViewModelProviders.of(activity).get(SymbolStreamViewModel.class);
    viewModel.setModel(model);
    return viewModel;
  }

}
