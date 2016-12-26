package com.example.android.intermediate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.intermediate.utilities.Networkutilities;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText mSearchBoxEditText;

    TextView mURLDisplayTextview;

    TextView mSearchResult;

    TextView mErrorMessageDisplay;

    ProgressBar mLoadingIndicator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.ed_search_box);

        mURLDisplayTextview = (TextView)findViewById(R.id.tv_display_url);

        mSearchResult   = (TextView) findViewById(R.id.tv_github_search_result);

        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.mProgressBar);


    }

    

    private void makeGithubSearchQuery(){
        String githubquery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = Networkutilities.buildUrl(githubquery);
        mURLDisplayTextview.setText(githubSearchUrl.toString());
        new GithubQueryTask().execute(githubSearchUrl);
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

    public class GithubQueryTask extends AsyncTask<URL ,Void ,String>{
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String githubSearchResult = null;
            try{
                githubSearchResult = Networkutilities.getResponseFromHttpUrl(searchUrl);
            }catch (IOException e){
                e.printStackTrace();
            }
            return githubSearchResult;
        }

        @Override
        protected void onPostExecute(String s) {
            if(s != null && s.equals("")){
                mSearchResult.setText(s);
            }
            else {
                mSearchResult.setText("nothing");
            }
        }
    }
}
