package com.vlad.cityadventure.object;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Question;
import com.vlad.cityadventure.classes.Task;
import com.vlad.cityadventure.dashboard.ObjectTaskAdapter;
import com.vlad.cityadventure.utils.MockDatabase;
import com.vlad.cityadventure.utils.UserManager;

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
    public static final String LANMARK_ID = "param1";

    // TODO: Rename and change types of parameters
    private String landmarkId;
    public AlertDialog dialog;
    private ListView taskList;
    private ObjectTaskAdapter adapter;

    private ObjectAvhievementFragment.OnObjectFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param landmarkId Parameter 1.
     * @return A new instance of fragment DashboardAdventureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjectTaskFragment newInstance(String landmarkId) {
        ObjectTaskFragment fragment = new ObjectTaskFragment();
        Bundle args = new Bundle();
        args.putString(LANMARK_ID, landmarkId);
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
            landmarkId = getArguments().getString(LANMARK_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_object_tasks, container, false);
//        adventure_button
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // initialise your views
        populateViews(landmarkId);

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

    private void populateViews(final String landmarkId) {
        //todo get achievements from database
        taskList = (ListView) getView().findViewById(R.id.task_list);
        adapter = new ObjectTaskAdapter(MockDatabase.getInstance().getLandmarks().get(landmarkId).getTasks(), UserManager.getInstance().getuId(), getActivity(), false);
        taskList.setAdapter(adapter);
        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doTask((String) parent.getAdapter().getItem(position), adapter);
            }
        });
        getView().findViewById(R.id.see_all_tasks_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Tasks");
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View convertView = inflater.inflate(R.layout.dialog_tasks, null);
                ListView tasks = (ListView) convertView.findViewById(R.id.tasks_popup_list);

                alert.setView(convertView);
                final ObjectTaskAdapter adapt = new ObjectTaskAdapter(MockDatabase.getInstance().getLandmarks().get(landmarkId).getTasks(), UserManager.getInstance().getuId(), getActivity(), true);
                tasks.setAdapter(adapt);
                tasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        doTask((String) parent.getAdapter().getItem(position), adapt);
                    }
                });

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog = alert.show();
            }
        });
    }

    public void doTask(String taskId, ObjectTaskAdapter adapt) {
        Task task = MockDatabase.getInstance().getTasks().get(taskId);
        if (task.getType() == Task.TaskType.QUESTION) {
            askQuestion((Task.QuestionTask) task, taskId, adapt);
        }
        else if (task.getType() == Task.TaskType.PHOTO) {
            UserManager.getInstance().getUser().getCompleteTasks().add(taskId);
            adapt.notifyDataSetChanged();
            ((ObjectActivity) getActivity()).dispatchTakePictureIntent();
        }
    }


    public void askQuestion(final Task.QuestionTask question, final String taskId, final ObjectTaskAdapter adapt) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Do you know the answer?");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View convertView = inflater.inflate(R.layout.task_question, null);
        ((TextView) convertView.findViewById(R.id.task_question)).setText(question.getQuestion());
        ListView options = (ListView) convertView.findViewById(R.id.task_question_options);
        options.setAdapter(new com.vlad.cityadventure.object.ObjectTaskAdapter(question.getOptions()));
        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == question.getAnswer()) {
                    Toast.makeText(getActivity(), "That's right!", Toast.LENGTH_SHORT).show();
                    UserManager.getInstance().getUser().getCompleteTasks().add(taskId);
                    adapt.notifyDataSetChanged();
                } else Toast.makeText(getActivity(), "Sorry, but that wasn't the right answer.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alert.setView(convertView);

        alert.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = alert.show();

    }
}
