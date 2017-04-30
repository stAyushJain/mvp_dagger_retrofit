package ayush.practice.retrofitwithdagger_mvp1.gui.presenter;

import java.util.Map;
import ayush.practice.retrofitwithdagger_mvp1.gui.maininterface.MainInterface;
import ayush.practice.retrofitwithdagger_mvp1.gui.model.Post;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

import javax.inject.Inject;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by Ayush Jain on 4/29/17.
 */

public class MainScreenPresenter implements MainInterface.Presenter {

    Retrofit retrofit;
    MainInterface.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainInterface.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPost(String subUrl, Map<String , String> params) {

//      with RxJava
        retrofit.create(PostService.class)
                .getPostList(subUrl, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Post>() {


                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.showComplete();
                    }


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Post posts) {
                        mView.showPosts(posts);
                    }
                });

//        withOut RxJava, useed simple Call<T>

//        Call<Post> call = retrofit.create(PostService.class)
//                .getPostList(subUrl, params);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });
    }

    private interface PostService {

//        with RxJava
        @FormUrlEncoded
        @POST
        Observable<Post> getPostList(@Url String subUrl, @FieldMap Map<String, String> params);

//        without RXjava
//        @FormUrlEncoded
//        @POST
//        Call<Post> getPostList(@Url String subUrl, @FieldMap Map<String, String> params);


//      uploading image or images with Param or params
//        @Multipart
//        @POST("/profileUpdate")
//        Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("employeeId") RequestBody name);



        //    @FormUrlEncoded
//    @POST("/api.php")
//    void postData(@Field("method") String method,
//                  @Field("username") String username,
//                  @Field("password") String password);
//
//    //This method is used for "GET"
//    @GET("/api.php")
//    void getData(@Query("method") String method,
//                 @Query("username") String username,
//                 @Query("password") String password);
    }
}