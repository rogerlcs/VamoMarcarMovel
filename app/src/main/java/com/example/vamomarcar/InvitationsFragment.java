package com.example.vamomarcar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InvitationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InvitationsFragment extends Fragment {


    public InvitationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Invitations.
     */
    // TODO: Rename and change types and number of parameters
    public static InvitationsFragment newInstance() {
        InvitationsFragment fragment = new InvitationsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invitations, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        List<Event> eventos = mainActivityViewModel.getEventos();
        List<Event> invitationsEvents = new ArrayList<>();
        List<Integer> eventosindex = new ArrayList<>();
        int index = 0;

        for(Event e : eventos){
            if(e.getType() == 1){
                invitationsEvents.add(e);
                eventosindex.add(index);
            }
            index++;
        }

        InvitationsAdapter InvitationsAdapter = new InvitationsAdapter(getContext(),invitationsEvents, eventosindex);

        RecyclerView rvInivite = getView().findViewById(R.id.rvInivite);
        rvInivite.setAdapter(InvitationsAdapter);
        rvInivite.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvInivite.getContext(), DividerItemDecoration.VERTICAL);
        rvInivite.addItemDecoration(dividerItemDecoration);
    }

}