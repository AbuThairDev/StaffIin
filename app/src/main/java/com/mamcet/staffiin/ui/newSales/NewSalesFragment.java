package com.mamcet.staffiin.ui.newSales;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mamcet.staffiin.R;
import com.mamcet.staffiin.databinding.FragementNewSalesBinding;
import com.mamcet.staffiin.ui.newSales.update.update;

public class NewSalesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragementNewSalesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragementNewSalesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button crt_product_btn = (Button) root.findViewById(R.id.update_btn);

        crt_product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect= new Intent(NewSalesFragment.this.getActivity(), update.class);
                startActivity(redirect);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}