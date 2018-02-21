package code.challenge.stocktwits.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Module
public class AppModule {

  @Provides
  @Singleton
  Context provideContext(Application application) {
    return application;
  }

}
