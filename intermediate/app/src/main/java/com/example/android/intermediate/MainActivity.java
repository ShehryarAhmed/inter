package com.example.android.intermediate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.intermediate.utilities.Networkutilities;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText mSearchBoxEditText;

    TextView mURLDisplayTextview;

    TextView mSearchResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.ed_search_box);

        mURLDisplayTextview = (TextView)findViewById(R.id.tv_display_url);

        mSearchResult   = (TextView) findViewById(R.id.tv_github_search_result);


    }


    private void makeGithubSearchQuery(){
        String githubquery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = Networkutilities.buildUrl(githubquery);
        mURLDisplayTextview.setText(githubSearchUrl.toString());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == R.id.action_search){
        makeGithubSearchQuery();
        }
        return super.onOptionsItemSelected(item);
    }
}
