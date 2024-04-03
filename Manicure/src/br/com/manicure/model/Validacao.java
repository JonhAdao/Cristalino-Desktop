/**
 * @author Lais Frigério da Silva
 */
package br.com.manicure.model;

import br.com.manicure.DAO.ClientesDAO;
import br.com.manicure.DAO.UsuarioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Validacao {

    public static boolean isEmpty(String v) {
        return v.isEmpty();
    }

    public static boolean isLessOrEqualThan(String v, int tam) {
        return v.length() <= tam;
    }

    public static boolean lengthIsEqualsTo(String v, int tam) {
        return v.length() == tam;
    }

    public static boolean equals(String v, int tam) {
        return v.length() == tam;
    }

    public static boolean isNumeric(String n) {
        try {
            Long.parseLong(n);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean hasOnlyLettersAndNumbers(String n) {
        return n.matches("^[a-zA-Z0-9]*$");
    }

    public static boolean isDouble(String p) {
        try {
            Double.parseDouble(p);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isDate(String d) {
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(d);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean dateIsValid(String data) {
        String[] vetor = data.split("/");
        int ano = Integer.parseInt(vetor[2]);
        int mes = Integer.parseInt(vetor[1]);
        int dia = Integer.parseInt(vetor[0]);
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (ano < 1850 || ano > (anoAtual + 1)) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1) {
            return false;
        }
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 12 || mes == 10) {
            if (dia > 31) {
                return false;
            }
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                return false;
            }
        }
        if (mes == 2 && ano % 2 == 0 && dia > 29) {
            return false;
        }
        if (mes == 2 && ano % 2 != 0 && dia > 28) {
            return false;
        }
        return true;
    }

    public static boolean timeIsValid(String t) {
        String[] v = t.split(":");
        if (Integer.parseInt(v[0]) < 0 || Integer.parseInt(v[0]) > 23) {
            return false;
        }
        if (Integer.parseInt(v[1]) < 0 || Integer.parseInt(v[1]) > 59) {
            return false;
        }
        return true;
    }

    public static boolean CPFisValid(String cpf) {

        if (cpf.equals("11111111111")
                || cpf.equals("22222222222")
                || cpf.equals("33333333333")
                || cpf.equals("44444444444")
                || cpf.equals("55555555555")
                || cpf.equals("66666666666")
                || cpf.equals("77777777777")
                || cpf.equals("88888888888")
                || cpf.equals("99999999999")) {
            return false;
        }

        return true;
    }

    public static boolean CPFexists(String cpf, int id) {
        return ClientesDAO.CPFExists(cpf, id);
    }

    /* public static boolean loginExists(String login, int id) {
        return UsuarioDAO.loginExists(login, id);
    }*/
    public static boolean hasComma(String v) {
        return v.contains(",");
    }

    public static String setDateMask(String d) {
        return d.substring(0, 2) + "/" + d.substring(2, 4) + "/" + d.substring(4, 8);
    }
}
