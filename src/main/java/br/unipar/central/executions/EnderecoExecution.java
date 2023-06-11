package br.unipar.central.executions;

import br.unipar.central.models.CidadePOJO;
import br.unipar.central.models.EnderecoPOJO;
import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.EnderecoService;
import java.util.List;
import java.util.Scanner;

public class EnderecoExecution {

    public String Insert() {
        try {
            EnderecoPOJO endereco = new EnderecoPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.println("Informe o ra do aluno que está inserindo nessa agêencia: ");
            endereco.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de pessoa atrelada a esse endereço: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            endereco.setPessoa(pessoaPOJO);
            
            System.out.println("Informe o id da agencia atrelada a esse endereço: ");
            CidadePOJO cidadePOJO = new CidadePOJO();
            cidadePOJO.setId(scanner.nextInt());
            endereco.setCidade(cidadePOJO);

            EnderecoService enderecoService = new EnderecoService();
            enderecoService.insert(endereco);
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
            EnderecoService enderecoService = new EnderecoService();
            List<EnderecoPOJO> procurarPorEndereco = enderecoService.findAll();
            EnderecoPOJO enderecoPOJO = new EnderecoPOJO();
            enderecoPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorEndereco.toString();
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
            EnderecoService enderecoService = new EnderecoService();
            EnderecoPOJO endereco = new EnderecoPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de endereço para realizar a busca: ");
            int id = scanner.nextInt();
            endereco.setId(id);
            EnderecoPOJO enderecoPOJO = new EnderecoPOJO();
            enderecoPOJO.message();
            String msg = "Item encontrado: " + enderecoService.findById(endereco.getId());
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

            EnderecoService enderecoService = new EnderecoService();
            EnderecoPOJO endereco = new EnderecoPOJO();

            System.out.println("Informe o ID de endereco: ");
            endereco.setId(scanner.nextInt());
            enderecoService.delete(endereco.getId());
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
            EnderecoPOJO endereco = new EnderecoPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de endereco: ");
            endereco.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da rua: ");
            endereco.setLogradouro(scanner.nextLine());

            System.out.println("Informe o número da casa: ");
            endereco.setNumero(scanner.nextLine());

            System.out.println("Informe o bairro: ");
            endereco.setBairro(scanner.nextLine());

            System.out.println("Informe o cep: ");
            endereco.setCep(scanner.nextLine());
            
            System.out.println("Informe o complemento: ");
            endereco.setComplemento(scanner.nextLine());

            System.out.println("Informe o ra do aluno que está dando update: ");
            endereco.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de pessoa atrelada a esse endereço: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            endereco.setPessoa(pessoaPOJO);
            
            System.out.println("Informe o id da agencia atrelada a esse endereço: ");
            CidadePOJO cidadePOJO = new CidadePOJO();
            cidadePOJO.setId(scanner.nextInt());
            endereco.setCidade(cidadePOJO);
            
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.update(endereco);
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
