package ayush.practice.retrofitwithdagger_mvp1.application;

import android.app.Application;

import ayush.practice.retrofitwithdagger_mvp1.dagger.component.DaggerNetworkingComponent;
import ayush.practice.retrofitwithdagger_mvp1.dagger.component.NetworkingComponent;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.AppModule;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.NetworkingModule;

/**
 * Created by Ayush Jain on 4/29/17.
 */

public class RetrofitWithDaggerMVP extends Application {

    private NetworkingComponent mNetworkingComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mNetworkingComponent = DaggerNetworkingComponent.builder()
                .appModule(new AppModule(this))
                .networkingModule(new NetworkingModule("YOUR_BASE_URL"))
                .build();

    }

    public NetworkingComponent getmNetworkingComponent()
    {
        return mNetworkingComponent;
    }
}
