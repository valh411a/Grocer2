package com.example.grocer2;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.grocer2.Database.Food;

import static android.app.Activity.RESULT_OK;


public class food_list extends Fragment {

    private static final int NEW_FOOD_ACTIVITY_REQUEST_CODE = 1;
    private OnFragmentInteractionListener mListener;
    private FragmentManager fragmentManager;
    private FoodViewModel foodViewModel;

    public food_list() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment food_list.
     */
    // TODO: Rename and change types and number of parameters
    public static food_list newInstance() {
        food_list fragment = new food_list();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
        foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentManager = getFragmentManager();

        View rootView = inflater.inflate(R.layout.fragment_food_list, container, false);

        RecyclerView mRecyclerView = rootView.findViewById(R.id.RecyclerView);
        RecyclerView.Adapter mAdapter = new RecyclerAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                Class fragmentClass = null;
                fragmentClass = new_food_page.class;

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            }
        });

        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras;

        if (requestCode == NEW_FOOD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            extras = data.getExtras();
            Food food = new Food(
                    extras.getString("FOOD_NAME"),
                    extras.getLong("UPC_CODE"));
            foodViewModel.saveFood(food);
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
