package br.unipar.central.executions;

import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.TransacaoPOJO;
import br.unipar.central.services.TransacaoService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TransacaoExecution {

    public String Insert() {
        try {
            TransacaoPOJO transacao = new TransacaoPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transacao: ");
            transacao.setId(scanner.nextInt());
            System.out.println("Informe o valor da transacao: ");
            transacao.setValor(scanner.nextDouble());

            Calendar cal = Calendar.getInstance();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH) + 1;
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minuto = cal.get(Calendar.MINUTE);
            int segundo = cal.get(Calendar.SECOND);

            Timestamp dataHora = new Timestamp(cal.getTimeInMillis());
            transacao.setDatahora(dataHora);
            scanner.nextLine();
            System.out.println("Informe o tipo da conta (1 - CRÉDITO, 2 - DÉBITO, 3 - PIX, 0 - OUTROS): ");
            String tipoTransaStr;
            tipoTransaStr = scanner.nextLine();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                case "0":
                    tipoTransacao = TipoTransacaoEnum.OUTROS;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);

            System.out.println("Informe o ra de transacao: ");
            transacao.setRa(scanner.nextLine());

            System.out.println("Informe a conta de origem: ");
            transacao.setConta_origem(scanner.nextInt());

            System.out.println("Informe a conta de destino: ");
            transacao.setConta_destino(scanner.nextInt());

            TransacaoService transacaoService = new TransacaoService();
            transacaoService.insert(transacao);
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
            TransacaoService transacaoService = new TransacaoService();
            List<TransacaoPOJO> procurarPorTransacao = transacaoService.findAll();
            TransacaoPOJO transacaoPOJO = new TransacaoPOJO();
            transacaoPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorTransacao.toString();
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
            TransacaoService transacaoService = new TransacaoService();
            TransacaoPOJO transacao = new TransacaoPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            transacao.setId(id);
            TransacaoPOJO transacaoPOJO = new TransacaoPOJO();
            transacaoPOJO.message();
            String msg = "Item encontrado: " + transacaoService.findById(transacao.getId());
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

            TransacaoService transacaoService = new TransacaoService();
            TransacaoPOJO transacao = new TransacaoPOJO();

            System.out.println("Informe o ID de transacao: ");
            transacao.setId(scanner.nextInt());
            transacaoService.delete(transacao.getId());
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
            TransacaoPOJO transacao = new TransacaoPOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de transacao: ");
            transacao.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o valor da transacao: ");
            transacao.setValor(scanner.nextDouble());

            Calendar cal = Calendar.getInstance();
            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH) + 1;
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minuto = cal.get(Calendar.MINUTE);
            int segundo = cal.get(Calendar.SECOND);

            Timestamp dataHora = new Timestamp(cal.getTimeInMillis());
            transacao.setDatahora(dataHora);
            scanner.nextLine();

            System.out.println("Informe o tipo da conta (1 - CRÉDITO, 2 - DÉBITO, 3 - PIX, 0 - OUTROS): ");
            String tipoTransaStr = scanner.next();
            TipoTransacaoEnum tipoTransacao;

            switch (tipoTransaStr) {
                case "1":
                    tipoTransacao = TipoTransacaoEnum.CREDITO;
                    break;
                case "2":
                    tipoTransacao = TipoTransacaoEnum.DEBITO;
                    break;
                case "3":
                    tipoTransacao = TipoTransacaoEnum.PIX;
                    break;
                case "0":
                    tipoTransacao = TipoTransacaoEnum.OUTROS;
                    break;
                default:

                    tipoTransacao = null;
                    break;
            }
            transacao.setTipo(tipoTransacao);
            scanner.nextLine();
            System.out.println("Informe o ra de transacao: ");
            transacao.setRa(scanner.nextLine());

            System.out.println("Informe a conta de origem: ");
            transacao.setConta_origem(scanner.nextInt());

            System.out.println("Informe a conta de destino: ");
            transacao.setConta_destino(scanner.nextInt());

            TransacaoService transacaoService = new TransacaoService();
            transacaoService.update(transacao);
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
