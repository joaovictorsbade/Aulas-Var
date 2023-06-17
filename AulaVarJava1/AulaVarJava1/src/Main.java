import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String mensagem = "1° codigo em Java";
        System.out.println(mensagem + " " + "Hello worls!!");

//        String retornoMetodo = inserirNome();
//        System.out.println(retornoMetodo);
//
//        double imc = calcularIMC();
//        System.out.println("IMC: " + imc);
//
//        int String = verificarIdade();
//          System.out.println();

        List<String> retornoMensagem = resumoPessoa();
        System.out.println(retornoMensagem);

    }

//    public static String inserirNome(){
//    Scanner ler = new Scanner(System.in);
//
//    System.out.println("Digite seu nome:");
//    String nome = ler.next();
//
//    System.out.println("Digite seu sobrenome:");
//    String sobrenome = ler.next();
//
//
//
//    String nomeCompleto = nome + " " + sobrenome;
//
//    return nomeCompleto;
//    }
//
//    public static double calcularIMC(){
//        Scanner ler = new Scanner(System.in);
//
//        System.out.println("Digite sua altura:");
//        double altura = ler.nextDouble();
//
//        System.out.println("Digite seu peso:");
//        double peso = ler.nextDouble();
//
//        double calculoIMC = peso / (altura * altura);
//
//        System.out.println("Seu IMC é:" + calculoIMC);
//
//        if(calculoIMC < 19.0){
//             String classificacao = "Você está abaixo do peso";
//             System.out.println(classificacao);
//        }
//        else if(calculoIMC < 25.0){
//            String classificacao = "Você está no peso ideal";
//            System.out.println(classificacao);
//        }
//        else if(calculoIMC < 29.0){
//            String classificacao = "Você está com sobrepeso";
//            System.out.println(classificacao);
//        }
//        else if(calculoIMC > 30){
//            String classificacao = "Você está em estado de obesidade";
//            System.out.println(classificacao);
//        }
//        return calculoIMC;
//    }
//
//    public static int verificarIdade(){
//        Scanner ler = new Scanner(System.in);
//        int anoAtual = 2023;
//        System.out.println("Digite sua data de nascimento");
//        int dataNascimento = ler.nextInt();
//        int idade = anoAtual - dataNascimento;
//
//        if(idade > 18){
//            String faixaEtaria = "Maior de Idade";
//            System.out.println(faixaEtaria);
//        }
//        else{
//            String faixaEtaria = "Menor de Idade";
//            System.out.println(faixaEtaria);
//        }
//
//        return verificarIdade();
//    }

    public static List<String> resumoPessoa() {

        List<String> nomesResumo =  new ArrayList<>();

        for(int indice = 1; indice < 4; indice ++) {

            Scanner ler = new Scanner(System.in);
            int anoAtual = 2023;
            String classificacao = "NADA";
            String faixaEtaria = "NADA";

            System.out.println("Digite seu nome:");
            String nome = ler.next();

            System.out.println("Digite seu sobrenome:");
            String sobrenome = ler.next();

            String nomeCompleto = nome + " " + sobrenome;

            System.out.println("Digite sua data de nascimento");
            int dataNascimento = ler.nextInt();

            int idade = anoAtual - dataNascimento;

            System.out.println("Digite sua altura:");
            double altura = ler.nextDouble();

            System.out.println("Digite seu peso:");
            double peso = ler.nextDouble();

            double calculoIMC = peso / (altura * altura);

            if (idade >= 18) {
                faixaEtaria = "Maior de Idade";

            } else {
                faixaEtaria = "Menor de Idade";

            }

            if (calculoIMC < 19.0) {
                classificacao = "Você está abaixo do peso";

            } else if (calculoIMC < 25.0) {
                classificacao = "Você está no peso ideal";

            } else if (calculoIMC < 29.0) {
                classificacao = "Você está com sobrepeso";

            } else if (calculoIMC > 30) {
                classificacao = "Você está em estado de obesidade";

            }

            String resumo = "Seu nome completo é " + nomeCompleto + ", você tem " + idade + " anos e é " + faixaEtaria + ", tem o IMC de:" + calculoIMC + " e " + classificacao;

            System.out.println(resumo);

            nomesResumo.add(resumo);

        }
            return resumoPessoa();
    }

}