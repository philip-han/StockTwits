package code.challenge.stocktwits.viewModel;

import android.arch.lifecycle.ViewModel;

import code.challenge.stocktwits.model.StockTwitsModel;
import code.challenge.stocktwits.model.SymbolStreamLiveData;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class SymbolStreamViewModel extends ViewModel {

  private StockTwitsModel model;

  public void setModel(StockTwitsModel model) {
    this.model = model;
  }

  public SymbolStreamLiveData getSymbolStreamLiveData(String symbol) {
    return model.getSymbolStreamLiveData(symbol);
  }

}
