Feature: MMT Ticket Booking 
  

  Scenario: BookTickey
    Given User should pass the Login details
    And Lands on HomePage 
    When User clicks on flights Icon 
    Then User should be able to pass flight details to book
    And User should able to search the flight 
    When User clicks on first flight in the search list 
    Then User should be allowed to pass Passenger details and Book ticket  
  