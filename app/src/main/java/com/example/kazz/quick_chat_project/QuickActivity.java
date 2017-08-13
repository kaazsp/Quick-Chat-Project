package com.example.kazz.quick_chat_project;

import android.content.Intent;
import android.os.Build;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import com.google.firebase.auth.FirebaseAuth;


public class QuickActivity extends AppCompatActivity {

    private static boolean AAC_SUPPORTED  = Build.VERSION.SDK_INT >= 10;
    private MediaRecorder audioAAC;
    private String outputFile, outputFile2;
    private boolean rec = false;
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

    private static final File FILES_PATH = new File(
            Environment.getExternalStorageDirectory(),
            "Android/data/com.soundcloud.android.examples/files");

    private static final File RECORDING = new File(
            FILES_PATH,
            "demo-recording" + (AAC_SUPPORTED ? ".mp4" : "3gp"));

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        outputFile2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aud4.mp4";

     //   audioAAC = new MediaRecorder();
    //    audioAAC.setAudioSource(MediaRecorder.AudioSource.MIC);
    //    audioAAC.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
     //   audioAAC.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
     //   audioAAC.setAudioSamplingRate(44100);
     //   audioAAC.setAudioEncodingBitRate(96000);
      //  audioAAC.setAudioChannels(1);
      //  audioAAC.setOutputFile(outputFile2);

  /*      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
*/
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rec = !rec;
                if (rec == true){
                    try {
                        audioAAC.prepare();
                        audioAAC.start();
                    } catch (IllegalStateException iser){ }
                    catch (IOException ioe){}

                    Toast.makeText(getApplicationContext(), "Iniciou da gravação!", Toast.LENGTH_LONG).show();
                }
                else if(rec == false){
                    audioAAC.stop();
                    audioAAC.release();
                    Toast.makeText(getApplicationContext(), "Gravação salva!", Toast.LENGTH_LONG).show();
                }
            }
        });*/

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

                    tab1.animate().scaleX(1.5f).start();
                    tab1.animate().scaleY(1.5f).start();
                    tab2.animate().scaleX(1.0f).start();
                    tab2.animate().scaleY(1.0f).start();
                    tab3.animate().scaleX(1.0f).start();
                    tab3.animate().scaleY(1.0f).start();

                }else if(tab.getPosition() == 1){

                    tab2.animate().scaleX(1.3f).start();
                    tab2.animate().scaleY(1.3f).start();
                    tab1.animate().scaleX(1.0f).start();
                    tab1.animate().scaleY(1.0f).start();
                    tab3.animate().scaleX(1.0f).start();
                    tab3.animate().scaleY(1.0f).start();

                }else if(tab.getPosition() == 2){

                    tab1.animate().scaleX(1.0f).start();
                    tab1.animate().scaleY(1.0f).start();
                    tab2.animate().scaleX(1.0f).start();
                    tab2.animate().scaleY(1.0f).start();
                    tab3.animate().scaleX(1.5f).start();
                    tab3.animate().scaleY(1.5f).start();
                }
                //Toast.makeText(QuickActivity.this, "tabSelected:  " + tab.getPosition(), Toast.LENGTH_SHORT).show();
                mViewPager.setCurrentItem(tab.getPosition(),false);

                 mAuth.addAuthStateListener(mAuthListener);
                mAuth = FirebaseAuth.getInstance();

                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if (firebaseAuth.getCurrentUser() == null){
                            startActivity(new Intent(QuickActivity.this, LoginActivity.class));
                        }
                    }
                };


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
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
            return 3;
        }

    }

    @Override
    protected void onStart() {
       // Log.i(getPackageName(), "onStart()");
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onResume() {
        Log.i(getPackageName(), "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(getPackageName(), "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(getPackageName(), "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(getPackageName(), "onDestroy()");
        super.onDestroy();
    }

}
