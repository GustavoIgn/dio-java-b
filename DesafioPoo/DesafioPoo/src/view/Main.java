package view;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\t1. Adicionar Curso");
            System.out.println("\t2. Adicionar Mentoria");
            System.out.println("\t3. Inscrever Dev no Bootcamp");
            System.out.println("\t4. Mostrar Devs Inscritos");
            System.out.println("\t5. Progredir Dev");
            System.out.println("\t6. Consultar Conteúdos Inscritos do Dev");
            System.out.println("\t7. Consultar Conteúdos Concluídos do Dev");
            System.out.println("\t8. Consultar XP do Dev");
            System.out.println("\t9. Sair");
            System.out.print("\tEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Curso curso = new Curso();
                    System.out.print("Título do curso: ");
                    curso.setTitulo(scanner.nextLine());
                    System.out.print("Descrição do curso: ");
                    curso.setDescricao(scanner.nextLine());
                    System.out.print("Carga horária do curso: ");
                    curso.setCargaHoraria(scanner.nextInt());
                    scanner.nextLine();
                    bootcamp.getConteudos().add(curso);
                    System.out.println("Curso adicionado com sucesso!");
                    break;
                case 2:
                    Mentoria mentoria = new Mentoria();
                    System.out.print("Título da mentoria: ");
                    mentoria.setTitulo(scanner.nextLine());
                    System.out.print("Descrição da mentoria: ");
                    mentoria.setDescricao(scanner.nextLine());
                    mentoria.setData(LocalDate.now());
                    bootcamp.getConteudos().add(mentoria);
                    System.out.println("Mentoria adicionada com sucesso!");
                    break;
                case 3:
                    Dev dev = new Dev();
                    System.out.print("Nome do Dev: ");
                    dev.setNome(scanner.nextLine());
                    dev.inscreverBootcamp(bootcamp);
                    System.out.println("Dev inscrito com sucesso!");
                    break;
                case 4:
                    System.out.println("Devs Inscritos no Bootcamp:");
                    for (Dev inscrito : bootcamp.getDevsInscritos()) {
                        System.out.println(inscrito.getNome());
                    }
                    break;
                case 5:
                    System.out.print("Nome do Dev que vai progredir: ");
                    String nomeDevProgredir = scanner.nextLine();
                    Dev devParaProgredir = bootcamp.getDevsInscritos().stream()
                            .filter(d -> d.getNome().equals(nomeDevProgredir))
                            .findFirst()
                            .orElse(null);
                    if (devParaProgredir != null) {
                        devParaProgredir.progredir();
                        System.out.println("Dev progrediu!");
                    } else {
                        System.out.println("Dev não encontrado!");
                    }
                    break;
                case 6:
                    System.out.print("Nome do Dev para consultar conteúdos inscritos: ");
                    String nomeDevConteudosInscritos = scanner.nextLine();
                    Dev devParaConsultarConteudosInscritos = bootcamp.getDevsInscritos().stream()
                            .filter(d -> d.getNome().equals(nomeDevConteudosInscritos))
                            .findFirst()
                            .orElse(null);
                    if (devParaConsultarConteudosInscritos != null) {
                        System.out.println("Conteúdos Inscritos de " + nomeDevConteudosInscritos + ": " + devParaConsultarConteudosInscritos.getConteudosInscritos());
                    } else {
                        System.out.println("Dev não encontrado!");
                    }
                    break;
                case 7:
                    System.out.print("Nome do Dev para consultar conteúdos concluídos: ");
                    String nomeDevConteudosConcluidos = scanner.nextLine();
                    Dev devParaConsultarConteudosConcluidos = bootcamp.getDevsInscritos().stream()
                            .filter(d -> d.getNome().equals(nomeDevConteudosConcluidos))
                            .findFirst()
                            .orElse(null);
                    if (devParaConsultarConteudosConcluidos != null) {
                        System.out.println("Conteúdos Concluídos de " + nomeDevConteudosConcluidos + ": " + devParaConsultarConteudosConcluidos.getConteudosConcluidos());
                    } else {
                        System.out.println("Dev não encontrado!");
                    }
                    break;
                case 8:
                    System.out.print("Nome do Dev para consultar XP: ");
                    String nomeDevXP = scanner.nextLine();
                    Dev devParaConsultarXP = bootcamp.getDevsInscritos().stream()
                            .filter(d -> d.getNome().equals(nomeDevXP))
                            .findFirst()
                            .orElse(null);
                    if (devParaConsultarXP != null) {
                        System.out.println("XP de " + nomeDevXP + ": " + devParaConsultarXP.calcularTotalXp());
                    } else {
                        System.out.println("Dev não encontrado!");
                    }
                    break;
                case 9:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
