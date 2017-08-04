package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adama on 04.08.2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeItem> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<EarthquakeItem>EarthquakesList) {
        super(context,0, EarthquakesList);
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
        EarthquakeItem currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_TextView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magTextView.setText(currentEarthquake.getMagnitude());

        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city_textView);
        cityTextView.setText(currentEarthquake.getCity());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView3);
        dateTextView.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
