package code.challenge.stocktwits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import code.challenge.stocktwits.model.TrendingLiveData;
import code.challenge.stocktwits.viewModel.TrendingViewModel;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  @Inject
  TrendingViewModel viewModel;
  private RecyclerView trendingRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    setContentView(R.layout.activity_main);
    trendingRecyclerView = findViewById(R.id.tredingRecyclerView);
    trendingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    TrendingLiveData result = viewModel.getTrendingLiveData();
    result.observe(this, trending -> {
      trendingRecyclerView.setAdapter(new TrendingAdapter(trending, symbol -> launchSymbolStreamActivity(symbol)));
    });
  }

  private void launchSymbolStreamActivity(String symbol) {
    Intent intent = new Intent(this, MessagesActivity.class);
    intent.putExtra("symbol", symbol);
    startActivity(intent);
  }

}

