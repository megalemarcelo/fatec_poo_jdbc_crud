import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

    //mapeamento objeto relacional
    //ORM: Hibernate, EclipseLink
    public void inserir() throws Exception{
        //1. Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
        //2. Abrir uma conexão com o MySQL Server
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConnection();
        //3. Preparar o comando (solicitar ao MySQL Server que compile o comando SQL previamente)
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir os eventuais placeholders
        ps.setString(1, nome);
        ps.setString(2, fone);
        ps.setString(3, email);
        //5. Executar o comando
        ps.execute();
        //6. Fechar os recursos (conexão e o comando preparado)
        ps.close();
        conexao.close();
    }

    public void atualizar() throws Exception{
        //1. Especificar o comando SQL (UPDATE)
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE cod_pessoa = ?";
        //2. Abrir uma conexão com o MySQL Server
        ConnectionFactory factory = new ConnectionFactory();
        //try-with-resources (desde a versão 7 do Java SE)
        try(Connection conexao = factory.getConnection();
                //3. Preparar o comando
                PreparedStatement ps = conexao.prepareStatement(sql)){
            //4. Substituir os placeholders
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            //5. Executar o comando
            ps.execute();
            //6. Fechar os recursos: já está feito pelo try-with-resources
        }
    }

    public void apagar() throws Exception{
        //1. Especificar o comando SQL (DELETE por código)
        String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
        //2. Abrir uma conexão com o MySQL Server (Usando try-with-resources do Java 7)
        try(
            Connection conexao = new ConnectionFactory().getConnection();
            //3. Preparar o comando
            PreparedStatement ps = conexao.prepareStatement(sql);
        ){
            //4. Substituir os placeholders
            ps.setInt(1, codigo);
            //5. Executar o comando
            ps.execute();
        }
    }

    public static void listar() throws Exception{
        //1. Especificar o comando SQL (SELECT)
        String sql = "SELECT * FROM tb_pessoa";
        //2. Abrir uma conexão (usando try-with-resources)
        //3. Preparar o comando
        try(
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            //4. Substituir os eventuais placeholders
            //5. Executar o comando
            java.sql.ResultSet rs = ps.executeQuery();
            ){            
            //6. Tratar o resultado (pois ele é uma tabela)
            while(rs.next()){
                int codigo = rs.getInt("cod_pessoa");
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                System.out.printf(
                    "código: %d, nome: %s, fone: %s, e-mail: %s\n",
                    codigo, nome, fone, email
                );
            }           

        }
    }

    public Pessoa (String nome, String fone, String email){
        this(0, nome, fone, email);    
    }

    public Pessoa(int codigo, String nome, String fone, String email){
        setCodigo(codigo);
        setNome(nome);
        setFone(fone);
        setEmail(email);
    }

    public Pessoa(int codigo){
        this(codigo, null, null, null);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }
    public String getFone() {
        return fone;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
