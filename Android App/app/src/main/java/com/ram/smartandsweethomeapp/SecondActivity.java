package com.ram.smartandsweethomeapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity {


    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Switch acswitchbtn = (Switch) findViewById(R.id.acswitch);
        acswitchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked == true) {
                    aconfn();
                } else {
                    acofffn();
                }
            }

        });


        final Switch htswitchbtn = (Switch) findViewById(R.id.htswitch);
        htswitchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked == true) {
                    htonfn();
                } else {
                    htofffn();
                }
            }

        });


        final Switch tvswitchbtn = (Switch) findViewById(R.id.tvswitch);
        tvswitchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked == true) {
                    tvonfn();
                } else {
                    tvofffn();
                }
            }

        });


        final Switch setswitchbtn = (Switch) findViewById(R.id.setswitch);
        setswitchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked == true) {
                    setonfn();
                } else {
                    setofffn();
                }
            }

        });


        //AC Listener
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference ac_status = database.getReference("ac_status");


        ac_status.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);

                if (value != null) {
                    if (value == 1) {
                        acswitchbtn.setChecked(true);

                    } else {
                        acswitchbtn.setChecked(false);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        //HT Listener
        DatabaseReference home_status = database.getReference("home_status");


        home_status.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);

                if (value != null) {
                    if (value == 1) {
                        htswitchbtn.setChecked(true);

                    } else {
                        htswitchbtn.setChecked(false);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        //TV Listener
        DatabaseReference tv_status = database.getReference("tv_status");


        tv_status.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);

                if (value != null) {
                    if (value == 1) {
                        tvswitchbtn.setChecked(true);

                    } else {
                        tvswitchbtn.setChecked(false);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        //SET Listener
        DatabaseReference set_status = database.getReference("set_status");


        set_status.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);

                if (value != null) {
                    if (value == 1) {
                        setswitchbtn.setChecked(true);

                    } else {
                        setswitchbtn.setChecked(false);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });







    }






    private void aconfn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ac_status");

        myRef.setValue(1);

    }

    private void acofffn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ac_status");

        myRef.setValue(0);

    }

    private void htonfn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("home_status");

        myRef.setValue(1);

    }

    private void htofffn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("home_status");

        myRef.setValue(0);

    }

    private void tvonfn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tv_status");

        myRef.setValue(1);

    }

    private void tvofffn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tv_status");

        myRef.setValue(0);

    }

    private void setonfn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("set_status");

        myRef.setValue(1);

    }

    private void setofffn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("set_status");

        myRef.setValue(0);

    }






}
