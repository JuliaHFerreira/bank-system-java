package bank.utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexaoMySQL {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	String stop = null;
    	
        // URL de conexão com o banco de dados
        String url = "jdbc:mysql://127.0.0.1:3306/system_bank";
        String usuario = "root";
        String senha = null;

        Connection conexao = null;
        try {
        	do {
            // Estabelecendo a conexão com o banco de dados
        	conexao = DriverManager.getConnection(url, usuario, senha);
        	
        	//teste conexão
//        	String sql = "INSERT INTO CLIENT (NAME_CLIENT, DATE_OF_BIRTH, CPF, EMAIL, PHONE) VALUES (?, ?, ?, ?, ?)";
//        	PreparedStatement pstmt = conexao.prepareStatement(sql);
        	
//            System.out.println("Digite o nome do cliente:");
//            String nameClient = sc.nextLine();
//            
//            System.out.println("Digite a data de nascimento (YYYY-MM-DD):");
//            String dateOfBirth = sc.nextLine();
//            
//            System.out.println("Digite o CPF:");
//            String cpf = sc.nextLine();
//            
//            System.out.println("Digite o e-mail:");
//            String email = sc.nextLine();
//            
//            System.out.println("Digite o telefone:");
//            String phone = sc.nextLine();
//            
//            // Definindo os parâmetros do PreparedStatement
//            pstmt.setString(1, nameClient);
//            pstmt.setString(2, dateOfBirth);
//            pstmt.setString(3, cpf);
//            pstmt.setString(4, email);
//            pstmt.setString(5, phone);
            
            // Executando a inserção
//            int rowsInserted = pstmt.executeUpdate();
//            System.out.println(rowsInserted + " cliente(s) inserido(s) com sucesso!");

            System.out.println("Deseja continuar? Digite 'YES' para continuar ou qualquer outra coisa para sair.");
            stop = sc.nextLine().toUpperCase();
                
            } while(stop.equals("YES"));
          
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão fechada com sucesso!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
