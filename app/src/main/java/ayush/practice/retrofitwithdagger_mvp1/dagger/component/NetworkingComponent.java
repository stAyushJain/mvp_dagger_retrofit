package ayush.practice.retrofitwithdagger_mvp1.dagger.component;

import javax.inject.Singleton;

import ayush.practice.retrofitwithdagger_mvp1.dagger.module.AppModule;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.NetworkingModule;
import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

/**
 * Created by Ayush Jain on 4/29/17.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkingModule.class})
public interface NetworkingComponent {

    Retrofit getRetrofitInstance();
}
