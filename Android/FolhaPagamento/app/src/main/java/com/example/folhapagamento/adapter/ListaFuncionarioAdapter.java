package com.example.folhapagamento.adapter;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.folhapagamento.R;
import com.example.folhapagamento.model.Funcionario;

import java.io.Serializable;
import java.util.List;

public class ListaFuncionarioAdapter extends BaseAdapter implements Serializable {
    private static final long serialVersionUID = 554652153231L;

    private List<Funcionario> listaFuncionarios;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListaFuncionarioAdapter(List<Funcionario> listaFuncionarios, Context context) {
        this.listaFuncionarios = listaFuncionarios;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listaFuncionarios.size();
    }

    @Override
    public Funcionario getItem(int i) {
        return listaFuncionarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Funcionario funcionario = listaFuncionarios.get(i);
        View v = layoutInflater.inflate(R.layout.activity_info_funcionario, null);

        TextView txtMatricula = v.findViewById(R.id.textViewId);
        TextView txtNome = v.findViewById(R.id.textViewCnpj);
        TextView txtNascimento = v.findViewById(R.id.textViewNomeFantasia);
        TextView txtCpf= v.findViewById(R.id.textViewTelefoneFornecedor);

        txtMatricula.setText(funcionario.getMatricula().toString());
        txtNome.setText(funcionario.getNome().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = sdf.format(funcionario.getDataNascimento());
        txtNascimento.setText(dataNascimento);

        txtCpf.setText(String.format("%s.%s.%s-%s", funcionario.getCpf().substring(0, 3), funcionario.getCpf().substring(3, 6), funcionario.getCpf().substring(6, 9), funcionario.getCpf().substring(9, 11)));

        return v;
    }
}
