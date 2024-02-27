package base;

import java.util.Date;

// Done

public class Usuario {
    private String nome, email, senha, usuario;
    private Date dataNasc, dataInicio, dataFim;
    private int ID_Assinatura;
    private double ID_Usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getID_Assinatura() {
        return ID_Assinatura;
    }

    public void setID_Assinatura(int ID_Assinatura) {
        this.ID_Assinatura = ID_Assinatura;
    }

    public double getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(double ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", usuario='" + usuario + '\'' +
                ", dataNasc=" + dataNasc +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", ID_Assinatura=" + ID_Assinatura +
                ", ID_Usuario=" + ID_Usuario +
                '}';
    }
}
