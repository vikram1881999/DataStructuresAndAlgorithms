package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {

  public static void main( String[] args ) {
    String[] recipes = {"bread","sandwich","burger"};
    List<List<String>> ingredients = List.of( List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread"));
    String[] supplies = {"yeast","flour","meat"};
    FindAllPossibleRecipesFromGivenSupplies allPossibleRecipesFromGivenSupplies = new FindAllPossibleRecipesFromGivenSupplies();
    System.out.println(allPossibleRecipesFromGivenSupplies.findAllRecipes(recipes, ingredients, supplies));
  }



   public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Set<String>> dependency = new HashMap<>();
        Queue<String> cookQueue = new LinkedList<>();
        List<String> cookedRecipes = new ArrayList<>();
        for( int i = 0; i < recipes.length; i++ ) {
            String recipe = recipes[i];
            List<String> recipeIngredients = ingredients.get(i);
            for( String ingredient: recipeIngredients ) {
                List<String> dependentRecipes = adjMap.getOrDefault(ingredient, new ArrayList<>());
                dependentRecipes.add( recipe );
                adjMap.put(ingredient, dependentRecipes);
                Set<String> set = dependency.getOrDefault(recipe, new HashSet<>());
                set.add(ingredient);
                dependency.put( recipe, set );
            }
        }

        for( String supply: supplies ) {
            cookQueue.add( supply );
        }

        while( !cookQueue.isEmpty() ) {
            String ingredient = cookQueue.remove();
            if( !adjMap.containsKey(ingredient) ) {
                continue;
            }
            for( String recipe: adjMap.get(ingredient)) {
                Set<String> recipeSupplies = dependency.get(recipe);
                recipeSupplies.remove( ingredient );
                if( recipeSupplies.size() == 0 ) {
                    cookQueue.add(recipe);
                }
            } 
        }

        for( Map.Entry<String, Set<String>> entry: dependency.entrySet() ) {
            if( entry.getValue().size() == 0 ) {
                cookedRecipes.add(entry.getKey());
            }
        }

        return cookedRecipes;
    }
  
}
