package br.unipar.central.executions;

import br.unipar.central.models.AgenciaPOJO;
import br.unipar.central.models.BancoPOJO;
import br.unipar.central.services.AgenciaService;
import java.util.List;
import java.util.Scanner;

public class AgenciaExecution {

    public String Insert() {
        try {
            AgenciaPOJO agencia = new AgenciaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            
            System.out.println("Informe o ra de aluno que está cadastrando essa agencia: ");
            agencia.setRa(scanner.nextLine());
            
            System.out.println("Informe o id do banco atrelado a essa agência: ");
            BancoPOJO bancoPOJO = new BancoPOJO();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.insert(agencia);
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
            AgenciaService agenciaService = new AgenciaService();
            List<AgenciaPOJO> procurarPorAgencia = agenciaService.findAll();
            AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
            agenciaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorAgencia.toString();
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
            AgenciaService agenciaService = new AgenciaService();
            AgenciaPOJO agencia = new AgenciaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID da agência para realizar a busca: ");
            int id = scanner.nextInt();
            agencia.setId(id);
            AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
            agenciaPOJO.message();
            String msg = "Item encontrado: " + agenciaService.findById(agencia.getId());
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

            AgenciaService agenciaService = new AgenciaService();
            AgenciaPOJO agencia = new AgenciaPOJO();

            System.out.println("Informe o ID de agencia: ");
            agencia.setId(scanner.nextInt());
            agenciaService.delete(agencia.getId());
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
            AgenciaPOJO agencia = new AgenciaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de agencia: ");
            agencia.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o código da agencia: ");
            agencia.setCodigo(scanner.nextLine());
            System.out.println("Informe o dígito de agencia: ");
            agencia.setDigito(scanner.nextLine());
            System.out.println("Informe a razão social da agencia: ");
            agencia.setRazaoSocial(scanner.nextLine());
            System.out.println("Informe o cnpj da agencia: ");
            agencia.setCnpj(scanner.nextLine());
            System.out.println("Informe o ra de aluno que está dando update nessa agência: ");
            agencia.setRa(scanner.nextLine());
            System.out.println("Informe o id do banco atrelado a essa agência: ");
            BancoPOJO bancoPOJO = new BancoPOJO();
            bancoPOJO.setId(scanner.nextInt());
            agencia.setBanco(bancoPOJO);
            AgenciaService agenciaService = new AgenciaService();
            agenciaService.update(agencia);
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