package app.capstoneproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.capstoneproject.R;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        setTitle(getString(R.string.create_activity_title));
    }
}
