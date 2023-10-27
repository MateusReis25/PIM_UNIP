package com.example.folhapagamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;


import android.os.Bundle;
import android.widget.TableLayout;

import com.example.folhapagamento.adapter.ListaPagamentoAdpater;


public class DetalhesPagamento extends AppCompatActivity {

    private TabLayout tabLayoutPagamento;
    private ViewPager2 viewPagePagemento;
    private ListaPagamentoAdpater listaPagamentoAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pagamento);

        tabLayoutPagamento = findViewById(R.id.tabLayoutPagamento);
        viewPagePagemento = findViewById(R.id.viewPagePagemento);
        listaPagamentoAdpater = new ListaPagamentoAdpater(this);
        viewPagePagemento.setAdapter(listaPagamentoAdpater);

        tabLayoutPagamento.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagePagemento.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Lógica quando uma aba é deselecionada
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Lógica quando uma aba é reselecionada
            }
        });
    }
}