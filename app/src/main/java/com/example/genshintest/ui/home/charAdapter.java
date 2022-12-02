package com.example.genshintest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.genshintest.R;

import java.util.ArrayList;

public class charAdapter extends ArrayAdapter<genshinCharacter> {

    public charAdapter(Context ct, ArrayList<genshinCharacter> arrayList) {
        super(ct,R.layout.activity_char_list_view,R.id.textView,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        genshinCharacter hold = getItem(position);

        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_char_list_view,parent,false);
        }

        TextView textName = convertView.findViewById(R.id.charName);
        ImageView imageView = convertView.findViewById(R.id.imageIcon);
        ImageView imageView1 = convertView.findViewById(R.id.imageView2);
        ImageView imageView2 = convertView.findViewById(R.id.imageView3);
        switch (hold.weaponType) {
            case "Bow":
                imageView1.setImageResource(R.drawable.bow);
                break;
            case "Polearm":
                imageView1.setImageResource(R.drawable.polearm);
                break;
            case "Sword":
                imageView1.setImageResource(R.drawable.sword);
                break;
            case "Catalyst":
                imageView1.setImageResource(R.drawable.catalyst);
                break;
            case "Claymore":
                imageView1.setImageResource(R.drawable.claymore);
                break;
        }
        switch (hold.element) {
            case "Cryo":
                imageView2.setImageResource(R.drawable.cryo_50);
                break;
            case "Dendro":
                imageView2.setImageResource(R.drawable.dendro_50);
                break;
            case "Pyro":
                imageView2.setImageResource(R.drawable.pyro_50);
                break;
            case "Hydro":
                imageView2.setImageResource(R.drawable.hydro_50);
                break;
            case "Electro":
                imageView2.setImageResource(R.drawable.electro_50);
                break;
            case "Anemo":
                imageView2.setImageResource(R.drawable.anemo_50);
                break;
            case "Geo":
                imageView2.setImageResource(R.drawable.geo_50);
                break;
        }

        imageView.setImageResource(hold.image);
        textName.setText(hold.name);

        return super.getView(position, convertView, parent);
    }
}
