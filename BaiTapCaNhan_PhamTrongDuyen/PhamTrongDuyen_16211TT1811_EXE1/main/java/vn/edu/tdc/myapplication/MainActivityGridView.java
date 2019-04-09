package vn.edu.tdc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityGridView extends AppCompatActivity {


    private  CustomAdapterListView adapter;
    private GridView gridView;
    private static ArrayList<DataModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);
        gridView = (GridView) findViewById(R.id.my_gridview);
        Toast.makeText(getApplicationContext(),"gridview",Toast.LENGTH_SHORT).show();

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

       adapter = new CustomAdapterListView(this,R.layout.listview_layout,data);
        gridView.setAdapter(adapter);
    }

}