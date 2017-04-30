package ayush.practice.retrofitwithdagger_mvp1.dagger.component;

import ayush.practice.retrofitwithdagger_mvp1.gui.view.MainActivity;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.MainScreenModule;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.NetworkingModule;
import ayush.practice.retrofitwithdagger_mvp1.dagger.scope.CustomeScope;
import dagger.Component;

/**
 * Created by Ayush Jain on 4/29/17.
 */

@CustomeScope
@Component(dependencies = NetworkingComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
