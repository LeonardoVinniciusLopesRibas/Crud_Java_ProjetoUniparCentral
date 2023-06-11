/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.executions;

import br.unipar.central.models.CidadePOJO;
import br.unipar.central.models.BancoPOJO;
import br.unipar.central.models.EstadoPOJO;
import br.unipar.central.services.CidadeService;
import java.util.List;
import java.util.Scanner;

public class CidadeExecution {

    public String Insert() {
        try {
            CidadePOJO cidade = new CidadePOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de cidade: ");
            cidade.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da cidade: ");
            cidade.setNome(scanner.nextLine());
            System.out.println("Informe o ra de cidade: ");
            cidade.setRa(scanner.nextLine());
            System.out.println("Informe o id do estado: ");
            EstadoPOJO estadoPOJO = new EstadoPOJO();
            estadoPOJO.setId(scanner.nextInt());
            cidade.setEstado(estadoPOJO);
            CidadeService cidadeService = new CidadeService();
            cidadeService.insert(cidade);
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
            CidadeService cidadeService = new CidadeService();
            List<CidadePOJO> procurarPorCidade = cidadeService.findAll();
            CidadePOJO cidadePOJO = new CidadePOJO();
            cidadePOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorCidade.toString();
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
            CidadeService cidadeService = new CidadeService();
            CidadePOJO cidade = new CidadePOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            cidade.setId(id);
            CidadePOJO cidadePOJO = new CidadePOJO();
            cidadePOJO.message();
            String msg = "Item encontrado: " + cidadeService.findById(cidade.getId());
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

            CidadeService cidadeService = new CidadeService();
            CidadePOJO cidade = new CidadePOJO();

            System.out.println("Informe o ID de cidade: ");
            cidade.setId(scanner.nextInt());
            cidadeService.delete(cidade.getId());
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
            CidadePOJO cidade = new CidadePOJO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o id de cidade: ");
            cidade.setId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Informe o nome da cidade: ");
            cidade.setNome(scanner.nextLine());
            System.out.println("Informe o ra de cidade: ");
            cidade.setRa(scanner.nextLine());
            System.out.println("Informe o id do estado: ");
            EstadoPOJO estadoPOJO = new EstadoPOJO();
            estadoPOJO.setId(scanner.nextInt());
            cidade.setEstado(estadoPOJO);
            CidadeService cidadeService = new CidadeService();
            cidadeService.update(cidade);
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
