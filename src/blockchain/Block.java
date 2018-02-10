
package blockchain;

import java.util.*;

public class Block {
    
    private int previousHash;
    private ArrayList<Transaction> ledger;
    
    
    public Block(int previousHash){
        Scanner input = new Scanner(System.in);
        this.previousHash = previousHash;
        this.ledger = new ArrayList<>();
                
        System.out.println("Number of transactions: ");
        int totalTransactions = input.nextInt();
         
        for(int i=0; i<totalTransactions; i++){
            System.out.println("TRANSACTION # : " + (i+1));
            Transaction entry = new Transaction();
            this.ledger.add(entry);
        } 
    } 
    
   
    public int getPreviousHash(){
        return previousHash;
    }
        
    public void getTransactions(){
        System.out.println("_____LEDGER_____");
        for(Transaction t : this.ledger){
            System.out.println(t.toString());
        }
    }
   
    
    @Override
    public String toString(){
        getTransactions();
        
        return("BLOCK INFO:" + "\n" +
                "Previous Hash: " + this.previousHash + "\n" +
                "Block Hash: " + this.hashCode());
    }
    
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }else if(object == null || this.getClass() != object.getClass()){
            return false;
        }
        Block block2 = (Block) object;
        return this.hashCode() == block2.hashCode();
    }
    
    @Override
    public int hashCode(){
        int result = this.previousHash; 
        result = 31 * (result + this.ledger.hashCode());
        return result;
    }
       
}
