package com.mydevelopedworld.core.grammar;

import java.util.HashMap;

import com.mydevelopedworld.core.grammar.exception.VariableNotFoundException;

public class Context {
	
	private HashMap<String, Double> context = new HashMap<String, Double>();
	
	public void assign(String var, double value){
		this.context.put(var, value);
	}
	
	public double lookup(String var) throws VariableNotFoundException{
		if(!this.context.containsKey(var)){
			throw new VariableNotFoundException("Variable: ["+var+"] not found in Context!");
		}
		return this.context.get(var);
	}

	public String toString(){
		return context.toString();
	}

}
