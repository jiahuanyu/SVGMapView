package com.jiahuan.svgmapview.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity
{

    private ListView mSelectListView;
    private ArrayAdapter<String> mAdapter;
    private Class[] mClasses = {BasicActivity.class, OperationActivity.class,LocationOverlayActivity.class,SparkActivity.class,CustomOverlayActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }


    private void initialize()
    {
        mSelectListView = (ListView) findViewById(R.id.main_select_lv);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.activity_select_array));
        mSelectListView.setAdapter(mAdapter);
        mSelectListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(new Intent(MainActivity.this, mClasses[position]));
            }
        });
    }


}
