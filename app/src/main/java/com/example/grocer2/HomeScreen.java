package com.example.grocer2;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.grocer2.ui.helpdialog.HelpDialogFragment;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void displayHelp(View view) {
        DialogFragment newHelpFragment = new HelpDialogFragment();
        newHelpFragment.show(getSupportFragmentManager(), "HelpDialog");
    }
}
