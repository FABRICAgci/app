package com.thiagoprestes.telabv;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.thiagoprestes.telabv.dominio.entidades.Cliente;

import java.util.List;


public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> {

    private List<Cliente> dados;

    public ClienteAdapter(List<Cliente> dados){
        this.dados = dados;
    }

    @Override
    public ClienteAdapter.ViewHolderCliente onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_clientes, parent, false);

        ViewHolderCliente holderCliente = new ViewHolderCliente(view, parent.getContext());

        return holderCliente;

    }

    @Override
    public void onBindViewHolder(ClienteAdapter.ViewHolderCliente holder, int position) {

        if ( (dados != null) && (dados.size() > 0 ) ) {

            Cliente cliente = dados.get(position);

            holder.txtNome.setText(cliente.nome);
            holder.txtTelefone.setText(cliente.telefone);

        }

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderCliente(View itemView, final Context context) {
            super(itemView);
            txtNome     = (TextView) itemView.findViewById(R.id.txtNome);
            txtTelefone = (TextView) itemView.findViewById(R.id.txtTelefone);


            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (dados.size() > 0) {

                        Cliente cliente = dados.get(getLayoutPosition());

                        Intent it = new Intent(context, ActCadCliente.class);
                        it.putExtra("CLIENTE", cliente);
                        ((AppCompatActivity) context).startActivityForResult(it, 0);

                    }
                }

            });

        }

    }



}
