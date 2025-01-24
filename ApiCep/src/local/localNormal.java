package local;

public class localNormal {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public localNormal(localJson localCep) {
        this.cep = localCep.cep();
        this.rua = localCep.logradouro();
        this.bairro = localCep.bairro();
        this.cidade = localCep.localidade();
        this.estado = localCep.estado();
    }

    public String toString() {
        return String.format("Informacoes:\n  CEP: %-15s\n  Rua: %-30s\n  Bairro: %-25s\n  Cidade: %-25s\n  Estado: %-20s\n ", this.cep, this.rua, this.bairro, this.cidade, this.estado);
    }
}
