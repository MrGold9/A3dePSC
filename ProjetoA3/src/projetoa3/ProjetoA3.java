package projetoa3;

public class ProjetoA3 {

    public static void main(String[] args) {

        System.out.println("Oi mundo");
        
        //Times timesJanela = new Times();
        //timesJanela.setVisible(true);
        //Frutas frutasJanela = new Frutas();
        //frutasJanela.setVisible(true);
        
        Menu menuJanela = new Menu();
        menuJanela.setTitle("CRUDS EXEMPLO");
        menuJanela.setVisible(true);
        
        DB db = new DB("bancodados.db");
        db.query("SELECT * FROM frutas");
        while(db.next()) {
            int codigo = db.getInt("codigo");
            String nome = db.getString("nome");
            System.out.println("CODIGO: "+codigo+" NOME: "+nome);
        }
        db.closeConnection();
        
    }
    
}
