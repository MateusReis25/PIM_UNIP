package com.example.folhapagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.folhapagamento.adapter.ListaPagamentoAdpater;

import view.fornecedor.DetalhesFornecedor;
import view.fornecedor.Fornecedores;

public class Pagamento extends AppCompatActivity {

    private TextView inputPesquisaPagamento;
    private Button btnPesquisarPagamento;
    private ListView listViewPagamento;
    private ListaPagamentoAdpater adpater;
    private Button btnVoltarPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        inputPesquisaPagamento = findViewById(R.id.inputPesquisaPagamento);
        btnPesquisarPagamento = findViewById(R.id.btnPesquisarPagamento);
        listViewPagamento = findViewById(R.id.listViewPagamento);

        listViewPagamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Pagamento.this, DetalhesPagamento.class);
                startActivity(intent);
            }
        });
    }
}