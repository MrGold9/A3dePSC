package projetoa3;

public class ProjetoA3 {

    public static void main(String[] args) {
        
         
        LoginUsuario loginUsuario = new LoginUsuario();
        loginUsuario.setTitle("Login");
        loginUsuario.setSize(910, 540);
        loginUsuario.setLocation(0, 0);
        loginUsuario.setVisible(true);
        
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM funcionarios");
        while(db.next()) {
            int id = db.getInt("id");
            String nome = db.getString("nome");
            int cpf = db.getInt("cpf");
            String dataNascimento = db.getString("dataNascimento");
            String estadoCivil = db.getString("estadoCivil");
        }
        db.closeConnection();
        
    }
    
}
