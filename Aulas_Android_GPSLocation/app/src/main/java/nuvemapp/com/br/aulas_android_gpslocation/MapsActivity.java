package nuvemapp.com.br.aulas_android_gpslocation;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    double lat = -22.236491;
    double longi = -43.712987;
    LatLng ll = new LatLng(lat, longi);


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, longi)).title("R. Hildebrando Lopes, 22-40, Valença - RJ, 27600-000"));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 20);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void streetView(View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 15);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);
    }

    public void normalView(View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 15);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);
    }
}
