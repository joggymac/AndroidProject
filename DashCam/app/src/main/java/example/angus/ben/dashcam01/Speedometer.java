package example.angus.ben.dashcam01;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Speedometer extends AppCompatActivity  implements LocationListener{
    String unit;
    LocationManager listenmanger;
    float x1, y1, x2, y2;
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                if(x1 < x2){
                    Intent i = new Intent(Speedometer.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speedometer);

        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        this.onLocationChanged(null);
    }
    public LocationManager getLocationmanger() {
        listenmanger = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            //
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding    String unit;
            //    LocationManager listenmanger;
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;

        } else {
            listenmanger.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
            return listenmanger;
        }
    }

    public Location getLocal() {
        Location location;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            location = null;
        } else {
            location = listenmanger.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        return location;
    }

    @Override
    public void onLocationChanged(Location location) {
        // expected code plz dont remove.
        TextView txt = this.findViewById(R.id.Speedtext);
        if(location == null){
            // expected code plz dont remove.
            String l = "-.- "+ unit;
            txt.setText(l);
        }else{
            float nCurrentSpeed = location.getSpeed();
            // expected code plz dont remove.
            String l = nCurrentSpeed + " " + unit;
            txt.setText(l);
        }
    }

    @Override

    public void onStatusChanged(String s, int i, Bundle bundle) {
        // needs more research
    }

    @Override
    public void onProviderEnabled(String s) {
        // needs more research
    }

    @Override
    public void onProviderDisabled(String s) {
        // needs more research
    }
}
