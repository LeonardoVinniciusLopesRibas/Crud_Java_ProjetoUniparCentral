/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.unipar.central.executions;

import br.unipar.central.models.CidadePOJO;
import br.unipar.central.models.EstadoPOJO;
import br.unipar.central.models.PaisPOJO;
import br.unipar.central.models.PessoaPOJO;
import br.unipar.central.services.EstadoService;
import java.util.List;
import java.util.Scanner;

public class EstadoExecution {

    public String Insert() {
        try {
            EstadoPOJO estado = new EstadoPOJO();
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Informe o id de estado: ");
            estado.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da estado: ");
            estado.setNome(scanner.nextLine());

            System.out.println("Informe a sigla da estado: ");
            estado.setSigla(scanner.nextLine());

            System.out.println("Informe o ra: ");
            estado.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de país: ");
            PaisPOJO paisPOJO = new PaisPOJO();
            paisPOJO.setId(scanner.nextInt());
            estado.setPais(paisPOJO);

            EstadoService estadoService = new EstadoService();
            estadoService.insert(estado);
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
            EstadoService estadoService = new EstadoService();
            List<EstadoPOJO> procurarPorEstado = estadoService.findAll();
            EstadoPOJO estadoPOJO = new EstadoPOJO();
            estadoPOJO.message();
            String msg = "Todos os itens encontrados " + procurarPorEstado.toString();
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
            EstadoService estadoService = new EstadoService();
            EstadoPOJO estado = new EstadoPOJO();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe o ID de  : ");
            int id = scanner.nextInt();
            estado.setId(id);
            EstadoPOJO estadoPOJO = new EstadoPOJO();
            estadoPOJO.message();
            String msg = "Item encontrado: " + estadoService.findById(estado.getId());
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

            EstadoService estadoService = new EstadoService();
            EstadoPOJO estado = new EstadoPOJO();

            System.out.println("Informe o ID de estado: ");
            estado.setId(scanner.nextInt());
            estadoService.delete(estado.getId());
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
            EstadoPOJO estado = new EstadoPOJO();
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Informe o id de estado: ");
            estado.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Informe o nome da estado: ");
            estado.setNome(scanner.nextLine());

            System.out.println("Informe a sigla da estado: ");
            estado.setSigla(scanner.nextLine());

            System.out.println("Informe o ra: ");
            estado.setRa(scanner.nextLine());
            
            System.out.println("Informe o id de país: ");
            PaisPOJO paisPOJO = new PaisPOJO();
            paisPOJO.setId(scanner.nextInt());
            estado.setPais(paisPOJO);
            
            EstadoService estadoService = new EstadoService();
            estadoService.update(estado);
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
