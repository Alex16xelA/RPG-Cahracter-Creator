package pl.wroc.pwr.a236139.rpgcharactercreator;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNavigation;
    private FrameLayout mMainFrame;

    private CreateFragment createFragment;
    private HistoryFragment historyFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNavigation = (BottomNavigationView) findViewById(R.id.main_navigation);

        createFragment = new CreateFragment();
        historyFragment = new HistoryFragment();
        settingsFragment = new SettingsFragment();

        setFragment(createFragment);

        mMainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_create:
                        setFragment(createFragment);
                        return true;
                    case R.id.navigation_history:
                        setFragment(historyFragment);
                        return true;
                    case R.id.navigation_settings:
                        setFragment(settingsFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
