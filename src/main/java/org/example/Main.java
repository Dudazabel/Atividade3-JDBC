package org.example;

import org.example.DAO.FornecedorDAO;
import org.example.DAO.MaterialDAO;
import org.example.DAO.NotaEntradaDAO;
import org.example.Model.Fornecedor;
import org.example.Model.Material;
import org.example.Model.NotaEntrada;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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
                cadastrarMaterial();
            }
            case 3->{
                registrarNotaEntrada();
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

        System.out.println("---CADASTRAR FORNECEDOR---");
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
            System.out.println("Erro ao cadastrar fornecedor.");
        }
    }

    public static void cadastrarMaterial(){
        var dao = new MaterialDAO();

        System.out.println("---CADASTRAR MATERIAL---");
        System.out.println("Digite o nome do material: ");
        String nome = leia.nextLine();
        System.out.println("Digite a unidade de medida do material: ");
        String unidade = leia.nextLine();
        System.out.println("Digite a quantidade do material em estoque: ");
        double estoque = leia.nextDouble();

        try{
            var material = new Material(nome, unidade, estoque);
            dao.cadastroMaterial(material);
            System.out.println("Material cadastrado com sucesso!");
        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao cadastrar material.");
        }
    }

    public static void registrarNotaEntrada(){
        var daoN = new NotaEntradaDAO();
        var dao = new FornecedorDAO();
        LocalDate dataEntrada = null;
        int idFornecedor = 0;

        System.out.println("---REGISTRAR NOTA DE ENTRADA---");
        try {
            List<Fornecedor> fornecedores = dao.listarFornecedor();
            System.out.println("Digite o ID do fornecedor: ");
            idFornecedor = leia.nextInt();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try{
                System.out.println("Digite a data da entrada: ");
                String data = leia.nextLine();
                dataEntrada = LocalDate.parse(data);
            }catch (DateTimeParseException erro){
                System.out.println("Erro! Digite um formato de data válido (yyyy-MM-dd).");
            }

        }catch (SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao listar fornecedores.");
        }

        List

        try{
            var notaEntrada = new NotaEntrada(idFornecedor, dataEntrada);
            daoN.registrarNotaEntrada(notaEntrada);
            System.out.println("Nota de entrada registrada com sucesso!");
        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao registrar nota de entrada");
        }
    }

    public static void exibirListaFornecedores(List<Fornecedor> fornecedores){

        for(Fornecedor fornecedor : fornecedores){
            System.out.println("---------------------------");
            System.out.println("ID do fornecedor: " + fornecedor.getId());
            System.out.println("Nome do fornecedor: " + fornecedor.getNome());
            System.out.println("CNPJ do fornecedor: " + fornecedor.getCnpj());
            System.out.println("---------------------------");
        }
    }
}