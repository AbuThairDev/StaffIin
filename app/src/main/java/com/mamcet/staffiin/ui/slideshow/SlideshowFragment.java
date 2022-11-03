package com.mamcet.staffiin.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mamcet.staffiin.R;
import com.mamcet.staffiin.databinding.FragmentSlideshowBinding;
import com.mamcet.staffiin.ui.slideshow.createProduct.createProduct;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
    Button crt_product_btn = (Button) root.findViewById(R.id.create_an_product_btn);

    crt_product_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent redirect= new Intent(SlideshowFragment.this.getActivity(), createProduct.class);
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
}