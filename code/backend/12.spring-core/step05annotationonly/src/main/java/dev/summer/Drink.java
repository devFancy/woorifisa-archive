package dev.summer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Drink {
   private String name;
   private int price;

   public Drink(@Value("페퍼민트") String name, @Value("5000") int price) {
      super();
      this.name = name;
      this.price = price;
   }

   @Override
   public String toString() {
      return "Drink [name=" + name + ", price=" + price + "]";
   }
}