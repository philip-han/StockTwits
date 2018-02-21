package code.challenge.stocktwits.di;

import code.challenge.stocktwits.MainActivity;
import code.challenge.stocktwits.MessagesActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philip K. Han on 2/20/18.
 */

@Module
public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = MainActivityModule.class)
  abstract MainActivity bindMainActivity();

  @ContributesAndroidInjector(modules = MessagesActivityModule.class)
  abstract MessagesActivity bindMessagesActivity();

}
