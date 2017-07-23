package com.example.kazz.quick_chat_project;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class QuickActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TextView tab1;
    private TextView tab2;
    private TextView tab3;

    final int[] ICONS = new int[]{
            R.drawable.ic_action_name,
            R.drawable.ic_earth,
            R.drawable.ic_user
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        tab1 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab1.setCompoundDrawablesWithIntrinsicBounds(0, ICONS[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(tab1);
        tab1.setScaleX(1.0f);
        tab1.setScaleY(1.0f);

        tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab2.setCompoundDrawablesWithIntrinsicBounds(0, ICONS[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(tab2);
        tab2.setScaleX(1.0f);
        tab2.setScaleY(1.0f);

        tab3 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab3.setCompoundDrawablesWithIntrinsicBounds(0, ICONS[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(tab3);
        tab3.setScaleX(1.0f);
        tab3.setScaleY(1.0f);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    tab1.setScaleX(1.5f);
                    tab1.setScaleY(1.5f);
                    tab2.setScaleX(1.0f);
                    tab2.setScaleY(1.0f);
                    tab3.setScaleX(1.0f);
                    tab3.setScaleY(1.0f);
                }else if(tab.getPosition() == 1){
                    tab1.setScaleX(1.0f);
                    tab1.setScaleY(1.0f);
                    tab2.setScaleX(1.3f);
                    tab2.setScaleY(1.3f);
                    tab3.setScaleX(1.0f);
                    tab3.setScaleY(1.0f);
                }else if(tab.getPosition() == 2){
                    tab1.setScaleX(1.0f);
                    tab1.setScaleY(1.0f);
                    tab2.setScaleX(1.0f);
                    tab2.setScaleY(1.0f);
                    tab3.setScaleX(1.5f);
                    tab3.setScaleY(1.5f);
                }
                //Toast.makeText(QuickActivity.this, "tabSelected:  " + tab.getPosition(), Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Toast.makeText(QuickActivity.this, "tabReSelected:  " + tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quick, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    Timeline timeline = new Timeline();
                    return timeline;
                case 1:
                    Ecoline ecoline = new Ecoline();
                    return ecoline;
                case 2:
                    Userline userline = new Userline();
                    return userline;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }


    }
}
