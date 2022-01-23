package com.example.muslimguide;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HelpSpicialNeed extends AppCompatActivity implements OnMapReadyCallback {
    EditText name_help, phone_help;
    Button discover_help;
    String name_help_tx, phone_help_tx;
    String s;
    GoogleMap mMap;
    Location location;

    FirebaseAuth fauth;
    FirebaseFirestore fStore;

    private static final int REQUEST = 112;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_spicial_need);

        name_help = findViewById(R.id.name_help);
        phone_help = findViewById(R.id.phone_help);

        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener();

        if (Build.VERSION.SDK_INT >= 23) {
            String[] PERMISSIONS = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION};
            if (!hasPermissions(getApplicationContext(), PERMISSIONS)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST);
            } else {


                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
            }
        } else {


            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        discover_help = findViewById(R.id.discover_help);
        discover_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_help_tx = name_help.getText().toString();
                phone_help_tx = phone_help.getText().toString();

                if (name_help_tx.isEmpty()) {
                    name_help.setError("Enter your name");
                    return;
                }

                if (phone_help_tx.isEmpty()) {
                    phone_help.setError("Enter your phone number");
                    return;
                }


                DocumentReference groupReference = fStore.collection("HelpSpecialNeed").document();

                Map<String, Object> data = new HashMap<>();
                data.put("name", name_help_tx);
                data.put("phone", phone_help_tx);
                data.put("Latitude", String.valueOf(location.getLatitude()));
                data.put("Longitude", String.valueOf(location.getLongitude()));
                groupReference.set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                startActivity(new Intent(getApplicationContext(), MuslimHomePage.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "onFailure: " + e.toString());
                            }
                        });


            }
        });

    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;


    }

    private class MyLocationListener implements LocationListener {


        @Override
        public void onLocationChanged(Location loc) {

            location = loc;
            LatLng mloc = new LatLng(location.getLatitude(), location.getLongitude());

            mMap.moveCamera(CameraUpdateFactory.newLatLng(mloc));

            mMap.addMarker(new MarkerOptions()
                    .position(mloc));
        }

    }
}