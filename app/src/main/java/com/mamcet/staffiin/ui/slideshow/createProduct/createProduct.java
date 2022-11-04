package com.mamcet.staffiin.ui.slideshow.createProduct;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mamcet.staffiin.R;

public class createProduct extends AppCompatActivity {

    EditText pName, pId, pPrice, pGst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_a_product);

        pName = findViewById(R.id.product_name);
        pId = findViewById(R.id.product_id);
        pPrice = findViewById(R.id.product_price);
        pGst = findViewById(R.id.product_gst);


        Button create_a_product = (Button) findViewById(R.id.create_product_btn);

        create_a_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addToProduct();
            }
        });
    }

    public void addToProduct(){
        DatabaseReference db;
        String product_name = pName.getText().toString();
        String product_id = pId.getText().toString();
        String product_price = pPrice.getText().toString();
        String product_gst = pGst.getText().toString();

        productList product = new productList(product_id, product_name, product_price, product_gst);

        db = FirebaseDatabase.getInstance("https://staff-in-default-rtdb.firebaseio.com/").getReference("Product/"+product_id);

        db.setValue(product);

        Toast.makeText(createProduct.this,  "Added to product list", Toast.LENGTH_LONG).show();
    }
}