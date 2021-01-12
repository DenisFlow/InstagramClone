//package com.example.instagramclone;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.parse.FindCallback;
//import com.parse.GetCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//import com.parse.SaveCallback;
//import com.shashank.sony.fancytoastlib.FancyToast;
//
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText editName, editPunchPower, editPunchSpeed, editKickPower, editKickSpeed;
//    private Button buttonSaveResult, butonGetAllData, buttonSwitch;
//    private TextView txtData;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editName = findViewById(R.id.editName);
//        editPunchPower = findViewById(R.id.editPunchPower);
//        editKickPower = findViewById(R.id.editKickPower);
//        editKickSpeed = findViewById(R.id.editKickSpeed);
//        editPunchSpeed = findViewById(R.id.editPunchSpeed);
//        buttonSaveResult = findViewById(R.id.buttonSaveResult);
//        butonGetAllData = findViewById(R.id.buttonGetData);
//        buttonSwitch = findViewById(R.id.buttonSwitch);
//        txtData = findViewById(R.id.textView);
//
//        txtData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
//                parseQuery.getInBackground("BF8bXcWAWa", new GetCallback<ParseObject>() {
//                    @Override
//                    public void done(ParseObject object, ParseException e) {
//                        if (e == null){
//                            txtData.setText(object.get("name") + " Punch Power: " + object.get("punch_power"));
//                        }
//                    }
//                });
//            }
//        });
//
//        buttonSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        butonGetAllData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
//
//                parseQuery.whereGreaterThan("punch_power", 600);
//                parseQuery.setLimit(1);
//
//                parseQuery.findInBackground(new FindCallback<ParseObject>() {
//                    @Override
//                    public void done(List<ParseObject> objects, ParseException e) {
//                        if (e == null){
//                            if(objects.size() > 0){
//                                FancyToast.makeText(MainActivity.this, "Objects are taken successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                                String str = "";
//                                for (int i = 0; i < objects.size() - 1; i++) {
//                                    ParseObject object = objects.get(i);
//                                    str += object.get("name") + " Punch Power: " + object.get("punch_power") + "\n";
//                                }
//                                txtData.setText(str);
//                            }else{
//                                FancyToast.makeText(MainActivity.this, "Objects are not  taken", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                            }
//                        }
//                    }
//                });
//            }
//        });
//
//    }
//
//
//
//
//    public void fnClickSaveResult(View View) {
//        try {
//            int KickPower = Integer.parseInt(editKickPower.getText().toString());
//            int KickSpeed = Integer.parseInt(editKickSpeed.getText().toString());
//            int PunchPower = Integer.parseInt(editPunchPower.getText().toString());
//            int PunchSpeed = Integer.parseInt(editPunchSpeed.getText().toString());
//            String name = editName.getText().toString();
//
//            ParseObject kickBoxer = new ParseObject("KickBoxer");
//            kickBoxer.put("name", name);
//            kickBoxer.put("kick_speed", KickSpeed);
//            kickBoxer.put("kick_power", KickPower);
//            kickBoxer.put("punch_power", PunchPower);
//            kickBoxer.put("punch_speed", PunchSpeed);
//            kickBoxer.saveInBackground(new SaveCallback() {
//                @Override
//                public void done(ParseException e) {
//                    if (e == null) {
////                    Toast.makeText(MainActivity.this,  kickBoxer.get("name") + " object is saved successfully", Toast.LENGTH_LONG).show();
//                        FancyToast.makeText(MainActivity.this, kickBoxer.get("name") + " object is saved successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
//                    }
//                }
//            });
//        }catch (Exception e){
////                    Toast.makeText(MainActivity.this,  "Kick-boxer object is not saved successfully", Toast.LENGTH_LONG).show();
//            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
//
//        }
//    }
//}