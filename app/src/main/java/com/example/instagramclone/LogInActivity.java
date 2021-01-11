package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editUserMail, editPassword;
    private Button buttonSignUpSwitch, buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        setTitle("Log In");

        editUserMail = findViewById(R.id.editUserMailLogIn);
        editPassword = findViewById(R.id.editPasswordLogIn);
        buttonSignUpSwitch = findViewById(R.id.buttonSignUpSwitch);
        buttonLogIn = findViewById(R.id.buttonLogIn);

        buttonLogIn.setOnClickListener(this);
        buttonSignUpSwitch.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogIn:
                fnLogIn();
            break;
            case R.id.buttonSignUpSwitch:
                fnSignUpSwitch();
                break;
        }
    }

    public void fnLogIn() {

        if (ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }

        ParseUser.logInInBackground(editUserMail.getText().toString(), editPassword.getText().toString() ,new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null){
                    FancyToast.makeText(LogInActivity.this, user.getUsername() + " sing in successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                            Intent intent = new Intent(LogInActivity.this, WelcomeActivity.class);
//                            startActivity(intent);
                }else{
                    FancyToast.makeText(LogInActivity.this, "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }
            }
        });
    }

    public void fnSignUpSwitch() {
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

}
