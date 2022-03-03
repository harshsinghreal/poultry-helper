package com.example.poultry.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.poultry.R;
import com.example.poultry.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private EditText n50,n60,nbird,birdWeight;
    private Button fcr,weights,food;
    private TextView result;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        n50 = root.findViewById(R.id.number50);
        n60 = root.findViewById(R.id.number60);
        nbird = root.findViewById(R.id.remains);
        birdWeight= root.findViewById(R.id.weights);
        fcr = root.findViewById(R.id.fcrbtn);
        weights = root.findViewById(R.id.weightButton);
        food = root.findViewById(R.id.foodButton);
        result = root.findViewById(R.id.result);

        fcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int kg50,kg60,totalBird;
                    float weightOfBird;
                    if(n50.length()==0){
                        kg50 = 0;
                    }
                    else {

                        kg50 = Integer.parseInt(n50.getText().toString());
                    }

                    if(n60.length()==0){
                        kg60 = 0;
                    }
                    else {
                      kg60 = Integer.parseInt(n60.getText().toString());
                    }

                    if(nbird.length()==0){
                         totalBird = 0;
                    }
                    else {
                         totalBird = Integer.parseInt(nbird.getText().toString());
                    }
                    if (birdWeight.length()==0){
                        weightOfBird = 0;
                    }
                    else {
                        weightOfBird = Float.parseFloat(birdWeight.getText().toString());
                    }
                    float totalBirdWeight = weightOfBird*totalBird;
                    int chara = (kg50*50)+(kg60*60);
                    float fcrResult =  (chara/totalBirdWeight);
                    result.setText( String.format ("F.C.R. =  %.2f",fcrResult));

                }catch (Exception e){}




            }
        });


        //bird weight function
        weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int kg50,kg60,totalBird;
                    float weightOfBird;
                    if(n50.length()==0){
                        kg50 = 0;
                    }
                    else {

                        kg50 = Integer.parseInt(n50.getText().toString());
                    }

                    if(n60.length()==0){
                        kg60 = 0;
                    }
                    else {
                        kg60 = Integer.parseInt(n60.getText().toString());
                    }

                    if(nbird.length()==0){
                        totalBird = 0;
                    }
                    else {
                        totalBird = Integer.parseInt(nbird.getText().toString());
                    }
                    if (birdWeight.length()==0){
                        weightOfBird = 0;
                    }
                    else {
                        weightOfBird = Float.parseFloat(birdWeight.getText().toString());
                    }

                    float totalBirdWeight = weightOfBird*totalBird;
                    float quintal = totalBirdWeight/100;
                    result.setText( String.format ("-->  %.1f  K.G.\n-->  %.1f  Quintal",totalBirdWeight,quintal));

                }catch (Exception e){}


            }
        });





        //food weight function
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int kg50,kg60;
                    if(n50.length()==0){
                        kg50 = 0;
                    }
                    else {

                        kg50 = Integer.parseInt(n50.getText().toString());
                    }

                    if(n60.length()==0){
                        kg60 = 0;
                    }
                    else {
                        kg60 = Integer.parseInt(n60.getText().toString());
                    }
                    float chara = (kg50*50)+(kg60*60);
                    float chare = chara/100;
                    result.setText( String.format ("Food =  %.0f K.G.\n                %.1f  Quintal",chara,chare));

                }catch (Exception e){}


            }
        });






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}