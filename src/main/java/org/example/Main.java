package org.example;

import org.example.DAO.FornecedorDAO;
import org.example.Model.Fornecedor;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inicio();
    }

    static Scanner leia = new Scanner(System.in);

    public static void inicio(){

        boolean sair = false;

        System.out.print("""
                --------------MENU--------------
                1 - Cadastrar Fornecedor
                2 - Cadastrar Material
                3 - Registrar nota de entrada
                4 - Criar requisição de material
                5 - Atender requisição
                6 - Cancelar requisição
                --------------------------------
                0 - Sair
                --------------------------------
                >
                """);
        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao){
            case 1->{
                cadastrarFornecedor();
            }
            case 2->{

            }
            case 3->{

            }
            case 4->{

            }
            case 5->{

            }
            case 6->{

            }
            case 0->{
                sair = true;
            }
        }

        if(!sair){
            inicio();
        }
    }

    public static void cadastrarFornecedor(){
        var dao = new FornecedorDAO();
        System.out.println("Digite o nome do fornecedor: ");
        String nome = leia.nextLine();
        System.out.println("Digite o CNPJ do fornecedor: ");
        String cnpj = leia.nextLine();

        try{
            var fornecedor = new Fornecedor(nome, cnpj);
            dao.cadastroFornecedor(fornecedor);
            System.out.println("Fornecedor cadastrado com sucesso!");
        }catch (SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao conectar com o banco de dados.");
        }
    }
}