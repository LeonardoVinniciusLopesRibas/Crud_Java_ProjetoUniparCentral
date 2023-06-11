package br.unipar.central.executions;

import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.PessoaService;
import java.util.List;
import java.util.Scanner;

public class PessoaExecution {

    public String Insert() {
        try {
            PessoaPOJO pessoa = new PessoaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de pessoa: ");
            pessoa.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o email da pessoa: ");
            pessoa.setEmail(scanner.nextLine());
            System.out.println("Informe o ra do aluno que está cadastrando essa pessoa: ");
            pessoa.setRa(scanner.nextLine());
            PessoaService pessoaService = new PessoaService();
            pessoaService.insert(pessoa);
            String msg = "Inserido com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindAll() {
        try {
            PessoaService pessoaService = new PessoaService();
            List<PessoaPOJO> procurarPorPessoa = pessoaService.findAll();
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorPessoa.toString();
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String FindById() {
        try {
            PessoaService pessoaService = new PessoaService();
            PessoaPOJO pessoa = new PessoaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de pessoa para realizar a busca: ");
            int id = scanner.nextInt();
            pessoa.setId(id);
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.message();
            String msg = "Item encontrado: " + pessoaService.findById(pessoa.getId());
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String DeleteById() {
        try {
            Scanner scanner = new Scanner(System.in);

            PessoaService pessoaService = new PessoaService();
            PessoaPOJO pessoa = new PessoaPOJO();

            System.out.println("Informe o ID de pessoa: ");
            pessoa.setId(scanner.nextInt());
            pessoaService.delete(pessoa.getId());
            String msg = "Item deletado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }

    public String Update() {
        try {
            PessoaPOJO pessoa = new PessoaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o id de pessoa: ");
            pessoa.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o email da pessoa: ");
            pessoa.setEmail(scanner.nextLine());
            System.out.println("Informe o ra do aluno que está realizando update pessoa: ");
            pessoa.setRa(scanner.nextLine());
            PessoaService pessoaService = new PessoaService();
            pessoaService.update(pessoa);
            String msg = "Update realizado com sucesso";
            System.out.println(msg);
            return msg;
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
            return msg;
        }
    }
}
