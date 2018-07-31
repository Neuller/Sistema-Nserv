package Beans;


public class ServicosBeans {
    
    private int CodServicos;
    private String Data_Servico;
    private String Genero;
    private String Serial;
    private String Situacao;
    private String Aparelho;
    private String Informacao;
    private String Tecnico;
    private String Garantia;
    private double Valor;
    private int CodCliente;

    public int getCodServicos() {
        return CodServicos;
    }

    public void setCodServicos(int CodServicos) {
        this.CodServicos = CodServicos;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public String getData_Servico() {
        return Data_Servico;
    }

    public void setData_Servico(String Data_Servico) {
        this.Data_Servico = Data_Servico;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
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
