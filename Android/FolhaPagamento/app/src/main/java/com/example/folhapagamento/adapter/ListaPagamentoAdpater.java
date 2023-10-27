package com.example.folhapagamento.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.folhapagamento.fragment.DadosPessoaisFragment;
import com.example.folhapagamento.fragment.PagamentoFragment;

public class ListaPagamentoAdpater extends FragmentStateAdapter {
    public ListaPagamentoAdpater(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new DadosPessoaisFragment();
            case 1:
                return new PagamentoFragment();
            default:
                return new DadosPessoaisFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
