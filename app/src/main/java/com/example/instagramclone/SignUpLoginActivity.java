package com.example.instagramclone;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {
    EditText editUserNameSignUp, editPasswordSignUp, editPasswordLogIn, editUserNameLogIn;
    Button buttonSignUp, buttonLogIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_login_activity);

        editUserNameSignUp = findViewById(R.id.editUserNameSignUp);
        editPasswordSignUp = findViewById(R.id.editPasswordSignUp);
        editPasswordLogIn = findViewById(R.id.editPasswordLogIn);
        editUserNameLogIn = findViewById(R.id.editUserNameLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonLogIn = findViewById(R.id.buttonLogIn);

        editUserNameSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
                editPasswordSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        editPasswordLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        editUserNameLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser appUser = new ParseUser();
                appUser.setUsername(editUserNameSignUp.getText().toString());
                appUser.setPassword(editPasswordSignUp.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            FancyToast.makeText(SignUpLoginActivity.this, appUser.getUsername() + " sing up successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        }else{
                            FancyToast.makeText(SignUpLoginActivity.this, "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ParseUser.logInInBackground(editUserNameLogIn.getText().toString(), editPasswordLogIn.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (e == null){
                                    FancyToast.makeText(SignUpLoginActivity.this, user.getUsername() + " sing in successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                }else{
                                    FancyToast.makeText(SignUpLoginActivity.this, "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                }
                            }
                        });
                    }
                });

    }
}
