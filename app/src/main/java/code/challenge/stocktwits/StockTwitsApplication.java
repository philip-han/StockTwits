package code.challenge.stocktwits;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import code.challenge.stocktwits.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class StockTwitsApplication extends Application implements HasActivityInjector {

  @Inject
  DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

  @Override
  public void onCreate() {
    super.onCreate();
    DaggerAppComponent
        .builder()
        .application(this)
        .build()
        .inject(this);
  }

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return activityDispatchingAndroidInjector;
  }

}
