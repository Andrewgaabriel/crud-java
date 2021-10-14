package fonte;

public class Alcoolica extends Bebida{
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
    public Alcoolica(String code, String name, int content, double price, int stock){
        this.code = code;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.IsAlcoolica = true;
    }
    






    public void compraBebida(int qnt) {
        this.stock += qnt;
    }


    public void vendeBebida(int qnt, int age){


        if(age > 18){
            if (qnt > this.stock) {

                System.out.println("Sem estoque! Restam " + this.stock + " unidades.");
                System.out.println("Refaca seu pedido !!!");
            
            } else {
    
                this.stock = this.stock - qnt;
                System.out.println("Compra efetuada com sucesso !!!");
                System.out.println("estoque atualizado! ");
            
            }
        } else {
            System.out.println("Venda recusada! Cliente é menor de idade!");
        }

        
    }

}
