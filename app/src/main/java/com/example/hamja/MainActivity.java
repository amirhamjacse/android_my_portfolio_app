package com.example.hamja;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hamja.SkillsFragment;
import com.example.hamja.ProjectsFragment;
import com.example.hamja.ContactFragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        tabLayout = findViewById(R.id.tab_layout);

        setupTabs();

        // Load the default fragment
        loadFragment(new SkillsFragment());
    }

    private void setupTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("Skills"));
        tabLayout.addTab(tabLayout.newTab().setText("Projects"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new SkillsFragment();
                        break;
                    case 1:
                        fragment = new ProjectsFragment();
                        break;
                    case 2:
                        fragment = new ContactFragment();
                        break;
                }
                loadFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tab_content, fragment)
                    .commit();
        }
    }
}
