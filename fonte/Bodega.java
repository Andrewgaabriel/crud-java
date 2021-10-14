package fonte;

/* Dados gerais da Bodega */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)


class Bodega {
    
    private String name;
    private String Cnpj;


    /**
     * Getter
     * 
     * @return -> name of Bodega;
     */
    public String getName() {
        return this.name;
    }


    /**
     * Setter
     * 
     * -> Set name of Bodega;
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Getter
     * 
     * @return -> CNPJ of Bodega;
     */
    public String getCnpj() {
        return this.Cnpj;
    }


    /**
     * Setter
     * 
     * -> Set CNPJ of Bodega;
     */    
    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
}
