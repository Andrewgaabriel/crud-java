package fonte;

public class NaoAlcoolica extends Bebida{
    public boolean IsAlcoolica;

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
        this.IsAlcoolica = false;
    }
    






    public void compraBebida(int qnt) {
        this.stock += qnt;
    }


    public void vendeBebida(int qnt, int age){

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
