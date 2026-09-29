package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

// Android makes a "Binding" class for every layout file (XML file).
// It gives us easy access to the views (like buttons) in that file.
// We use it so we don't have to call findViewById() by hand.
import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

// This is the only Activity (screen holder) in the app.
// It shows the toolbar at the top and holds a "nav host" where the real
// screens (Fragments) like FirstFragment and SecondFragment appear.
public class MainActivity extends AppCompatActivity {

    // Tells the toolbar which screens are "main" screens (no back arrow).
    private AppBarConfiguration appBarConfiguration;

    // Holds all the views from activity_main.xml.
    private ActivityMainBinding binding;

    // onCreate() runs first when the Activity is made.
    // We set up the screen here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Always call the parent method first.
        super.onCreate(savedInstanceState);

        // Load the layout file (activity_main.xml) and show it on screen.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Use our own toolbar from the layout as the app bar.
        setSupportActionBar(binding.toolbar);

        // Get the NavController. It controls which Fragment is shown.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Set up which screens count as "top" screens for the toolbar.
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        // Connect the toolbar to the NavController.
        // Now the toolbar title and back arrow update automatically.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Run this code when the round button (FAB) is tapped.
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show a small message at the bottom of the screen.
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    // This runs once, to build the menu shown in the toolbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // This runs when the user taps a menu item.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // If we don't handle it, let the parent class try.
        return super.onOptionsItemSelected(item);
    }

    // This runs when the user taps the back arrow in the toolbar.
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
