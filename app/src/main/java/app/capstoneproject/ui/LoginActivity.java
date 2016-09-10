package app.capstoneproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import app.capstoneproject.R;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {
    private static String TAG="LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.signInbutton, R.id.google_button, R.id.forgotClick, R.id.createClick})
    public void signIn(View v) {
        switch (v.getId()) {
            case R.id.signInbutton: {
                Toast.makeText(this, "Login Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.google_button: {
                Toast.makeText(this, "Google Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.forgotClick: {
                Intent intent=new Intent(this,ForgotActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.createClick: {
                Intent intent=new Intent(this,CreateActivity.class);
                startActivity(intent);
                break;

            }
        }
    }

}
