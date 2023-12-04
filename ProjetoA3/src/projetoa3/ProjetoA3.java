package projetoa3;

public class ProjetoA3 {

    public static void main(String[] args) {
        
        //Times timesJanela = new Times();
        //timesJanela.setVisible(true);
        //Frutas frutasJanela = new Frutas();
        //frutasJanela.setVisible(true);
        
        LoginUsuario loginUsuario = new LoginUsuario();
        loginUsuario.setTitle("Login");
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
