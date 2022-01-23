package com.example.muslimguide;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class GroupTracking extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    Location location;


    FirebaseAuth fauth;
    FirebaseUser muser;
    FirebaseFirestore fStore;

    private static final int REQUEST = 112;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_tracking);

        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        muser = fauth.getCurrentUser();

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new GroupTracking.MyLocationListener();

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

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng( 21.4235,39.8256),12));

        getgroupmember();


    }

    private void getgroupmember() {


        fStore.collection("Group").document(muser.getUid()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {


                        for (int j = 1; j <= Integer.parseInt(documentSnapshot.getString("count")); j++) {


                            showmember(documentSnapshot.getString(String.valueOf(j)));

                        }
                    }
                });
    }



    private void showmember(String member_id) {



        fStore.collection("User").document(member_id).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if( !(documentSnapshot.getDouble("Latitude")==0.0 && documentSnapshot.getDouble("Longitude")==0.0))
                        mMap.addMarker(new MarkerOptions()
                                .position( new LatLng( documentSnapshot.getDouble("Latitude"),documentSnapshot.getDouble("Longitude")))
                                .title(documentSnapshot.getString("FullName")));
                    }
                });

    }



    private class MyLocationListener implements LocationListener {


        @Override
        public void onLocationChanged(Location loc) {

            location = loc;

if(fauth.getCurrentUser()!=null) {
    DocumentReference documentReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());
    Map<String, Object> user = new HashMap<>();

    user.put("Latitude", location.getLatitude());
    user.put("Longitude", location.getLongitude());

    documentReference.update(user);
}

        }

    }


}
