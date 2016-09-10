package app.capstoneproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import app.capstoneproject.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        setTitle(getString(R.string.forgot_activity_title));
        ButterKnife.bind(this);
    }

    @OnClick(R.id.forgot_submit)
    public void submit(View v)
    {
        Toast.makeText(this,"SUBMIT clicked",Toast.LENGTH_SHORT).show();
    }

}
