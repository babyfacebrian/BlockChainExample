/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.lang.*;
import java.util.*;
import java.text.*;

public class BlockChain {
    
    private ArrayList<Block> chain; 
    
    
    public BlockChain(){
        this.chain = new ArrayList<>();
    }
    
    private int gensisHash(){
        Random rand = new Random();
        int start = rand.nextInt(100000);
        int genesis;
        
        if(start <= 3 || start % 2 == 0){
            genesis = 31 * (start + 216);
        }else{
            genesis = 31 * (start + 44202);
        }
        return genesis;
    }
    
    public void insert(){
        Block block;
        int blocknum = this.chain.size();
        
        
        if(this.chain.size()==0){
            System.out.println("GENESIS BLOCK");
            block = new Block(gensisHash());
        }else{
            System.out.println("BLOCK # " + blocknum);
            int p = this.chain.get(this.chain.size()-1).hashCode();
            block = new Block(p);
        }
        this.chain.add(block);
    }
    
    public boolean validBlockChain(){
        for(int i=0; i<this.chain.size(); i++){
            return chain.get(i).hashCode() == chain.get(i+1).getPreviousHash();
        }
        return false;
        
    }
    
    public void output(){
        for(Block b : this.chain){
            System.out.println("BLOCK");
            System.out.println(b);
        }
    }
    
    
    

    
    
    
}
