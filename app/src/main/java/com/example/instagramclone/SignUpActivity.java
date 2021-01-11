package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editUserName, editUserMail, editPassword;
    private Button buttonSignUp, buttonLogInSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setTitle("Sign Up");

        editUserMail = findViewById(R.id.editUserMaiSignUp);
        editUserName = findViewById(R.id.editUserNameSignUp);
        editPassword = findViewById(R.id.editPasswordSignUp);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonLogInSwitch = findViewById(R.id.buttonLogInSwitch);

        buttonSignUp.setOnClickListener(this);
        buttonLogInSwitch.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSignUp:
                fnSignUp();
                break;
            case R.id.buttonLogInSwitch:
                fnLogInSwitch();
                break;
        }
    }

    public void fnSignUp() {
        final ParseUser appUser = new ParseUser();
        appUser.setUsername(editUserName.getText().toString());
        appUser.setPassword(editPassword.getText().toString());
        appUser.setEmail(editUserMail.getText().toString());

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing up" + editUserName.getText().toString());
        progressDialog.show();

        appUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    FancyToast.makeText(SignUpActivity.this, appUser.getUsername() + " sing up successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                            Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
//                            startActivity(intent);
                }else{
                    FancyToast.makeText(SignUpActivity.this, "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }
            }
        });

        progressDialog.dismiss();
    }

    public void fnLogInSwitch() {
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }

}