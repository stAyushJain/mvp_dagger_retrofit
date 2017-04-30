package ayush.practice.retrofitwithdagger_mvp1.gui.maininterface;

import java.util.List;
import java.util.Map;

import ayush.practice.retrofitwithdagger_mvp1.gui.model.Post;

/**
 * Created by Ayush Jain on 4/29/17.
 */

public interface MainInterface {
    interface View {
        void showPosts(Post posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost(String subUrl, Map<String , String> params);
    }
}
