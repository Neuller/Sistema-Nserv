package Beans;


public class ServicosBeans {
    
    private int CodServicos;
    private String Data_Servicos;
    private String Tipo;
    private String Situacao;
    private String Aparelho;
    private String Informacao;
    private String Tecnico;
    private String Garantia;
    private double Valor;
    private int Cli_Servicos;

        public int getCodServicos() {
        return CodServicos;
    }

    public void setCodServicos(int CodServicos) {
        this.CodServicos = CodServicos;
    }

    public int getCli_Servicos() {
        return Cli_Servicos;
    }

    public void setCli_Servicos(int Cli_Servicos) {
        this.Cli_Servicos = Cli_Servicos;
    }

    public String getData_Servicos() {
        return Data_Servicos;
    }

    public void setData_Servicos(String Data_Servicos) {
        this.Data_Servicos = Data_Servicos;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = Tipo;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getAparelho() {
        return Aparelho;
    }

    public void setAparelho(String Aparelho) {
        this.Aparelho = Aparelho;
    }

    public String getInformacao() {
        return Informacao;
    }

    public void setInformacao(String Informacao) {
        this.Informacao = Informacao;
    }

    public String getTecnico() {
        return Tecnico;
    }

    public void setTecnico(String Tecnico) {
        this.Tecnico = Tecnico;
    }

    public String getGarantia() {
        return Garantia;
    }

    public void setGarantia(String Garantia) {
        this.Garantia = Garantia;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
  
}
