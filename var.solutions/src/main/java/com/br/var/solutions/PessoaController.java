package com.br.var.solutions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {
    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("Joao");
        pessoaRequest1.setSobrenome("Barbosa");
        pessoaRequest1.setEndereco("Rua Joaquin Santos Leite");
        pessoaRequest1.setIdade(17);

        return ResponseEntity.ok(pessoaRequest1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha) {
        String imc = null;
        int anoNascimento = 0;
        String impostoRenda = null;
        String saldoEmDolar = null;
        String validaMundial = null;

        if (!pessoinha.getNome().isEmpty()) {
            log.info("Iniciando processo de resumo da pessoa: ", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())) {
                log.info("Iniciando o processo de cálculo do IMC");
                imc = calculaImc(pessoinha.getPeso(), pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando o cálculo do ano de nascimento");
                anoNascimento = calculaAnoNascimento(pessoinha.getIdade());
            }

            if (Objects.nonNull(pessoinha.getSalario())) {
                log.info("Iniciando o cálculo do imposto de renda");
                impostoRenda = calculoFaixaImpostoRenda(pessoinha.getSalario());
            }

            if (Objects.nonNull(pessoinha.getTime())) {
                log.info("Validando se o time de coração tem mundial: ");
                validaMundial = calculaMundial(pessoinha.getTime());
            }

            if (Objects.nonNull(pessoinha.getSaldo())) {
                log.info("Converter real em dolar");
                saldoEmDolar = converteSaldoEmDolar(pessoinha.getSaldo());
            }

            log.info("Montando objeto de retorno para o front-end");
            Object resumo = montarRespostaFrontEnd(pessoinha, imc, anoNascimento, impostoRenda, validaMundial, saldoEmDolar);


            return ResponseEntity.ok(resumo);
        }
        return ResponseEntity.noContent().build();
    }

    private PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoa, String imc, int anoNascimento, String impostoRenda, String validaMundial, String saldoEmDolar) {
        PessoaResponse response = new PessoaResponse();
        response.setNome(pessoa.getNome());
        response.setImc(imc);
        response.setSalario(impostoRenda);
        response.setAnoNascimento(anoNascimento);
        response.setMundialClubes(validaMundial);
        response.setSaldoEmDolar(saldoEmDolar);
        response.setIdade(pessoa.getIdade());

        return response;
    }

    private String converteSaldoEmDolar(double saldo) {
        return String.valueOf(saldo / 4.49);
    }

    private String calculaMundial(String time) {
        if (time.equalsIgnoreCase("Corinthians")) {
            return "Parabéns, o seu time possui dois mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("São Paulo")) {
            return "Parabéns, o seu time possui Três mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "Parabéns, o seu time possui dois mundiais de clubes conforme a FIFA";
        } else {
            return "Poxa, que pena, continue torcendo para seu time ganhar um mundial";
        }
    }

    private String calculoFaixaImpostoRenda(double salario) {
        log.info("Iniciando o cálculo do imposto de renda");
        String novoSalarioCalculado;


        if (salario < 1903.98) {
            return "isento";

        } else if (salario > 1903.98 && salario < 2826.65) {
            double calculoIRF = 142.80 - ((salario * 0.075) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;

        } else if (salario > 2826.65 && salario < 3751.05) {
            double calculoIRF = 354.80 - ((salario * 0.15) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;

        } else if (salario > 3751.05 && salario < 4664.68) {
            double calculoIRF = 636.13 - ((salario * 0.225) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;

        } else {
            double calculoIRF = 869.36 - ((salario * 275) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;
        }
    }

    private int calculaAnoNascimento(int idade) {
        LocalDate datalocal = LocalDate.now();
        int anoAtual = datalocal.getYear();
        return anoAtual - idade;
    }

    private String calculaImc(double peso, double altura) {
        double imc = peso / (altura * altura);

        if (imc < 18.5) {
            return "O IMC calculado é: " + imc + "e você está abaixo do peso.";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "O IMC calculado é: " + imc + "e você está no peso ideal.";
        } else if (imc > 24.9 && imc <= 29.9) {
            return "O IMC calculado é: " + imc + "e você está com excesso de peso.";
        } else if (imc > 29.9 && imc <= 34.9) {
            return "O IMC calculado é: " + imc + "e você está em estado de Obesidade classe I.";
        } else if (imc > 34.9 && imc < 39.9) {
            return "O IMC calculado é: " + imc + "e você está em estado de Obesidade classe II ";
        } else {
            return "O IMC calculado é: \" + imc + \" e você está em estado de Obesidade classe III";
        }
    }

}
