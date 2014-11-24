package com.vlad.cityadventure.object;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.vlad.cityadventure.adventure.AdventureActivity;
import com.vlad.cityadventure.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ObjectAvhievementFragment.OnObjectFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ObjectAvhievementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjectAvhievementFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String USER_ID = "param1";

    // TODO: Rename and change types of parameters
    private String userId;

    private OnObjectFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userId Parameter 1.
     * @return A new instance of fragment DashboardAdventureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjectAvhievementFragment newInstance(String userId) {
        ObjectAvhievementFragment fragment = new ObjectAvhievementFragment();
        Bundle args = new Bundle();
        args.putString(USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    public ObjectAvhievementFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getString(USER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_object_achievements, container, false);
//        adventure_button
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        // initialise your views
        populateViews(userId);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnObjectFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnObjectFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private void populateViews(String userId){
        //todo get achievements from database
        ((TextView) getView().findViewById(R.id.achievement_1)).setText("Glasgow Explorer");
        ((TextView) getView().findViewById(R.id.achievement_2)).setText("Glasgow Runner");
        ((TextView) getView().findViewById(R.id.achievement_3)).setText("Teamwork");
        ((TextView) getView().findViewById(R.id.achievement_4)).setText("City Collector");
        ((TextView) getView().findViewById(R.id.achievement_5)).setText("All the Parks");
    }

}