package kritika.in.collegeapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import kritika.in.collegeapp.R;
import kritika.in.collegeapp.utils.CollegeAppPreference;

public class HomePageActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private MyHomePageViewPagerAdapter myHomePageViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        myHomePageViewPagerAdapter = new MyHomePageViewPagerAdapter(getSupportFragmentManager());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String message;
        message = CollegeAppPreference.getUSERNAME();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.homepage_tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.homepage_viewpager);
        viewPager.setAdapter(myHomePageViewPagerAdapter);
        tabLayout.setTabsFromPagerAdapter(myHomePageViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        TextView rollno = (TextView) findViewById(R.id.roll_no_txt);
        rollno.setText(message);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
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
        } else if (id == R.id.btn_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_attendance) {
            intent = new Intent(getApplicationContext(), AttendanceActivity.class);

            // Handle the camera action
        } else if (id == R.id.nav_annapurna) {
            intent = new Intent(getApplicationContext(), AnnapurnaActivity.class);

        } else if (id == R.id.nav_exam) {
            intent = new Intent(getApplicationContext(), ExamScheduleActivity.class);

        } else if (id == R.id.nav_cgpacal) {
            intent = new Intent(getApplicationContext(), CGPAMainActivity.class);

        } else if (id == R.id.nav_placement) {

        } else if (id == R.id.nav_webview) {

        }

        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static class MyHomePageFragment extends Fragment {

        public MyHomePageFragment() {

        }

        public static MyHomePageFragment newInstance(int pageno) {
            MyHomePageFragment f = new MyHomePageFragment();
            return f;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_homepage_viewpager, container, false);
            TextView hompage_txt = (TextView) view.findViewById(R.id.viewpager_txt);
            hompage_txt.setText("hi");
            return view;
        }

    }

    class MyHomePageViewPagerAdapter extends FragmentStatePagerAdapter {
        public MyHomePageViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyHomePageFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + position;
        }

    }
}