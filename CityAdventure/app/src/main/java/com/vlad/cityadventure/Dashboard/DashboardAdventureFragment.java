package com.vlad.cityadventure.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vlad.cityadventure.adventure.AdventureActivity;
import com.vlad.cityadventure.R;

/**
 * Adventure fragment
 */
public class DashboardAdventureFragment extends Fragment {
    public static final String TITLE = "param1";
    public static final String ID = "param2";
    public static final String PROGRESS = "param2";

    private String adventureTitle;
    private String adventureId;
    private int progress;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DashboardAdventureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardAdventureFragment newInstance(String adventureTitle, String adventureId, int progress) {
        DashboardAdventureFragment fragment = new DashboardAdventureFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, adventureTitle);
        args.putString(ID, adventureId);
        args.putInt(PROGRESS, progress);
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardAdventureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            adventureTitle = getArguments().getString(TITLE);
            adventureId = getArguments().getString(ID);
            progress = getArguments().getInt(PROGRESS, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_adventure, container, false);
//        adventure_button
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.adventure_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo fetch adventure data and launch adventure activity
                Intent intent = new Intent(getActivity(), AdventureActivity.class);
                intent.putExtra(ID, adventureId);
                startActivity(intent);
            }
        });
        TextView progressView = (TextView) view.findViewById(R.id.progress);
        progressView.setText(progress + "% complete");
        TextView statusView = (TextView) view.findViewById(R.id.dashboard_adventure_status);
        if (progress == 100) {
            progressView.setTextColor(getResources().getColor(R.color.green));
            statusView.setText("Recent adventure");
        } else {
            progressView.setTextColor(getResources().getColor(R.color.orange));
        }
        TextView titleView = (TextView) view.findViewById(R.id.dashboard_adventure_title);
        titleView.setText(adventureTitle);

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
            mListener = (OnFragmentInteractionListener) activity;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
