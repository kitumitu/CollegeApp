package kritika.in.collegeapp.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kritika.in.collegeapp.R;
import kritika.in.collegeapp.utils.CollegeAppPreference;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if(CollegeAppPreference.getLoginStatus()){

                    i = new Intent(SplashScreen.this, HomePageActivity.class);
                }
                else{
                    i = new Intent(SplashScreen.this, LoginActivity.class);
                }

                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
