package com.example.genshintest.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.genshintest.R;
import com.example.genshintest.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private Context mContext;

    private FragmentHomeBinding binding;
    FragmentHomeBinding binding1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        ArrayList<genshinCharacter> all = new ArrayList<>();
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding1 = FragmentHomeBinding.inflate(getLayoutInflater());


        String[] characters = {"Albedo", "Aloy","Amber","Ayaka","Ayato","Barbara","Beidou"};
        int[] imagechar = {R.drawable.albedo, R.drawable.aloy, R.drawable.amber, R.drawable.ayaka,
                R.drawable.ayato, R.drawable.barbara, R.drawable.beidou};
        String[] element = {"Geo","Cryo","Pyro","Cryo","Hydro","Hydro","Electro"};
        String[] weapon = {"Sword","Bow","Bow","Sword","Sword","Catalyst","Claymore"};

        for (int i = 0; i < characters.length; i++) {

            genshinCharacter character = new genshinCharacter(characters[i],element[i],weapon[i],imagechar[i]);
            all.add(character);
        }
        String[] weaponSpinner = {"All","Sword","Bow","Polearm","Claymore","Catalyst"};
        ArrayAdapter<String> wep = new ArrayAdapter<String>(getContext(),R.layout.activity_char_list_view,weaponSpinner);
        charAdapter listAdapter = new charAdapter(getActivity(),all);
        binding1.allCharacters.setAdapter(listAdapter);
        binding1.allCharacters.setClickable(true);
        return binding1.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}