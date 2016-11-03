package com.danielacedo.tabstest;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class TabTestActivity extends AppCompatActivity {

    FragmentTabHost fth_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        fth_main = (FragmentTabHost)findViewById(R.id.fth_main);

        fth_main.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        for(int i = 1; i < 5; i++){
            View indicator = getTabIndicator(this, "Pestaña "+i);
            TabHost.TabSpec spec = fth_main.newTabSpec("Contenido de pestaña "+i).setIndicator(indicator);
            fth_main.addTab(spec, TestFragment.class, null);
        }

    }

    private View getTabIndicator(Context context, String title){
        View v = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);

        TextView txv_tab_title = (TextView)v.findViewById(R.id.txv_tab_title);
        txv_tab_title.setText(title);

        return v;
    }
}