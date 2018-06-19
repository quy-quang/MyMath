package com.example.quyquang.mymath;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


public class TaoMoi extends Fragment {

    String[] figureType;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tao_moi, container, false);


        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        figureType = getResources().getStringArray(R.array.figure_type);
        Log.d("debug1", "dddd");

        Spinner s = (Spinner) getView().findViewById(R.id.spinnerFigureType);
        Log.d("debug2", String.valueOf(s));
        s.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int index = parent.getSelectedItemPosition();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Log.d("debug", "onItemClick: ");

                switch (position) {
                    case 0://Hinh Chu Nhat
                        Fragment figure_hinh_chu_nhat = new Figure_hinh_chu_nhat();
                        fragmentTransaction.replace(android.R.id.content, figure_hinh_chu_nhat);
                        break;
                    case 1: // Hinh Tam Giac
                        Fragment figure_hinh_tam_giac = new Figure_hinh_tam_giac();
                        fragmentTransaction.replace(android.R.id.content, figure_hinh_tam_giac);
                        break;
                    case 2: //Hinh Tron
                    default:

                }
                fragmentTransaction.commit();
            }
        });


    }
}
