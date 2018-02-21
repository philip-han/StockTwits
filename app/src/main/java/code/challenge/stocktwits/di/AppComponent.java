package code.challenge.stocktwits.di;

import android.app.Application;

import javax.inject.Singleton;

import code.challenge.stocktwits.StockTwitsApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    NetworkModule.class,
    ActivityBuilder.class })

public interface AppComponent {
  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    AppComponent build();
  }

  void inject(StockTwitsApplication app);
}
