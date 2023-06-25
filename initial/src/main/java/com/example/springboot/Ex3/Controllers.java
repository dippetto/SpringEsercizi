package com.example.springboot.Ex3;

package com.example.springboot.esercizio3;

import com.example.springboot.Ex2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controllers {
    private List<Meal> mealList = new ArrayList<>();

   //EX 1
    @PostMapping("/put/meals")
    public ResponseEntity<String> putMeals(@RequestBody Meal meal) {
        this.mealList.add(meal);
        return ResponseEntity.ok("Pasto aggiunto");
    }

    @GetMapping("get/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealList);
    }


    //EX 2

    @PostMapping("/meal/update/{name}")
    public ResponseEntity<String> renameMeals(@PathVariable String mealName, @RequestBody Meal newMeal) {
        for (Meal meal1 : this.mealList) {
            if (meal1.getNome().equals(mealName)) {
                mealList.remove(meal1);
                mealList.add(newMeal);
            }
        }
        return ResponseEntity.ok("Pasto aggiornato");
    }

    //EX 3
    @DeleteMapping("/meal/delete/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        for (Meal m : this.mealList) {
            if (m.getNome().equals(name)) {
                mealList.remove(m);
            }
        }
        return ResponseEntity.ok("Pasto eliminato");
    }


 //EX 4

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteByPrice(@PathVariable Double prezzo) {
        for (Meal m : this.mealList) {
            if (m.getPrezzo() > prezzo) {
                mealList.remove(m);
            }
        }
        return ResponseEntity.ok("Rimossi i pasti con prezzo superiore a: " + prezzo);
    }


    //EX 5

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updatePrizeByName(@PathVariable String nome, @RequestBody Double prezzo){
        for (Meal m : this.mealList) {
            if (m.getNome().equals(nome)) {
                m.setPrezzo(prezzo);
            }
        }
        return ResponseEntity.ok("ok");
    }
}