Feature: FlipkartLogin

  Scenario Outline: FlipKartLogin
    Given User should pass the mandatory details
    Then User should land to Home Page and See the logo
    When User should Pass the search Item
    And User should be allowed to search the searched item
    Then User should be able to see the list of products
    And User should be able to select the Product at the top
    Then User should be able to add the product to cart and click on Go to Cart
    And Cart should have that item
    Then User clicks on Place Order

    Feature: MMT Ticket Booking 
  

  Scenario: BookTickey
    Given User should pass the Login details
    And Lands on HomePage 
    When User clicks on flights Icon 
    Then User should be able to pass flight details to book
    And User should able to search the flight 
    When User clicks on first flight in the search list 
    Then User should be allowed to pass Passenger details and Book ticket  
  