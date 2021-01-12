package com.example.instagramclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileTab extends Fragment {
    private Button buttonUpdateInfo;
    private EditText editTextProfileBio, editTextProfileHobbies, editTextProfileName, editTextProfileProfession, editTextProfileSport;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileTab.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileTab newInstance(String param1, String param2) {
        ProfileTab fragment = new ProfileTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);
        editTextProfileName =  view.findViewById(R.id.editTextProfileName);
        editTextProfileBio =  view.findViewById(R.id.editTextProfileBio);
        editTextProfileHobbies =  view.findViewById(R.id.editTextProfileHobbies);
        editTextProfileProfession =  view.findViewById(R.id.editTextProfileProfession);
        editTextProfileSport =  view.findViewById(R.id.editTextProfileSport);



        buttonUpdateInfo = view.findViewById(R.id.buttonUpdateInfo);

        final ParseUser parseUser = ParseUser.getCurrentUser();

        if (!parseUser.get("profileName").equals(null)){
            editTextProfileName.setText(parseUser.get("profileName") + "");

        }
        if (!parseUser.get("profileBio").equals(null)){
            editTextProfileBio.setText(parseUser.get("profileBio") + "");

        }
        if (!parseUser.get("profileHobbies").equals(null)){
            editTextProfileHobbies.setText(parseUser.get("profileHobbies") + "");

        }
        if (!parseUser.get("profileProfession").equals(null)){
            editTextProfileProfession.setText(parseUser.get("profileProfession") + "");

        }
        if (!parseUser.get("profileSport").equals(null)){
            editTextProfileSport.setText(parseUser.get("profileSport") + "");

        }

        buttonUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("profileName", editTextProfileName.getText().toString());
                parseUser.put("profileBio", editTextProfileBio.getText().toString());
                parseUser.put("profileHobbies", editTextProfileHobbies.getText().toString());
                parseUser.put("profileProfession", editTextProfileProfession.getText().toString());
                parseUser.put("profileSport", editTextProfileSport.getText().toString());

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            FancyToast.makeText(getContext(), "Info updated!", FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
                        }else{
                            FancyToast.makeText(getContext(), "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

        return view;
    }
}