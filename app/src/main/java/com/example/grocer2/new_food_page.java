package com.example.grocer2;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link new_food_page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link new_food_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class new_food_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    EditText mEditFoodNameView;
    EditText mEditFoodUPCView;
    private FragmentManager fragmentManager = getFragmentManager();
    private OnFragmentInteractionListener mListener;

    public new_food_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment new_food_page.
     */
    // TODO: Rename and change types and number of parameters
    public static new_food_page newInstance() {
        new_food_page fragment = new new_food_page();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_food_page, container, false);

        mEditFoodNameView = rootView.findViewById(R.id.edit_name);
        mEditFoodUPCView = rootView.findViewById(R.id.edit_upc);
        final Button saveButton = rootView.findViewById(R.id.button_save);
        final Button cancelButton = rootView.findViewById(R.id.button_cancel);
        final Bundle extras = new Bundle();

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditFoodNameView.getText())) {
                    getActivity().setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String food = mEditFoodNameView.getText().toString();
                    long upc = Long.parseLong(mEditFoodUPCView.getText().toString());
                    extras.putString("FOOD_NAME", food);
                    extras.putLong("UPC_CODE", upc);
                    replyIntent.putExtras(extras);
                    getActivity().setResult(RESULT_OK, replyIntent);
                }
                getActivity().finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                getActivity().setResult(RESULT_CANCELED, replyIntent);
                getActivity().finish();
            }
        });

        return inflater.inflate(R.layout.fragment_new_food_page, container, false);
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
}
