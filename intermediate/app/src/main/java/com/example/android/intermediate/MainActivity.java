package com.example.android.intermediate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


    
}
