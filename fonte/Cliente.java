package fonte;


/* Classe para Clientes */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)

public class Cliente {

    private String clientName;
    private String clientCode;
    private String clientCPF;
    private boolean maior18;
    private boolean podeFiado;


    /**
     * Constructor
     * 
     * @param clientName
     * @param clientCode
     * @param clientCPF
     * @param maior18
     * @param podeFiado
     */
    public Cliente(String clientName, String clientCode, String clientCPF, boolean maior18, boolean podeFiado){
        this.clientName = clientName;
        this.clientCode = clientCode;
        this.clientCPF = clientCPF;
        this.maior18 = maior18;
        this.podeFiado = podeFiado;
    }


    /**
     * Setter
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Getter
     * @return -> clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Setter
     * @param clientCode
     */
    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    /**
     * Getter
     * @return -> clientCode
     */
    public String getClientCode() {
        return this.clientCode;
    }

    /**
     * Setter
     * @param clientCPF
     */
    public void setClientCPF(String clientCPF) {
        this.clientCPF = clientCPF;
    }

    /**
     * Getter
     * @return -> ClientCPF
     */
    public String getClientCPF() {
        return this.clientCPF;
    }

    /**
     * Setter
     * @param maior18
     */
    public void setMaior18(boolean maior18) {
        this.maior18 = maior18;
    }

    /**
     * Getter
     * @return -> maior18
     */
    public boolean getMaior18() {
        return this.maior18;
    }

    /**
     * Setter
     * @param podeFiado
     */
    public void setpodeFiado(boolean podeFiado) {
        this.podeFiado = podeFiado;
    }  

    /**
     * Getter
     * @return -> podeFiado
     */
    public boolean getpodeFiado() {
        return this.podeFiado;
    }

}
