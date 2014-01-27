
package com.teamluper.spawnofluper;

import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.teamluper.spawnofluper.rest.RestClient;

@EActivity(R.layout.activity_main)
public class MainActivity
    extends Activity
{

    @ViewById
    TextView hello;
    @RestService
    RestClient restClient;

    @AfterViews
    void afterViews() {
    }

    @UiThread
    void doSomethingElseOnUiThread() {
        hello.setText("Hi!");
    }

    @Background
    void doSomethingInBackground() {
        restClient.main();
        doSomethingElseOnUiThread();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater();
        return true;
    }

}
