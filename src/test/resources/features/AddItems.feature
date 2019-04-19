Feature: Adding and modifying items to swiggy cart

  @test
  Scenario: Verify adding and modifying items to cart
    Given I visit the home page
    And I set my deliver location as Indiranagar Bangalore
    When I search and open restaurant Bite Me
    And I add following items to my cart
      | itemName           | count |
      | Red Velvet Cupcake | 2     |
      | Tiramisu  Cupcake  | 2     |
    And I checkout
    Then I should see the following items in my cart
      | itemName           | count |
      | Red Velvet Cupcake | 2     |
      | Tiramisu  Cupcake  | 2     |