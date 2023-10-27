package com.example.folhapagamento.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.folhapagamento.R;
import com.example.folhapagamento.model.Fornecedor;

import java.io.Serializable;
import java.util.List;

public class ListaFornecedorAdapter extends BaseAdapter implements Serializable {
    private static final long serialVersionUID = 554652153231L;

    private List<Fornecedor> listaFornecedores;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListaFornecedorAdapter(List<Fornecedor> listaFornecedores, Context context) {
        this.listaFornecedores = listaFornecedores;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaFornecedores.size();
    }

    @Override
    public Fornecedor getItem(int i) {
        return listaFornecedores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Fornecedor fornecedor = listaFornecedores.get(i);
        View v = layoutInflater.inflate(R.layout.activity_info_fornecedores, null);

        TextView txtId = v.findViewById(R.id.textViewId);
        TextView txtCnpj = v.findViewById(R.id.textViewCnpj);
        TextView txtNomeFantasia = v.findViewById(R.id.textViewNomeFantasia);

        txtId.setText(fornecedor.getId().toString());
        txtCnpj.setText(fornecedor.getCnpj());
        txtNomeFantasia.setText(fornecedor.getNomeFantasia());

        return v;
    }
}

