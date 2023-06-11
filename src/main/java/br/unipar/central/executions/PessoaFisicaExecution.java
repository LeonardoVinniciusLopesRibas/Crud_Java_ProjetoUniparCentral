package br.unipar.central.executions;

import br.unipar.central.models.PessoaFisicaPOJO;
import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.PessoaFisicaService;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class PessoaFisicaExecution {

    public String Insert() {
        try {
            PessoaFisicaPOJO pessoaFisica = new PessoaFisicaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o nome da pessoaFisica: ");
            pessoaFisica.setNome(scanner.nextLine());
            System.out.println("Informe o cpf de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            System.out.println("Informe a rg da pessoaFisica: ");
            pessoaFisica.setRg(scanner.nextLine());
            System.out.println("Informe a data de nascimento da pessoaFisica: ");
            System.out.println("Informe ano:");
            int year = scanner.nextInt();
            System.out.println("Informe mês:");
            int month = scanner.nextInt();
            System.out.println("Informe dia:");
            int day = scanner.nextInt();
            Date dataNascimento = new Date(year - 1900, month - 1, day);
            pessoaFisica.setDataNascimento(dataNascimento);

            System.out.println("Informe o id da pessoa: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaFisica.setPessoa(pessoaPOJO);

            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            pessoaFisicaService.insert(pessoaFisica);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao inserir " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            List<PessoaFisicaPOJO> procurarPorPessoaFisica = pessoaFisicaService.findAll();
            PessoaFisicaPOJO pessoaFisicaPOJO = new PessoaFisicaPOJO();
            pessoaFisicaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorPessoaFisica.toString();
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao buscar todos os itens: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindById() {
        try {
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            PessoaFisicaPOJO pessoaFisica = new PessoaFisicaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o CPF de  : ");
            String cpf = scanner.nextLine();
            pessoaFisica.setCpf(cpf);
            PessoaFisicaPOJO pessoaFisicaPOJO = new PessoaFisicaPOJO();
            pessoaFisicaPOJO.message();
            String msg = "Item encontrado: " + pessoaFisicaService.findById(pessoaFisica.getCpf());
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao buscar o item por ID: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String DeleteById() {
        try {
            Scanner scanner = new Scanner(System.in);

            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            PessoaFisicaPOJO pessoaFisica = new PessoaFisicaPOJO();

            System.out.println("Informe o CPF de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            pessoaFisicaService.delete(pessoaFisica.getCpf());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao deletar o item por ID: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() {
        try {
            PessoaFisicaPOJO pessoaFisica = new PessoaFisicaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o nome da pessoaFisica: ");
            pessoaFisica.setNome(scanner.nextLine());
            System.out.println("Informe o cpf de pessoaFisica: ");
            pessoaFisica.setCpf(scanner.nextLine());
            System.out.println("Informe a rg da pessoaFisica: ");
            pessoaFisica.setRg(scanner.nextLine());
            System.out.println("Informe a data de nascimento da pessoaFisica: ");
            System.out.println("Informe ano:");
            int year = scanner.nextInt();
            System.out.println("Informe mês:");
            int month = scanner.nextInt();
            System.out.println("Informe dia:");
            int day = scanner.nextInt();
            Date dataNascimento = new Date(year - 1900, month - 1, day);
            pessoaFisica.setDataNascimento(dataNascimento);

            System.out.println("Informe o id da pessoa: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaFisica.setPessoa(pessoaPOJO);
            PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
            pessoaFisicaService.update(pessoaFisica);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = "Erro ao dar update: " + ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

}
