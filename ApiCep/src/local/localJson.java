package local;

public record localJson(String cep, String logradouro, String bairro, String localidade, String estado) {
    public localJson(String cep, String logradouro, String bairro, String localidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
    }

    public String cep() {
        return this.cep;
    }

    public String logradouro() {
        return this.logradouro;
    }

    public String bairro() {
        return this.bairro;
    }

    public String localidade() {
        return this.localidade;
    }

    public String estado() {
        return this.estado;
    }
}
