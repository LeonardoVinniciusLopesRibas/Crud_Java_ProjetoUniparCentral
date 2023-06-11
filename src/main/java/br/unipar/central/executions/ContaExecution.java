package br.unipar.central.executions;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.models.AgenciaPOJO;
import br.unipar.central.models.ContaPOJO;  
import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.ContaService;
import java.util.List;
import java.util.Scanner;

public class ContaExecution {

    public String Insert() {
        try {
            ContaPOJO conta = new ContaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setNumero(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Saldo da conta (padrão inicia-se em zero)!");
            conta.setSaldo(0);

            System.out.println("Informe o tipo da conta (1 para corrente, - 2 para poupança, - 3 para salário):");
            int tipoContaStr = scanner.nextInt();
            TipoContaEnum tipoConta;

            switch (tipoContaStr) {
                case 1:
                    tipoConta = TipoContaEnum.CORRENTE;
                    break;
                case 2:
                    tipoConta = TipoContaEnum.POUPANCA;
                    break;
                case 3:
                    tipoConta = TipoContaEnum.SALARIO;
                    break;
                default:

                    tipoConta = null;
                    break;
            }
            conta.setTipoConta(tipoConta);
            scanner.nextLine();

            System.out.println("Informe o ra do aluno que está inserindo essa conta: ");
            conta.setRa(scanner.nextLine());

            System.out.println("Informe o id da agencia atrelada a essa conta: ");
            AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
            agenciaPOJO.setId(scanner.nextInt());
            conta.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa atrelada a essa conta: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            conta.setPessoa(pessoaPOJO);
            ContaService contaService = new ContaService();
            contaService.insert(conta);
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
            ContaService contaService = new ContaService();
            List<ContaPOJO> procurarPorConta = contaService.findAll();
            ContaPOJO contaPOJO = new ContaPOJO();
            contaPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorConta.toString();
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
            ContaService contaService = new ContaService();
            ContaPOJO conta = new ContaPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID da conta para realizar a busca: ");
            int id = scanner.nextInt();
            conta.setId(id);
            ContaPOJO contaPOJO = new ContaPOJO();
            contaPOJO.message();
            String msg = "Item encontrado: " + contaService.findById(conta.getId());
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

            ContaService contaService = new ContaService();
            ContaPOJO conta = new ContaPOJO();

            System.out.println("Informe o ID de conta: ");
            conta.setId(scanner.nextInt());
            contaService.delete(conta.getId());
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
            ContaPOJO conta = new ContaPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de conta: ");
            conta.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o número da conta: ");
            conta.setNumero(scanner.nextLine());

            System.out.println("Informe o dígito de conta: ");
            conta.setDigito(scanner.nextLine());

            System.out.println("Informe o saldo da conta(Cuidado com o valor que irá adicionar a conta): ");
            conta.setSaldo(scanner.nextDouble());

            System.out.println("Informe o tipo da conta (1 para corrente, - 2 para poupança, - 3 para salário): ");
            String tipoContaStr = scanner.next();
            TipoContaEnum tipoConta;

            switch (tipoContaStr) {
                case "1":
                    tipoConta = TipoContaEnum.CORRENTE;
                    break;
                case "2":
                    tipoConta = TipoContaEnum.POUPANCA;
                    break;
                case "3":
                    tipoConta = TipoContaEnum.SALARIO;
                    break;
                default:

                    tipoConta = null;
                    break;
            }

            conta.setTipoConta(tipoConta);
            scanner.nextLine();
            
            System.out.println("Informe o ra do aluno que está dando update nessa conta: ");
            conta.setRa(scanner.nextLine());

            System.out.println("Informe o id da agencia atrelada a essa conta: ");
            AgenciaPOJO agenciaPOJO = new AgenciaPOJO();
            agenciaPOJO.setId(scanner.nextInt());
            conta.setAgencia(agenciaPOJO);

            System.out.println("Informe o id de pessoa atrelada a essa conta: ");
            PessoaPOJO pessoaPOJO = new PessoaPOJO();
            pessoaPOJO.setId(scanner.nextInt());
            conta.setPessoa(pessoaPOJO);
            ContaService contaService = new ContaService();
            contaService.update(conta);
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
