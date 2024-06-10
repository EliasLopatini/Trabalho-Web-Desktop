/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdv.v4.service;

import com.mycompany.pdv.v4.ConectionInterface.ClienteInterface;
import com.mycompany.pdv.v4.ConectionInterface.ProdutoInterface;
import com.mycompany.pdv.v4.models.Cliente;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author elias
 */
public class ClienteService implements ClienteInterface{

    @Override
    public Call<List<Cliente>> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Call<Void> insertCliente(Cliente cliente) {
                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        ClienteInterface clienteService = retrofit.create(ClienteInterface.class);
        
        return clienteService.insertCliente(cliente);
    }
    
}
