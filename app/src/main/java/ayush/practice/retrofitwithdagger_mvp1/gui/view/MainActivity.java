package ayush.practice.retrofitwithdagger_mvp1.gui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ayush.practice.retrofitwithdagger_mvp1.R;
import ayush.practice.retrofitwithdagger_mvp1.application.RetrofitWithDaggerMVP;
import ayush.practice.retrofitwithdagger_mvp1.dagger.component.DaggerMainScreenComponent;
import ayush.practice.retrofitwithdagger_mvp1.dagger.module.MainScreenModule;
import ayush.practice.retrofitwithdagger_mvp1.gui.maininterface.MainInterface;
import ayush.practice.retrofitwithdagger_mvp1.gui.model.Post;
import ayush.practice.retrofitwithdagger_mvp1.gui.presenter.MainScreenPresenter;

public class MainActivity extends AppCompatActivity implements MainInterface.View {
        ListView listView;
        ArrayList<String> list;
        ArrayAdapter<String> adapter;

@Inject
MainScreenPresenter mainPresenter;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_list);
        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
        .networkingComponent(((RetrofitWithDaggerMVP) getApplicationContext()).getmNetworkingComponent())
        .mainScreenModule(new MainScreenModule(this))
        .build().inject(this);

        //Call the method in MainPresenter to make Network Request
        Map<String, String> params = new HashMap<String, String>();
        params.put("mail","a@a.in");
        params.put("ken","70666");

        mainPresenter.loadPost("YOUR_SUBURL",params);
        }

@Override
public void showPosts(Post posts) {

    Toast.makeText(getApplicationContext(), "Success" , Toast.LENGTH_SHORT).show();
        //Loop through the posts and get the title of the post and add it to our list object
//        for (int i = 0; i < posts.size(); i++) {
//        list.add(posts.get(i).getTitle());
//        }
//        //Create the array adapter and set it to list view
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(adapter);
        }

@Override
public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

        }

@Override
public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();

        }
        }