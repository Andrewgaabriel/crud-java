package fonte;


/* Classe abstrata para bebidas */

// Andrew Gabriel  (andrew.gabrielgomes@gmail.com)

public abstract class Bebida {

    protected String code;
    protected String name;
    protected int content;
    protected double price;
    protected int stock;



/**
 * Setter 
 * 
 * @param code -> Codigo da bebida;
 */
    public void setCode(String code) {
        this.code = code;
    }



/**
 * Getter
 * 
 * @return -> Código da bebida;
 */
    public String getCode(){
        return this.code;
    }


/**
 * Setter
 * 
 * @param name -> Nome da bebida;
 */
    public void setName(String name) {
        this.name = name;
    }


/**
 * Getter
 * 
 * @return -> Nome da bebida;
 */
    public String getName(){
        return this.name;
    }


/**
 * Setter
 * 
 * @param content -> Conteudo da bebida
 */
    public void setContent(int content) {
        this.content = content;
    }


/**
 * Getter
 * 
 * @return -> Conteúdo da bebida;
 */    
    public int getContent() {
        return this.content;
    }


/**
 * Setter
 * 
 * @param price -> Preço da bebida;
 */
    public void setPrice(double price){
        this.price = price;
    }


/**
 *Getter
 * 
 * @return -> Preço da bebida;
 */
    public double getPrice(){
        return this.price;
    }


/**
 * Setter
 * 
 * @param stock -> Estoque da bebida;
 */    
    public void setStock(int stock){
        this.stock = stock;
    }


/**
 * Getter
 * 
 * @return -> Estoque da bebida;
 */    
    public int getStock(){
        return this.stock;
    }


/**
 * Compra bebida;
 * 
 * @param qnt
 */
    public abstract void compraBebida(int qnt);


/**
 * 
 * @param qnt -> Quantidade comprada
 */
    public abstract void vendeBebida(int qnt, boolean maior18);

}
