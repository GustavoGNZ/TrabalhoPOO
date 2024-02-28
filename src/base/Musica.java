package base;

public class Musica {

    private int ID_Musica;
    private int ID_Album;
    private String nome;
    private double duracao;


    public int getID_Musica() {
        return ID_Musica;
    }

    public void setID_Musica(int ID_Musica) {
        this.ID_Musica = ID_Musica;
    }

    public int getID_Album() {
        return ID_Album;
    }

    public void setID_Album(int ID_Album) {
        this.ID_Album = ID_Album;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}
