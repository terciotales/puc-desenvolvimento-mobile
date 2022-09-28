package com.example.aula09fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;





import java.util.List;

public class FragmentControler extends FragmentStatePagerAdapter {
    private final List<String> nomes = new ArrayList<>();
    private final List<Fragment> lista = new ArrayList<>();

    public FragmentController(@NonNull FragmentManager fm, int comportamento) {
        super(fm, comportamento);
    }

    public void AddFragment(Fragment f, String nome){
        lista.add(f);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lista.get(position);
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
