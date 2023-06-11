package br.unipar.central.executions;

import br.unipar.central.models.PessoaJuridicaPOJO;
import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.PessoaJuridicaService;
import java.util.List;
import java.util.Scanner;

public class PessoaJuridicaExecution {

    public String Insert() {
        try {
            PessoaJuridicaPOJO pessoaJuridica = new PessoaJuridicaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a razão social da pessoaJuridica: ");
            pessoaJuridica.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            System.out.println("Informe o cnae da pessoaJuridica: ");
            pessoaJuridica.setCnaePrincipal(scanner.nextLine());
            System.out.println("Informe o nome fantasia da pessoaJuridica: ");
            pessoaJuridica.setNomeFantasia(scanner.nextLine());
            System.out.println("Informe o id da pessoa: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaJuridica.setPessoa(pessoaPOJO);

            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            pessoaJuridicaService.insert(pessoaJuridica);
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
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            List<PessoaJuridicaPOJO> procurarPorPessoaJuridica = pessoaJuridicaService.findAll();
            PessoaJuridicaPOJO pessoaJuridicaPOJO = new PessoaJuridicaPOJO();
            pessoaJuridicaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorPessoaJuridica.toString();
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
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            PessoaJuridicaPOJO pessoaJuridica = new PessoaJuridicaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o CNPJ de  : ");
            String cpf = scanner.nextLine();
            pessoaJuridica.setCNPJ(cpf);
            PessoaJuridicaPOJO pessoaJuridicaPOJO = new PessoaJuridicaPOJO();
            pessoaJuridicaPOJO.message();
            String msg = "Item encontrado: " + pessoaJuridicaService.findById(pessoaJuridica.getCNPJ());
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

            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            PessoaJuridicaPOJO pessoaJuridica = new PessoaJuridicaPOJO();

            System.out.println("Informe o CNPJ de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            pessoaJuridicaService.delete(pessoaJuridica.getCNPJ());
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
            PessoaJuridicaPOJO pessoaJuridica = new PessoaJuridicaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a razão social da pessoaJuridica: ");
            pessoaJuridica.setRazaoSocial(scanner.nextLine());
            
            System.out.println("Informe o cnpj de pessoaJuridica: ");
            pessoaJuridica.setCNPJ(scanner.nextLine());
            
            System.out.println("Informe o cnae da pessoaJuridica: ");
            pessoaJuridica.setCnaePrincipal(scanner.nextLine());
            
            System.out.println("Informe o nome fantasia da pessoaJuridica: ");
            pessoaJuridica.setNomeFantasia(scanner.nextLine());
            
            System.out.println("Informe o id da pessoa: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            pessoaJuridica.setPessoa(pessoaPOJO);
            
            
            PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
            pessoaJuridicaService.update(pessoaJuridica);
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
