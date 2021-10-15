package fonte;


public class NaoAlcoolica extends Bebida{


 /**
  * Constructor
  * 
  * @param code
  * @param name
  * @param content
  * @param price
  * @param stock
  */
    public NaoAlcoolica(String code, String name, int content, double price, int stock){
        this.code = code;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;

    }
    





/**
 * Efetua compra de bebidas;
 * 
 * @param qnt -> Quantidade de bebidas compradas;
 */
    public void compraBebida(int qnt) {
        this.stock += qnt;
    }

    

/**
 * Efetua venda de bebidas;
 * 
 * @param qnt -> Quantidade de bebidas vendidas;
 * @param maior18 -> Verifica se pode vender ou não;
 */
    public void vendeBebida(int qnt, boolean maior18){

        if (qnt > this.stock) {

            System.out.println("Sem estoque! Restam " + this.stock + " unidades.");
            System.out.println("Refaca seu pedido !!!");
        
        } else {

            this.stock = this.stock - qnt;
            System.out.println("Compra efetuada com sucesso !!!");
            System.out.println("estoque atualizado! ");
        
        }
    }

}
