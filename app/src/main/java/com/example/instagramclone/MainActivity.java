package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPunchPower, editPunchSpeed, editKickPower, editKickSpeed;
    Button buttonSaveResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editPunchPower = findViewById(R.id.editPunchPower);
        editKickPower = findViewById(R.id.editKickPower);
        editKickSpeed = findViewById(R.id.editKickSpeed);
        editPunchSpeed = findViewById(R.id.editPunchSpeed);
        buttonSaveResult = findViewById(R.id.buttonSaveResult);
    }




    public void fnClickSaveResult(View View) {
        try {
            int KickPower = Integer.parseInt(editKickPower.getText().toString());
            int KickSpeed = Integer.parseInt(editKickSpeed.getText().toString());
            int PunchPower = Integer.parseInt(editPunchPower.getText().toString());
            int PunchSpeed = Integer.parseInt(editPunchSpeed.getText().toString());
            String name = editName.getText().toString();

            ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name", name);
            kickBoxer.put("kick_speed", KickSpeed);
            kickBoxer.put("kick_power", KickPower);
            kickBoxer.put("punch_power", PunchPower);
            kickBoxer.put("punch_speed", PunchSpeed);
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
//                    Toast.makeText(MainActivity.this,  kickBoxer.get("name") + " object is saved successfully", Toast.LENGTH_LONG).show();
                        FancyToast.makeText(MainActivity.this, kickBoxer.get("name") + " object is saved successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    }
                }
            });
        }catch (Exception e){
//                    Toast.makeText(MainActivity.this,  "Kick-boxer object is not saved successfully", Toast.LENGTH_LONG).show();
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

        }
    }
}