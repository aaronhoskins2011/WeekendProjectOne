package com.example.aaron.weekendprojectone;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ArrayAdapter<String> mAdapter;
    private Menu menu;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (RelativeLayout)findViewById(R.id.mainLayout);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.lvDrawerList);
        addDrawerItems();
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        addEMICalculator(view);
                        Toast.makeText(MainActivity.this, "Starting EMI", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        addSecondActivity(view);
                        Toast.makeText(MainActivity.this, "Starting Media Player", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Activity 3", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        });

    }

    private void addDrawerItems(){
        String[] programTitles = {"EMI Calculator", "Media Player" , "Activity 3"};
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,programTitles);
        drawerList.setAdapter(mAdapter);

    }
    private void addEMICalculator(View view){
        Intent intent = new Intent(this, EMI_Calculator.class);
        intent.setAction("starting emi");
        startActivity(intent);

    }
    private void addSecondActivity(View view){
        Intent intent = new Intent(this, Media_Activity.class);
        intent.setAction("starting emi");
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.actBackgroundOne:
                Log.d("MENU", "onOptionsItemSelected: BackgoundOne");
                mainLayout.setBackgroundResource(R.drawable.background_one);
                break;
            case R.id.actBackgroundTwo:
                Log.d("MENU", "onOptionsItemSelected: BackgroundTwo");
                mainLayout.setBackgroundResource(R.drawable.background_two);
                break;
            case R.id.actBackgroundDefualt:
                Log.d("MENU", "onOptionsItemSelected: BackgroundDefault");
                mainLayout.setBackgroundResource(R.drawable.default_backround);
                break;
        }








        return true;
    }

}
