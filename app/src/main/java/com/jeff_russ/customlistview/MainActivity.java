package com.jeff_russ.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // an array of Strings. Each element will be a list item
        String[] favoriteTVShows = {"Pushing Daisies","Better Off Ted","Twin Peaks","Freaks and Geeks",
                "Orphan Black", "Walking Dead", "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

        //  DECLARE A LIST ADAPTER -----------------------------------------------------

        /* The ListAdapter acts as a bridge between the data and each ListItem. You fill the ListView
        with a ListAdapter. You pass it a Context and a Layout.
        A Context which is a reference to the java Activity class represented by "this".
        android.R.layout.simple_list_item_1 is a predefined layout provided by Android */

        // This is the stock ArrayAdapter.Comment this out to try the other adapters
        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteTVShows);

        // This is a custom layout we made with our row_layout.xml layout. Comment out to try others.
        //ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, favoriteTVShows);

        // This is the custom ArrayAdapter we created in MyAdapter.java. Comment out to try others.
        // Since java file is associated with a layout we don't need it here as an arg.
        //ListAdapter theAdapter = new MyAdapter(this, favoriteTVShows);

        //  END DECLARE A LIST ADAPTER -----------------------------------------------------

        // associate java ListVew with xml ListView:
        ListView theListView = (ListView) findViewById(R.id.theListView);

        // assign our Adapter to our ListView object:
        theListView.setAdapter(theAdapter);

        // assign a click listener to our ListView object:
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tvShowPicked = "You selected " +
                        String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

