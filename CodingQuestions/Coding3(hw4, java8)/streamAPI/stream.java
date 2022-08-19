import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        // List<Product> productRepo = new ArrayList<>();
        List<Product> result = productRepo.findAll()
            .stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .filter(p -> p.getPrice() > 100)
            .collect(Collectors.toList());



        List<Order> result2 = orderRepo.findAll()
            .stream()
            .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
            )
            .collect(Collectors.toList());  

        
        List<Product> result3 = productRepo.findAll()
            .stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
            .map(p -> p.withPrice(p.getPrice() * 0.9))
            .collect(Collectors.toList());  

        
        List<Product> result4 = orderRepo.findAll()
            .stream()
            .filter(o -> o.getCustomer().getTier() == 2)
            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
            .flatMap(o -> o.getProducts().stream())
            .distinct()
            .collect(Collectors.toList());

        // Optional<Product> result5 = productRepo.findAll()
        //     .stream()
        //     .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        //     .sorted(Comparator.comparing(Product::getPrice))
        //     .findFirst();

        Optional<Product> result5 = productRepo.findAll()
            .stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .min(Comparator.comparing(Product::getPrice));

        List<Order> result6 = orderRepo.findAll()
            .stream()
            .sorted(Comparator.comparing(Order::getOrderDate).reversed())
            .limit(3)
            .collect(Collectors.toList());

        List<Product> result7 = orderRepo.findAll()
            .stream()
            .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
            .peek(o -> System.out.println(o.toString()))
            .flatMap(o -> o.getProducts().stream())
            .distinct()
            .collect(Collectors.toList());

        Double result8 = orderRepo.findAll()
            .stream()
            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
            .flatMap(o -> o.getProducts().stream())
            .mapToDouble(p -> p.getPrice())
            .sum();	
        
        Double result9 = orderRepo.findAll()
            .stream()
            .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
            .flatMap(o -> o.getProducts().stream())
            .mapToDouble(p -> p.getPrice())
            .average().getAsDouble();
        
        DoubleSummaryStatistics statistics = productRepo.findAll()
            .stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .mapToDouble(p -> p.getPrice())
            .summaryStatistics();
        
        System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
            statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
        
        Map<Long, Integer>  result10 = orderRepo.findAll()
            .stream()
            .collect(
                Collectors.toMap(
                    order -> order.getId(),
                    order -> order.getProducts().size()
                    )
                );
        
        Map<Customer, List<Order>> result11 = orderRepo.findAll()
                .stream()
                .collect(
                    Collectors.groupingBy(Order::getCustomer)
                    );
        
        
        Map<Order, Double> result12 = orderRepo.findAll()
                    .stream()
                    .collect(
                      Collectors.toMap(
                          Function.identity(), 
                          order -> order.getProducts().stream()
                                .mapToDouble(p -> p.getPrice()).sum()
                        ) 
                      );
        Map<String, List<String>> result13 = productRepo.findAll()
                      .stream()
                      .collect(
                          Collectors.groupingBy(
                              Product::getCategory,
                              Collectors.mapping(product -> product.getName(), Collectors.toList()))
                          );
        
        Map<String, Optional<Product>> result14 = productRepo.findAll()
                          .stream()
                          .collect(
                              Collectors.groupingBy(
                                  Product::getCategory,
                                  Collectors.maxBy(Comparator.comparing(Product::getPrice))));
    }
}
