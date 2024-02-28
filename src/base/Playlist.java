package base;

public class Playlist {

    private int ID_Playlist;
    private int ID_Usuario;
    private String nome;
    private String descricao;

    // Métodos getters e setters
    public int getID_Playlist() {
        return ID_Playlist;
    }

    public void setID_Playlist(int ID_Playlist) {
        this.ID_Playlist = ID_Playlist;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

