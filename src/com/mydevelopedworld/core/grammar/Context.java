package com.mydevelopedworld.core.grammar;

import java.util.HashMap;

import com.mydevelopedworld.core.grammar.exception.VariableNotFoundException;

public class Context {
	
	private HashMap<String, Integer> context = new HashMap<String, Integer>();
	
	public void assign(String var, int value){
		this.context.put(var, value);
	}
	
	public int lookup(String var) throws VariableNotFoundException{
		if(!this.context.containsKey(var)){
			throw new VariableNotFoundException("Variable: ["+var+"] not found in Context!");
		}
		return this.context.get(var);
	}

	public String toString(){
		return context.toString();
	}

}
