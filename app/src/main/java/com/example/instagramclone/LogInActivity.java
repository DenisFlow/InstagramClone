package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        editPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(buttonLogIn);
                }
                return false;
            }
        });
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

    public void rootLayoutTapped(View View){
        try {


            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fnSignUpSwitch() {
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }


}
