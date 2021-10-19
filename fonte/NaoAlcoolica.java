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
        this.isAlcool = false;
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

            System.out.print("\n\n!! Sem estoque suficiente para esta venda !!\n");
            System.out.print(">> Restam " + this.stock + " unidades <<");
            System.out.print("\n\n>> Refaca seu pedido com uma quantidade aceitavel <<\n");
        
        } else {

            this.stock = this.stock - qnt;
            System.out.print("\n\n>> Compra efetuada com sucesso! <<\n");
            System.out.print("\n!! Estoque atualizado !!\n");
        
        }
    }

}
