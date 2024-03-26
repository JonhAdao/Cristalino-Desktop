/**
 * @author John
 */
package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.manicure.model.Horario;

public class HorarioDAO {


    private static final String HORARIOS = "SELECT id, hora FROM horario ORDER BY hora ASC";

    public static List<Horario> horarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Horario> horarios = new ArrayList();
        try {
            conn = new Conexao().getConexao();
            stmt = conn.prepareStatement(HORARIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Horario horas = new Horario();
                horas.setId(rs.getInt(1));
                horas.setHora(rs.getTime(2));
                horarios.add(horas);
            }
            return horarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
