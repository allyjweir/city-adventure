package com.vlad.cityadventure.object;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.dashboard.ObjectTaskAdapter;

/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.vlad.cityadventure.object.ObjectAvhievementFragment.OnObjectFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.vlad.cityadventure.object.ObjectTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjectTaskFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String USER_ID = "param1";

    // TODO: Rename and change types of parameters
    private String userId;

    private ObjectAvhievementFragment.OnObjectFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param userId Parameter 1.
     * @return A new instance of fragment DashboardAdventureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjectTaskFragment newInstance(String userId) {
        ObjectTaskFragment fragment = new ObjectTaskFragment();
        Bundle args = new Bundle();
        args.putString(USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    public ObjectTaskFragment() {
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
        return inflater.inflate(R.layout.fragment_object_tasks, container, false);
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
            mListener = (ObjectAvhievementFragment.OnObjectFragmentInteractionListener) activity;
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

    private void populateViews(String userId){
        //todo get achievements from database
        ListView taskList = (ListView) getView().findViewById(R.id.task_list);
        taskList.setAdapter(new ObjectTaskAdapter(("1.   Take a picture of the Christ of St. John of the Cross,2.   Complete the Kelvingrove Museum Quiz," +
                "3.    Visit Glasgow University,4.   Solve the puzzle before the time runs out," +
                        "5.   Find the hidden QR code inside the Hunterian Art Gallery").split(",")));
    }

}
