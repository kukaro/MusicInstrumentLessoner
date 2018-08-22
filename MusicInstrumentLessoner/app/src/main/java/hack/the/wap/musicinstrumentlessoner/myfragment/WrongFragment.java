package hack.the.wap.musicinstrumentlessoner.myfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import hack.the.wap.musicinstrumentlessoner.R;
import hack.the.wap.musicinstrumentlessoner.debug.DebugMode;
import hack.the.wap.musicinstrumentlessoner.mylayout.GuideExplainLayout;
import hack.the.wap.musicinstrumentlessoner.session.Session;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WrongFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WrongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WrongFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View wrongFragmentView;
    private LinearLayout llFragWrong;
    private static Session session;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WrongFragment() {
        session = Session.getInstance();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WrongFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WrongFragment newInstance(String param1, String param2) {
        WrongFragment fragment = new WrongFragment();
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
        wrongFragmentView = inflater.inflate(R.layout.fragment_wrong, container, false);
        llFragWrong = wrongFragmentView.findViewById(R.id.llFragWrong);
        debugSetView();
        return wrongFragmentView;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void debugSetView(){
        if(DebugMode.DEBUG_MOD){
            GuideExplainLayout debugGuide1 = new GuideExplainLayout(this.getContext(),"00:03","음이 틀렸습니다. 라->솔");
            GuideExplainLayout debugGuide2 = new GuideExplainLayout(this.getContext(),"01:30","초킹으로 해야합니다.");
            GuideExplainLayout debugGuide3 = new GuideExplainLayout(this.getContext(),"02:00","음이 틀렸습니다. 도->시");
            llFragWrong.addView(debugGuide1);
            llFragWrong.addView(debugGuide2);
            llFragWrong.addView(debugGuide3);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
