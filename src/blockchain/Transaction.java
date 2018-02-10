/*
 * Transaction template class
 */
package blockchain;

import java.lang.*;
import java.util.*;
import java.text.*;


public class Transaction {
    
    private String sourceName;
    private String destionationName;
    private Double amount;
    
    public Transaction(){
        Scanner input = new Scanner(System.in); 
        
        System.out.println("Enter in debit name: ");
        String startname = input.next();
        this.sourceName = startname;
        
        System.out.println("Enter in credit name: ");
        String endName = input.next();
        this.destionationName = endName;
        
        System.out.println("Enter in Dollar amount: ");
        Double sum = input.nextDouble();
        this.amount = sum;
    }
    
    
    @Override
    public String toString(){
        return("FROM: " + sourceName + " | TO: " + destionationName + " | AMOUNT: $" + amount + "\n");
    }
    
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }else if(object == null || this.getClass() != object.getClass()){
            return false;
        }
        
        Transaction trans = (Transaction) object;
        
        if(this.sourceName != null && trans.sourceName != null){
            return this.sourceName.equals(trans.sourceName);
        }
        
        if(this.destionationName != null && trans.destionationName != null){
            return this.destionationName.equals(trans.destionationName);
        }
        
        if(this.amount != null && trans.amount != null){
            return this.amount.equals(trans.amount);
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        int result;
        
        if(this.sourceName != null && this.destionationName != null && this.amount != null){
            result = this.sourceName.hashCode();
            result = 31 * (result + this.destionationName.hashCode());
            result = 31 * (result + this.amount.hashCode());
        }else{
            result = 0;
        }
        return result;
        
    }
    
    
}
