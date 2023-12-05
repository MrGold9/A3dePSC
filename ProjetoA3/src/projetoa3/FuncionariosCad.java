package projetoa3;


public class FuncionariosCad extends javax.swing.JFrame {
    private final Funcionarios janelaFuncionarios;
    private final int id;
    
    public FuncionariosCad(Funcionarios janelaFuncionarios, int id) {
        initComponents();
        this.janelaFuncionarios = janelaFuncionarios;
        this.id = id;
        if(id != -1) {
            this.setTitle("EDITAR FUNCIONARIOS");
            DB db = new DB("bancodados.db");
            db.query("SELECT * FROM funcionarios WHERE id="+id);
            if(db.next()) {
                String datanascimento = db.getString("dataNascimento");
                String nome = db.getString("nome");
                String estadocivil = db.getString("estadoCivil");
                int cpf = db.getInt("cpf");
                txtdatanascimento.setText(datanascimento);
                txtestadocivil.setText(estadocivil);
                txtNome.setText(nome);
                txtCPF.setText(String.valueOf(cpf));
                
                
            }
            db.closeConnection();        
        } else {
            this.setTitle("NOVO FUNCIONARIO");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtdatanascimento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtestadocivil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Data de nascimento:");

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado Civil:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(52, 52, 52)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtCPF)
                            .addComponent(txtdatanascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(txtestadocivil, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdatanascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSalvar))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String estadocivil = txtestadocivil.getText();
        String cpf = txtCPF.getText();
        String datanascimento = txtdatanascimento.getText();
        DB db = new DB("bancodados.db");
        String query = "";
        if(id == -1) {
            query = "INSERT INTO funcionarios (nome, dataNascimento, estadoCivil,cpf) ";
            query = query + "VALUES (";
            query = query + "'" + nome + "',";
            query = query + "'" + datanascimento + "',";
            query = query + "'" + estadocivil + "',";
            query = query + "'" + cpf+ "'";
            query = query + ");";            
        } else {
            query = "UPDATE funcionarios SET ";
            query = query + "nome='" + nome + "', ";
            query = query + "cpf='" + cpf + "', ";
            query = query + "datanascimento='" + datanascimento + "'";
            query = query + " WHERE id="+this.id; 
        }
        db.execQuery(query);
        janelaFuncionarios.refreshTable();
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtdatanascimento;
    private javax.swing.JTextField txtestadocivil;
    // End of variables declaration//GEN-END:variables
}
