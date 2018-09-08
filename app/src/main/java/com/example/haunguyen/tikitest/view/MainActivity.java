package com.example.haunguyen.tikitest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.haunguyen.tikitest.model.Product;
import com.example.haunguyen.tikitest.model.ProductList;
import com.example.haunguyen.tikitest.presenter.MainPresenter;
import com.example.haunguyen.tikitest.R;
import com.example.haunguyen.tikitest.presenter.IMainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private MainPresenter mainPresenter;
    private RecyclerView mRcProduct;
    private MainAdapter mainAdapter;
    private ProductList productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRcProduct = findViewById(R.id.rc_product);
        mainPresenter = new MainPresenter(this);
        mainPresenter.initRetrofitCall(this, "https://gist.githubusercontent.com");

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRcProduct.setLayoutManager(manager);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView() {
        mainAdapter = new MainAdapter(productList);
        mRcProduct.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetDataSuccess(String message, String[] list) {
        List<Integer> integers = fakeColor(list.length);
        productList = getProductList(list, integers);
    }

    @Override
    public void onGetDataFailure(String message) {

    }

    public List<Integer> fakeColor(int size) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0 ; i < size; i = i + 6){
            integers.add(R.color.colorBlue);
            integers.add(R.color.colorBlue2);
            integers.add(R.color.colorOrgrane);
            integers.add(R.color.colorTim);
            integers.add(R.color.colorBlue3);
            integers.add(R.color.colorOr2);
        }
        return integers;
    }

    public ProductList getProductList(String[] name, List<Integer> color ) {
         ProductList productList = new ProductList();
         List<Product> products = new ArrayList<>();
         if (name.length > 0 && color != null && color.size() > 0){
             for (int i = 0; i < name.length; i ++){
                 Product product = new Product();
                 product.setName(name[i]);
                 product.setColor(color.get(i));
                 products.add(product);

             }
         }
         productList.setProductModels(products);
         return productList;
    }
}
