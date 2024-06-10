/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pdv.v4;

import com.mycompany.pdv.v4.panel.Pdv_Panel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author elias
 */
public class PDVV4 {

    public static void main(String[] args) {
          gerarLog();
          new Pdv_Panel().setVisible(true);
      
          
        
    }
      public static void gerarLog(){
            java.util.Date date = new java.util.Date(System.currentTimeMillis());
            
            
            
            //LEMBRAR DE MUDAR O CAMINHO PARA O DO SEU COMPUTADOR
            String nomeArquivo = "C:/Users/elias/OneDrive/Documentos/NetBeansProjects/PDV-V4/log/log.txt";
            File arquivo = new File( nomeArquivo);
            try {
            arquivo.createNewFile();
            System.out.println("Arquivo log criado com sucesso!");
            FileWriter writer = new FileWriter(arquivo);
              writer.write("OPERAÇÃO:CRIAÇÃO DO ARQUIVO, STATUS:SUCESSO"+date+"\n");
              writer.close();
            } catch (IOException e) {
                    
            e.printStackTrace();
        }
}
} 

