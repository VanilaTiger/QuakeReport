package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adama on 04.08.2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeItem> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<EarthquakeItem>EarthquakesList) {
        super(context,0, EarthquakesList);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitude1ColorResourceID;
        int magnitudeFloor = (int)Math.floor(magnitude);

        switch (magnitudeFloor)
        {
            case 0:
            case 1:
                magnitude1ColorResourceID=R.color.magnitude1;
                break;
            case 2:
                magnitude1ColorResourceID=R.color.magnitude2;
                break;
            case 3:
                magnitude1ColorResourceID=R.color.magnitude3;
                break;
            case 4:
                magnitude1ColorResourceID=R.color.magnitude4;
                break;
            case 5:
                magnitude1ColorResourceID=R.color.magnitude5;
                break;
            case 6:
                magnitude1ColorResourceID=R.color.magnitude6;
                break;
            case 7:
                magnitude1ColorResourceID=R.color.magnitude7;
                break;
            case 8:
                magnitude1ColorResourceID=R.color.magnitude8;
                break;
            case 9:
                magnitude1ColorResourceID=R.color.magnitude9;
                break;
            default:
                magnitude1ColorResourceID=R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(),magnitude1ColorResourceID);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final EarthquakeItem currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_TextView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        double magnitude=currentEarthquake.getMagnitude();
        String magnitudeToDisplay=formatMagnitude(magnitude);
        magTextView.setText(magnitudeToDisplay);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city_textView);
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_textView);
        String orginalLocation=currentEarthquake.getCity();

        if (orginalLocation.contains("of")){
            int index = orginalLocation.indexOf("of");
            String offset=orginalLocation.substring(0,index+2);
            String city=orginalLocation.substring(index+2);
            cityTextView.setText(city);
            offsetTextView.setText(offset);
        }else{
            cityTextView.setText(orginalLocation);
            offsetTextView.setText("Near the");
        };

        long timeInMilliseconds = currentEarthquake.getDate();
        Date dateObject = new Date(timeInMilliseconds);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView);

        String dateToDisplay = formatDate(dateObject);
        dateTextView.setText(dateToDisplay);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_textView);

        String timeToDisplay = formatTime(dateObject);
        timeTextView.setText(timeToDisplay);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentEarthquake.getWebAdress()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
