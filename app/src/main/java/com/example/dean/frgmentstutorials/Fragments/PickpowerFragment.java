package com.example.dean.frgmentstutorials.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dean.frgmentstutorials.Activity.MainActivity;
import com.example.dean.frgmentstutorials.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickpowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickpowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PickPowerInteractionListener mListener;

    private Button laserBtn;
    private Button lightingBtn;
    private Button flightBtn;
    private Button turtlePowerBtn;
    private Button showBackStoryBtn;

    private Button bt;

    public PickpowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickpowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickpowerFragment newInstance(String param1, String param2) {
        PickpowerFragment fragment = new PickpowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pickpower, container, false);

        laserBtn = (Button) view.findViewById(R.id.laserBtn);
        lightingBtn = (Button) view.findViewById(R.id.lightingBtn);
        flightBtn = (Button) view.findViewById(R.id.flightBtn);
        turtlePowerBtn = (Button) view.findViewById(R.id.turtlepowerBtn);
        showBackStoryBtn = (Button) view.findViewById(R.id.showBackStoryBtn);

        laserBtn.setOnClickListener(this);
        lightingBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        turtlePowerBtn.setOnClickListener(this);
        showBackStoryBtn.setOnClickListener(this);

        showBackStoryBtn.getBackground().setAlpha(125);
        showBackStoryBtn.setEnabled(false);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PickPowerInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        showBackStoryBtn.setEnabled(true);
        showBackStoryBtn.getBackground().setAlpha(255);

        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0, 0, 0);
        lightingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0, 0, 0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0, 0, 0);
        turtlePowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0, 0, 0);



        bt = (Button) view ;

        if (bt == laserBtn) {

            laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0, R.drawable.item_selected, 0);

        } else if (bt == lightingBtn) {

            lightingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, R.drawable.item_selected, 0);

        } else if (bt == flightBtn) {
            flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest, 0, R.drawable.item_selected, 0);

        } else if (bt == turtlePowerBtn) {
            turtlePowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision, 0, R.drawable.item_selected, 0);

        } else if (bt == showBackStoryBtn) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.onAboutFragmentInteraction("test", this);

        }



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
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
