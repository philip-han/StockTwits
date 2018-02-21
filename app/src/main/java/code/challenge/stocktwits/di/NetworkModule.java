package code.challenge.stocktwits.di;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import code.challenge.stocktwits.R;
import code.challenge.stocktwits.model.StockTwitsAPI;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Module
public class NetworkModule {

  @Provides
  HttpLoggingInterceptor provideLoggingInterceptor() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return loggingInterceptor;
  }

  @Provides
  @Singleton
  OkHttpClient provideHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS);
    return builder.build();
  }


  @Provides
  @Singleton
  MoshiConverterFactory provideMoshiConverterFactory() {
    return MoshiConverterFactory.create();
  }


  @Provides
  @Singleton
  StockTwitsAPI provideStockTwitsAPI(Context context, OkHttpClient httpClient, MoshiConverterFactory moshiConverterFactory) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(context.getString(R.string.stocktwits_base_url))
        .addConverterFactory(moshiConverterFactory)
        .client(httpClient)
        .build();
    return retrofit.create(StockTwitsAPI.class);
  }

}
