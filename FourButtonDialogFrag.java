package com.example.jarrodgeraldsgarage.simpletodolist;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by gerar_000 on 7/29/2015.
 */
public class FourButtonDialogFrag extends DialogFragment{

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_four_button_dialog,
                container, false);

        Button IU= (Button) v.findViewById(R.id.ImpUrg);
//        IU.setOnClickListener(onCancel);
        Button NU= (Button) v.findViewById(R.id.NotImpUrg);
//        NU.setOnClickListener(onOK);
        Button IN= (Button) v.findViewById(R.id.ImpNotUrg);

        Button NN= (Button) v.findViewById(R.id.NotImpNotUrg);

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        return v;
    }

}
