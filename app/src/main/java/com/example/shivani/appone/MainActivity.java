package com.example.shivani.appone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String[] languages = {"BASIC","C","COBOL","FORTRAN","JAVA","LOGO","PYTHON","RUBY ON RAILS","......"};
        String[] android = {"CUPCAKE","DONUT","ECLAIRS","FROYO","GINGERBREAD","HONEYCOMB","ICECREAM SANDWICH","JELLY BEAN","KITKAT",
        "LOLLIPOP","MARSHMALLOW","NOUGAT","......"};
        ListView listView=(ListView)findViewById(R.id.list);
        ListView listViewTwo=(ListView)findViewById(R.id.listTwo);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_items, languages);
        ArrayAdapter adapterTwo = new ArrayAdapter<String>(this,R.layout.list_items,android);


        listView.setAdapter(adapter);
        listViewTwo.setAdapter(adapterTwo);
        ListUtils.setDynamicHeight(listView);
        ListUtils.setDynamicHeight(listViewTwo);
    }
    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}
