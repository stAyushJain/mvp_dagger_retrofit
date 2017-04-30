package ayush.practice.retrofitwithdagger_mvp1.dagger.module;

import ayush.practice.retrofitwithdagger_mvp1.dagger.scope.CustomeScope;
import ayush.practice.retrofitwithdagger_mvp1.gui.maininterface.MainInterface;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ayush Jain on 4/29/17.
 */
@Module
public class MainScreenModule {

    private final MainInterface.View mView;


    public MainScreenModule(MainInterface.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomeScope
    MainInterface.View providesMainScreenContractView() {
        return mView;
    }
}
