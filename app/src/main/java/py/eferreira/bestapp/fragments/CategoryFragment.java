package py.eferreira.bestapp.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import py.eferreira.bestapp.R;
import py.eferreira.bestapp.adapters.CategoryAdapter;
import py.eferreira.bestapp.entities.Category;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    RecyclerView rcvCategories;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        rcvCategories = rootView.findViewById(R.id.rcv_categories);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvCategories.setLayoutManager(linearLayoutManager);

        List<Category> listCategories = new ArrayList<>();
        listCategories.add(new Category("cafe", "listado de lugares que ofrecen cafe"));
        listCategories.add(new Category("pizza", "pizzerias"));
        listCategories.add(new Category("hamburguesa", "comercios que ofrecen solo hamburguesas"));

        CategoryAdapter adapter = new CategoryAdapter(listCategories, getActivity());
        rcvCategories.setAdapter(adapter);



        return rootView;
    }

}
